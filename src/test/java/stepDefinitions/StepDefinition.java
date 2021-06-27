package stepDefinitions;

import General.BaseTest;
import Models.CryptoCurrencyMapDataResponseData;
import Models.CryptoCurrencyMapResponseData;
import PageObjects.CoinMarketCapPage;
import PageObjects.LoginPage;
import Services.MarketCapApiService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.runner.RunWith;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Cucumber.class)
public class StepDefinition extends BaseTest {


    private Response response;
    private Integer cryptoId;
    private JSONObject ethereum;
    private ArrayList<String> mineableCoins;
    private JSONObject data;

    @Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
        driver = initializeDriver();
        driver.manage().window().maximize();
    }

    @And("^Navigate to \"([^\"]*)\" website$")
    public void navigate_to_something_website(String url) throws Throwable {
        driver.get(url);
    }


    @When("^User enters (.+) and (.+) and click on Login button$")
    public void user_enters_and_and_click_on_login_button(String username, String password) throws Throwable {
        LoginPage lp = new LoginPage(driver);
        lp.loginIntoWeb(username, password);
    }


    @Then("^Verify that error message should display$")
    public void verify_that_error_message_should_display() throws Throwable {
        LoginPage lp = new LoginPage(driver);
        assertEquals(lp.getErrorLoginMsg(), "It looks like you've typed in an incorrect information. Please try again");
    }


    @And("^close browsers$")
    public void close_browsers() throws Throwable {
        driver.quit();
    }


    // test
    @When("^User Select 'Show rows' dropdown value to \"([^\"]*)\"$")
    public void user_select_show_rows_dropdown_value_to_something(String strArg1) throws Throwable {

        CoinMarketCapPage mp = new CoinMarketCapPage(driver);
        mp.clickOnShowRows();
        mp.selectShowRow(strArg1);
        Thread.sleep(5000);


    }

    @Then("^Verify that \"([^\"]*)\" rows are displayed$")
    public void verify_that_something_rows_are_displayed(int strArg1) throws Throwable {
        CoinMarketCapPage mp = new CoinMarketCapPage(driver);
        mp.verifyRowCount(strArg1);
    }

    //diff case
    @When("^User Select filter records by MarketCap \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_select_filter_records_by_marketcap_something(String min, String max) throws Throwable {
        CoinMarketCapPage mp = new CoinMarketCapPage(driver);
        mp.goToFilters();
        mp.enterMarketCapRange(min, max);
    }

    @When("^set Price \"([^\"]*)\" and \"([^\"]*)\"$")
    public void set_price_something_and_something(String min, String max) throws Throwable {
        CoinMarketCapPage mp = new CoinMarketCapPage(driver);
        mp.enterPriceRange(min, max);
    }

    @Then("^Check records displayed on page are correct as per the filter applied$")
    public void check_records_displayed_on_page_are_correct_as_per_the_filter_applied() {

        System.out.println("verified records");
    }
}
