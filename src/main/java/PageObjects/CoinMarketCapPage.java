package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CoinMarketCapPage {

    WebDriver driver;

    public CoinMarketCapPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements( driver, this );
    }

    //Locators

    @FindBy(css = "[class='tippy-content'] button")
    WebElement showRowsButtons;

    @FindBy(xpath = "//*[contains(text(),'Show rows')]/following-sibling::div")
    WebElement showRows;

    @FindBy(xpath = "//button[contains(text(),'Filters')]")
    WebElement filtersBtn;

    @FindBy(xpath = "//button[contains(text(),'Add Filter')]")
    WebElement addFilterBtn;

    @FindBy(xpath = "//button[contains(text(),'Market Cap')]")
    WebElement marketCapBtn;

    @FindBy(css="[data-qa-id='range-filter-input-min']")
    WebElement rangeFilterInputMin;

    @FindBy(css="[data-qa-id='range-filter-input-max']")
    WebElement rangeFilterInputMax;

    @FindBy(xpath = "//button[contains(text(),'Price')]")
    WebElement priceBtn;


    public WebElement getShowRowsButtons() {
        return showRowsButtons;
    }

    public WebElement getShowRows() {
        return showRows;
    }

    public WebElement getPriceBtn(){
        return priceBtn;
    }

    public WebElement getRangeFilterInputMax(){
        return rangeFilterInputMax;
    }

    public WebElement getRangeFilterInputMin(){
        return rangeFilterInputMin;
    }

    public WebElement getMarketCapBtn(){
        return marketCapBtn;
    }

    public WebElement getAddFilterBtn(){
        return addFilterBtn;
    }

    public WebElement getFiltersBtn(){
        return filtersBtn;
    }






    //functions
    public void clickOnShowRows() {
        getShowRows().click();
    }

    public void goToFilters() {
        WebElement filterButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/div[2]/div/div/div[1]/div[2]/div[3]/div[2]/button[1]"));
        filterButton.click();
        WebElement addFilterButton =driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/div[2]/div/div/ul/li[5]"));
        addFilterButton.click();
    }

    public void selectShowRow(String row) throws InterruptedException {
        WebElement element =driver.findElement(By.xpath("//button[contains(text(),"+ row +")]"));
        element.click();
    }


    public void verifyRowCount(int rows) {
        List<WebElement> actualRows = driver.findElements(By.cssSelector("table > tbody > tr"));
        assertEquals(actualRows.size(), rows);
    }


    public void enterMarketCapRange(String min, String max) throws InterruptedException {
        Thread.sleep(2000);
        WebElement close = driver.findElement(By.xpath("//div[@class='sc-1wyjcwq-0 hELUpj']//*[local-name()='svg']//*[name()='path' and contains(@d,'M18 6L6 18')]"));
        close.click();
        WebElement marketCapButton = driver.findElement(By.xpath("//button[normalize-space()='Market Cap']"));
//        marketCapButton.click();
        getMarketCapBtn().click();
        getRangeFilterInputMin().sendKeys( min ); //1,000,000,000
        getRangeFilterInputMax().sendKeys( max ); //10,000,000,000

    }

    public void enterPriceRange(String min, String max)
    {
        getPriceBtn().click();
        getRangeFilterInputMin().sendKeys( min ); //101
        getRangeFilterInputMax().sendKeys( max ); //1,000
    }













}
