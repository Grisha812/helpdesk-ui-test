import ch.qos.logback.core.joran.event.BodyEvent;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
    }

    @BeforeEach
    void setupBrowser() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, 10);
        Assertions.assertDoesNotThrow( ()-> webDriver.navigate().to("https://www.vstu.ru"),
                "Сайт VSTU недоступен! Всё пропало! ");
    }

    @Test
    @Order(1)
    @DisplayName("Переход по вкладкам сайта")
    public void fillTicketFieldsTest() {
        webDriver.get("https://www.vstu.ru");
        MainPage mainPage = new MainPage(webDriver, webDriverWait);
        mainPage.checkNamesTitle();

        String title = webDriver.getTitle();

        Assertions.assertEquals("Университет сегодня", mainPage.getTextUniverTitle());
        Assertions.assertEquals("Образование в ВолгГТУ", mainPage.getTextObrazTitle());
        Assertions.assertEquals("Наука в ВолгГТУ", mainPage.getTextNaukaTitle());
        Assertions.assertEquals("Вопросы перспективного развития", mainPage.getTextRazvitTitle());
        Assertions.assertEquals("Сотрудничество", mainPage.getTextSouzTitle());
        Assertions.assertEquals("Справочник", mainPage.getTextSpravkaTitle());

        return;
    }

    @Test
    @Order(2)
    @DisplayName("Авторизация в файловом хранилище")
    public void loginTest() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(webDriver, webDriverWait);
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("my.properties"));
        webDriver.get("https://www.vstu.ru");

        loginPage.inputLog(System.getProperty("login"));
        loginPage.inputPass(System.getProperty("password"));

        /*String loginValue = "fpik";
        String passValue = "guest";
        loginPage.auth(loginValue, passValue);*/

        String title = webDriver.getTitle();

        Assertions.assertEquals(title, "Главная страница | Файловое хранилище ВолгГТУ");

        String result = webDriver.findElement(By.xpath("//input[@id='edit-name']")).getText();
        Assertions.assertEquals("", result);

    }

    @Test
    @Order(3)
    @DisplayName("Проверка поисковой выдачи")
    public void checkTicketTest() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("my.properties"));
        webDriver.get("https://www.vstu.ru");
        TicketsPage ticketsPage = new TicketsPage(webDriver, webDriverWait);

        String inputSearch = "тестирование";
        ticketsPage.searchTicket(inputSearch);
    }

    @After
    public void tearDown(){
        webDriver.close();
        webDriver.quit();
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
