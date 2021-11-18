package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    @FindBy(xpath = "//i[@class='fas fa-fw fa-sign-in-alt']")
    public WebElement loginButton;
    @FindBy(name = "username")
    public WebElement userName;
    @FindBy(name = "password")
    public WebElement inputPassword;
    @FindBy(xpath = "//input[@value='Login']")
    public WebElement submitInput;
    @FindBy(css = "td[id='ticket-description'] p")
    public static WebElement description;
    @FindBy(xpath = "//tbody/tr[2]/td[2]")
    public static WebElement submitterEmail;
    @FindBy(xpath = "//td[contains(text(),'Nov. 17, 2021')]")
    public static WebElement dueDate;
    @FindBy(xpath = "//td[contains(text(),'2. High')]")
    public static WebElement priority;


    public void inputLog(String name) {
        userName.sendKeys(name);
    }

    public void inputPass(String password) {
        inputPassword.sendKeys(password);
        submitInput.click();
    }
}
