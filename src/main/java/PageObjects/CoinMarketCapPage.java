package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

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

    public void goToFilters()
    {
        getFiltersBtn().click();
        getAddFilterBtn().click();
    }

    String updatedShowRow;
    public void selectShowRow(String row) throws InterruptedException {

        List<WebElement> rows = driver.findElements(By.cssSelector("[class='tippy-content'] button"));

        for(int i=0;i<rows.size();i++)
        {
            String rowsCount = rows.get(i).getText();
            if(rowsCount.contains(row))
            {
                rows.get(i).click();
            }
        }

        updatedShowRow = getShowRows().getText();
        Thread.sleep( 3000 );
         Assert.assertEquals(updatedShowRow,row);

    }


    public void verifyRowCount(String row)
    {
        Assert.assertEquals(updatedShowRow,row);
    }


    public void enterMarketCapRange(String min, String max)
    {
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
