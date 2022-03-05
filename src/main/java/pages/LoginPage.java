package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }



@FindBy(xpath = "(//a)[116]")
    private WebElement menuStud;
    @FindBy(xpath = "//ul[@class='submenu']//a[contains(text(),'Файловое хранилище')]")
    private WebElement fileSave;
    @FindBy(xpath = "//input[@id='edit-name']")
    private WebElement login;
    @FindBy(xpath = "//input[@id='edit-pass']")
    private WebElement pass;
    @FindBy(xpath = "//a[contains(text(),'Факультет подготовки и переподготовки инженерных к')]")
    private WebElement fpic;
    @FindBy(xpath = "//a[contains(text(),'Выйти')]")
    private WebElement exit;
    @FindBy(xpath = "//a[contains(text(),'Файловое хранилище ВолгГТУ')]")
    private WebElement inStorage;

    public void inputLog(String name) { login.sendKeys(name); }

    public void inputPass(String password) throws InterruptedException {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(menuStud).build().perform();
        TimeUnit.SECONDS.sleep(3);
        fileSave.click();
        TimeUnit.SECONDS.sleep(3);
        pass.sendKeys(password);
        TimeUnit.SECONDS.sleep(3);
        fpic.click();
        TimeUnit.SECONDS.sleep(3);
        exit.click();


   /* public LoginPage auth (String loginValue, String passValue) {

        Actions actions = new Actions(webDriver);
        actions.moveToElement(menuStud).build().perform();
        fileSave.click();
        login.sendKeys(loginValue);
        pass.sendKeys(passValue, Keys.ENTER);
        fpic.click();
        exit.click();

        return this;*/

    }
}
