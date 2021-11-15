package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbstractPage {

    WebDriver webDriver;
    WebDriverWait webDriverWait;


    public AbstractPage(WebDriver webDriver) {

        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 10);
        PageFactory.initElements(webDriver, this);
    }

}
