package pages;

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


    public void inputLog(String name) {
        userName.sendKeys(name);
    }

    public void inputPass(String password) {
        inputPassword.sendKeys(password);
        submitInput.click();
    }
}
