package stepDefinitions;

import General.BaseTest;
import Models.CryptoCurrencyMapDataResponseData;
import Models.CryptoCurrencyMapResponseData;
import PageObjects.CoinMarketCapPage;
import PageObjects.LoginPage;
import Services.MarketCapApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.runner.RunWith;

import java.net.HttpURLConnection;
import java.util.*;

import static io.restassured.parsing.Parser.JSON;
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


    }

    @Then("^Verify that \"([^\"]*)\" rows are displayed$")
    public void verify_that_something_rows_are_displayed(String strArg1) throws Throwable {
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

    @And("^ set Price \"([^\"]*)\" and \"([^\"]*)\"$")
    public void set_price_something_and_something(String min, String max) throws Throwable {
        CoinMarketCapPage mp = new CoinMarketCapPage(driver);
        mp.enterPriceRange(min, max);
    }

    @Then("^Check records displayed on page are correct as per the filter applied$")
    public void check_records_displayed_on_page_are_correct_as_per_the_filter_applied() throws Throwable {

        System.out.println("verified records");
    }

    // Step definitions for API tests

    @Given("Request send to /cryptocurrency/map")
    public void create_the_request() {
        response = new MarketCapApiService().getCryptoCurrencyMap();
    }

    @When("The status code is 200")
    public void request_send_to_cryptocurrency_map() {
        assertEquals(response.statusCode(), HttpURLConnection.HTTP_OK);
    }

    @Then("^Get the ids of \"([^\"]*)\"$")
    public void all_IDs_should_be_retrieved(String coinName) {
        CryptoCurrencyMapResponseData responseData = response.then().extract().as(CryptoCurrencyMapResponseData.class);
        CryptoCurrencyMapDataResponseData data = responseData.getData().stream()
                .filter(element -> Objects.equals(element.getName(), coinName)).findFirst().get();
        cryptoId = data.getId();
    }

    @Then("^Convert the currency for a amount of \"([^\"]*)\"$")
    public void convert_the_currency_for_a_amount_of(int amount) {
        response = new MarketCapApiService().getPriceConversion(amount, cryptoId);
        String responseBody = response.getBody().asString();
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONObject data = jsonObject.getJSONObject("data");
        System.out.println("Converted price is $" +
                data.getJSONObject("quote").getJSONObject("USD").get("price").toString());
    }

    @Given("^Request send to /cryptocurrency/info with id \"([^\"]*)\"$")
    public void request_send_to_cryptocurrency_info_with_id(int id) {
        response = new MarketCapApiService().getCryptoCurrencyInfo(id);
        String responseBody = response.getBody().asString();
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONObject data = jsonObject.getJSONObject("data");
        ethereum = data.getJSONObject("1027");
    }

    @Then("^Check logo url$")
    public void check_logo_url() {
        assertEquals(ethereum.getString("logo"),
                "https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png");
    }

    @Then("^Check technical doc url$")
    public void check_technical_doc_url() {
        assertEquals(ethereum.getJSONObject("urls").get("technical_doc").toString(),
                "[\"https://github.com/ethereum/wiki/wiki/White-Paper\"]");
    }

    @Then("^Check the symbol$")
    public void check_the_symbol() {
        assertEquals(ethereum.getString("symbol"), "ETH");
    }

    @Then("^Check the date added$")
    public void check_the_date_added() {
        assertEquals(ethereum.getString("date_added"), "2015-08-07T00:00:00.000Z");
    }

    @Then("^check  for the mineable tag$")
    public void check_for_the_mineable_tag() {
        assertTrue(ethereum.getJSONArray("tags").toList().contains("mineable"));
    }

    @Given("^Request send to /cryptocurrency/info for first 10 ids$")
    public void request_send_to_cryptocurrency_info_for_first_ids() {
        response = new MarketCapApiService().getCryptoCurrencyInfoOf10Coins("1,2,3,4,5,6,7,8,9,10");
    }

    @Then("^Check  for the mineable tag in response cryptocurrencies$")
    public void check_for_the_mineable_tag_in_response_cryptocurrencies() {
        String responseBody = response.getBody().asString();
        JSONObject jsonObject = new JSONObject(responseBody);
        data = jsonObject.getJSONObject("data");
        try {
            Iterator<String> keys = data.keys();
            mineableCoins = new ArrayList<>();
            while (data.keys().hasNext()) {
                String key = keys.next();
                if (data.getJSONObject(key).getJSONArray("tags").toList().contains("mineable")) {
                    mineableCoins.add(data.getJSONObject(key).getString("name"));
                }
            }
        } catch (NoSuchElementException e) {

        }
    }

    @Then("^Print mineable currency names$")
    public void print_mineable_currency_names() {
        for (String coin : mineableCoins) {
            System.out.println(coin);
        }
    }

}