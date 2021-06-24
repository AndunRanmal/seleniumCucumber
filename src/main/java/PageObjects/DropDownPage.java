package PageObjects;

import General.BaseTest;
import cucumber.api.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends BaseTest {

    WebDriver driver;

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements( driver, this );
    }


    //Locators

    @FindBy(css = "input[id='ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT']")
    WebElement departCity;

    @FindBy(xpath = "//a[@value='BLR']")
    WebElement selectDepartCity;

    @FindBy(xpath = "(//a[@value='MAA'])[2]")
    WebElement selectArrivalCity;

    @FindBy(css = ".ui-state-default.ui-state-highlight")
    WebElement currentDate;

    @FindBy(id = "divpaxinfo")
    WebElement passengerField;

    @FindBy(id = "ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_ADT")
    WebElement adults;

    @FindBy(id = "ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListCurrency")
    WebElement currency;


    //Dynamic Dropdown
    public WebElement clickOnDepartureField() {
        return departCity;
    }

    public WebElement selectDeparture() {
        return selectDepartCity;
    }

    public WebElement selectArrival() {
        return selectArrivalCity;
    }


    public WebElement getDepartureDate() {
        return currentDate;
    }

    public WebElement clickOnPassengerField() {
        return passengerField;
    }

    public WebElement clickOnAdultsField() {
        return adults;
    }

    public WebElement getCurrency() {
        return currency;
    }

    public void selectDepartureDate() {
        currentDate.click();
    }

    public void selectCurrencyDropdown() {
        Select currencydp = new Select( getCurrency() );
        currencydp.selectByVisibleText( "USD" );

    }

    public void selectAdultsDropdown() {
        clickOnPassengerField().click();
        Select dropdown = new Select( clickOnAdultsField() );
        dropdown.selectByValue( "5" );
    }

    public void selectDepartureCity() throws InterruptedException {
        Thread.sleep( 4000 );
        clickOnDepartureField().click();
        selectDeparture().click();
        Thread.sleep( 2000 );
    }

    public void selectArrivalCity() {
        selectArrival().click();

    }

}
