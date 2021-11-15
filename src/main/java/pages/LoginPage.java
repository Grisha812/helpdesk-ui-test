package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//i[@class='fas fa-fw fa-sign-in-alt']")
    public WebElement loginButton;
    @FindBy(xpath = "//button[normalize-space()='Submit Ticket']")
    public WebElement submitTicket;
    @FindBy(xpath = "//select[@id='id_queue']")
    public WebElement queueID;
    @FindBy(xpath = "//input[@id='id_title']")
    public WebElement summaryProblem;
    @FindBy(xpath = "//textarea[@id='id_body']")
    public WebElement descriptionIssue;
    @FindBy(xpath = "//select[@id='id_priority']")
    public WebElement priority;
    @FindBy(xpath = "//input[@id='id_due_date']")
    public WebElement dueOn;
    @FindBy(xpath = "//input[@id='id_submitter_email']")
    public WebElement emailSubmitter;
    @FindBy(xpath = "//label[contains(text(),'Username')]")
    public WebElement userName;
    @FindBy(xpath = "//label[contains(text(),'Password')]")
    public WebElement inputPassword;
    @FindBy(xpath = "//input[@value='Login']")
    public WebElement submitInput;


    public LoginPage loginClick() {
        WebDriverManager.chromedriver().setup();
        userName.click();
        userName.sendKeys("admin");
        inputPassword.click();
        inputPassword.sendKeys("adminat");
        submitInput.click();
        return this;

    }
}
