package pages;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.io.File;

public class AbstractPage {

    WebDriver webDriver;
    WebDriverWait webDriverWait;

    public AbstractPage(WebDriver webDriver, WebDriverWait webDriverWait) {

        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 10);
        PageFactory.initElements(webDriver, this);
    }

}
