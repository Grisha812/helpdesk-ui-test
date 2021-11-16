import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.internal.bytebuddy.build.Plugin;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPage;
import pages.LoginPage;

import java.io.IOException;


public class HelpdeskUITest   {

    WebDriver webDriver;
    WebDriverWait webDriverWait;

    @BeforeAll
    public static void startBrowser() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
            void setupBrowser()  {

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, 10);
    }

    /*@Test
    @DisplayName("Тупо открываем стартовую страницу")
    public void createTicketTest() {
        webDriver.get("https://at-sandbox.workbench.lanit.ru/");
        webDriver.quit();
    }*/

    @Test
    @DisplayName("Логинимся")
    public void loginTest() {

        webDriver.get("https://at-sandbox.workbench.lanit.ru/login/?next=/");
        new LoginPage(webDriver)
        .loginClick();
        webDriver.quit();
    }

}
