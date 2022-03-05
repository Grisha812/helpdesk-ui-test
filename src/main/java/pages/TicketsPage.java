package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TicketsPage extends AbstractPage {

    public TicketsPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }


    @FindBy(xpath = "//span[@class='sb-icon-search']")
    private WebElement search;

    @FindBy(xpath = "//input[@id='search']")
    private WebElement inputSearch;

    public void searchTicket(String inputSearchValue) {
        inputSearch.sendKeys(inputSearchValue);
        inputSearch.submit();
        return;
    }
}
