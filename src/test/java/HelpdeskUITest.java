import ch.qos.logback.core.joran.event.BodyEvent;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.MainPage;
import pages.TicketsPage;

import java.io.IOException;

import static pages.LoginPage.*;


public class HelpdeskUITest {

    WebDriver webDriver;
    WebDriverWait webDriverWait;

    @BeforeAll
    public static void startBrowser() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, 10);
    }

    @Test
    @Order(1)
    @DisplayName("Заполняем поля тикета")
    public void fillTicketFieldsTest() {
        webDriver.get("https://at-sandbox.workbench.lanit.ru");
        MainPage mainPage = new MainPage(webDriver, webDriverWait);
        mainPage.fillTicketFields("Очень важная проблема", "Описание самой важной проблемы", "proverka@po4ty.ru");

    }

    @Test
    @Order(2)
    @DisplayName("Логинимся и ищем наш тикет")
    public void loginTest() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver, webDriverWait);
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("my.properties"));
        webDriver.get("https://at-sandbox.workbench.lanit.ru/login/?next=/");
        loginPage.inputLog(System.getProperty("login"));
        loginPage.inputPass(System.getProperty("password"));
        TicketsPage ticketsPage = new TicketsPage(webDriver, webDriverWait);
        ticketsPage.searchTicket("Очень важная проблема");

    }

    @Test
    @Order(3)
    @DisplayName("Проверяем введённую инфу в тикете")
    public void checkTicketTest() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("my.properties"));
        webDriver.get("https://at-sandbox.workbench.lanit.ru/tickets/382/");
        LoginPage loginPage = new LoginPage(webDriver, webDriverWait);
        loginPage.inputLog(System.getProperty("login"));
        loginPage.inputPass(System.getProperty("password"));
        Assertions.assertEquals("proverka@po4ty.ru", submitterEmail.getText());
        Assertions.assertEquals("Описание самой важной проблемы", description.getText());
        Assertions.assertTrue(dueDate.getText().contains("Nov. 17, 2021, midnight"));
        Assertions.assertEquals("2. High", priority.getText());
    }

    @Attachment(value = "Attachment Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterEach
    public void onTestFailure() {
        makeScreenshot();
    }

    @AfterEach
    public void tearsFall() {
        webDriver.quit();
    }
}
