package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {

    public MainPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }


    @FindBy(xpath = "(//span[contains(text(),'Университет')])[2]")
    private WebElement univer;

    @FindBy(xpath = "(//span[contains(text(),'Образование')])[2]")
    private WebElement obraz;

    @FindBy(xpath = "(//span[contains(text(),'Наука')])[2]")
    private WebElement nauka;

    @FindBy(xpath = "(//span[contains(text(),'Развитие')])[2]")
    private WebElement razvit;

    @FindBy(xpath = "(//span[contains(text(),'Сотрудничество')])[2]")
    private WebElement souz;

    @FindBy(xpath = "(//span[contains(text(),'Справочник')])[2]")
    private WebElement spravka;

    // локаторы на заголовки разделов

    @FindBy(xpath = "//h1[contains(text(),'Университет сегодня')]")
    private WebElement universitet;

    @FindBy(xpath = "//h1[contains(text(),'Образование в ВолгГТУ')]")
    private WebElement learn;

    @FindBy(xpath = "//h1[contains(text(),'Наука в ВолгГТУ')]")
    private WebElement science;

    @FindBy(xpath = "//h1[contains(text(),'Вопросы перспективного развития')]")
    private WebElement evolution;

    @FindBy(xpath = "//h1[contains(text(),'Сотрудничество')]")
    private WebElement ourjob;

    @FindBy(xpath = "//h1[contains(text(),'Справочник')]")
    private WebElement findbook;

    @FindBy(xpath = "//img[@alt='ВолгГТУ']")
    private WebElement firstTitle;

    public void checkNamesTitle(){firstTitle.getText();}

    public String getTextUniverTitle() {
        return universitet.getText();
    }
    public String getTextObrazTitle() {
        return learn.getText();
    }
    public String getTextNaukaTitle() {
        return science.getText();
    }
    public String getTextRazvitTitle() {
        return evolution.getText();
    }
    public String getTextSouzTitle() {
        return ourjob.getText();
    }
    public String getTextSpravkaTitle() {
        return findbook.getText();
    }


    public void fillTicketFields () {

        univer.click();
        obraz.click();
        nauka.click();
        razvit.click();
        souz.click();
        spravka.click();

        return;

        // проверка соответствия названия заголовка раздела
    }
    /*public String getTextUniverTitle() {
        return universitet.getText();
    }
    public String getTextObrazTitle() {
        return learn.getText();
    }
    public String getTextNaukaTitle() {
        return science.getText();
    }
    public String getTextRazvitTitle() {
        return evolution.getText();
    }
    public String getTextSouzTitle() {
        return ourjob.getText();
    }
    public String getTextSpravkaTitle() {
        return findbook.getText();
    }*/
}
