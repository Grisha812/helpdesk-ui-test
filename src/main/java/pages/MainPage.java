package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {

    public MainPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

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
    @FindBy(xpath = "//a[normalize-space()='17']")
    public WebElement chooseDue;
    @FindBy(xpath = "//input[@id='id_submitter_email']")
    public WebElement emailSubmitter;
    @FindBy(xpath = "//option[contains(text(),'Django Helpdesk')]")
    public WebElement django;
    @FindBy(xpath = "//option[contains(text(),'2. High')]")
    public WebElement highPriority;


    public void fillTicketFields(String summary, String description, String email) {
        queueID.click();
        django.click();
        summaryProblem.sendKeys(summary);
        descriptionIssue.sendKeys(description);
        priority.click();
        highPriority.click();
        dueOn.click();
        chooseDue.click();
        emailSubmitter.sendKeys(email);
        submitTicket.click();
    }
}
