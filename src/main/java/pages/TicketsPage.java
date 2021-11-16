package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TicketsPage extends AbstractPage {

    public TicketsPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    @FindBy(xpath = "//input[@id='search_query']")
    public WebElement searchField;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement searchGo;
    @FindBy(linkText = "382. Очень важная проблема")
    public WebElement searchResult;
    @FindBy(xpath = "//td[contains(text(),'Nov. 17, 2021, midnight (7 hours from now)')]")
    public WebElement DueDate;

    public void searchTicket(String search) {
        searchField.sendKeys(search);
        searchGo.click();
    }

}
