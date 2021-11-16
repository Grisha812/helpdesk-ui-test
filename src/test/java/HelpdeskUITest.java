import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.MainPage;
import pages.TicketsPage;



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

    @AfterEach
    void tearFall() {
        webDriver.quit();
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
    public void loginTest() {
        webDriver.get("https://at-sandbox.workbench.lanit.ru/login/?next=/");
        LoginPage loginPage = new LoginPage(webDriver, webDriverWait);
        loginPage.inputLog("admin");
        loginPage.inputPass("adminat");
        TicketsPage ticketsPage = new TicketsPage(webDriver, webDriverWait);
        ticketsPage.searchTicket("Очень важная проблема");
    }

    @Test
    @Order(3)
    @DisplayName("Проверяем введённую инфу в тикете")
    public void checkTicketTest() {
        webDriver.get("https://at-sandbox.workbench.lanit.ru/tickets/382/");
        LoginPage loginPage = new LoginPage(webDriver, webDriverWait);
        loginPage.inputLog("admin");
        loginPage.inputPass("adminat");
        WebElement description = webDriver.findElement(By.cssSelector("td[id='ticket-description'] p"));
        WebElement submitterEmail = webDriver.findElement(By.xpath("//tbody/tr[2]/td[2]"));
        WebElement dueDate = webDriver.findElement(By.xpath("//td[contains(text(),'Nov. 17, 2021')]"));
        WebElement priority = webDriver.findElement(By.xpath("//td[contains(text(),'2. High')]"));
        //ниже написал 4 проверки, надеюсь, хватит, рутина =)

        Assertions.assertEquals("proverka@po4ty.ru", submitterEmail.getText());
        Assertions.assertEquals("Описание самой важной проблемы", description.getText());
        //ниже тест может падать, потому что там скрипт высчитывания часов после публикации и он меняется (5 hours from now)
        Assertions.assertEquals("Nov. 17, 2021, midnight (4 hours from now)", dueDate.getText());
        Assertions.assertEquals("2. High", priority.getText());
    }
   /* @Attachment (value = "Скриншот", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }*/
}
