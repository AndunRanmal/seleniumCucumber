package stepDefinitions;

import General.BaseTest;
import PageObjects.CoinMarketCapPage;
import PageObjects.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(Cucumber.class)
public class StepDefinition extends BaseTest {
    
    private CoinMarketCapPage coinMarketCapPage;
    private String marketCapMin;
    private String marketCapMax;
    private String priceMin;
    private String priceMax;

    @Given("^Initialize the browser with chrome$")
    public void initializeTheBrowserChrome() throws IOException {
        initializeDriver();
        driver.manage().window().maximize();
    }

    @Given("^Navigate to \"([^\"]*)\" website$")
    public void navigateToWebSite(String url) {
        driver.get(url);
    }


    @When("^User enters (.+) and (.+) and click on Login button$")
    public void user_enters_and_and_click_on_login_button(String username, String password) {
        LoginPage lp = new LoginPage(driver);
        lp.loginIntoWeb(username, password);
    }


    @Then("^Verify that error message should display$")
    public void verify_that_error_message_should_display() throws Throwable {
        LoginPage lp = new LoginPage(driver);
        assertEquals(lp.getErrorLoginMsg(), "It looks like you've typed in an incorrect information. Please try again");
    }


    @And("^close browsers$")
    public void close_browsers() {
        driver.quit();
    }


    // test
    @When("^User Select 'Show rows' dropdown value to \"([^\"]*)\"$")
    public void userSelectRowCountsToBeDisplayed(String rowCount) {
        coinMarketCapPage = new CoinMarketCapPage(driver);
        coinMarketCapPage.selectRowCount(rowCount);
    }

    @Then("^Verify that \"([^\"]*)\" rows are displayed$")
    public void userVerifyCorrectRowCountIsDisplayed(int rowCount) {
        coinMarketCapPage.verifyRowCount(rowCount);
    }

    @When("^User select Add filters$")
    public void userSelectAddFilers() throws InterruptedException {
        coinMarketCapPage = new CoinMarketCapPage(driver);
        coinMarketCapPage.closeAlertMessage();
        coinMarketCapPage.goToFilters();
    }


    @When("^User Select filter records by MarketCap \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userSelectFilterMarketCap(String min, String max) {
        marketCapMin = min;
        marketCapMax = max;
        coinMarketCapPage.enterMarketCapRange(min, max);
        coinMarketCapPage.clickApplyFilterButton();
    }

    @When("^set Price \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userSelectFilterPrice(String min, String max) {
        priceMin = min;
        priceMax = max;
        coinMarketCapPage.enterPriceRange(min, max);
        coinMarketCapPage.clickApplyFilterButton();
        coinMarketCapPage.clickShowResultsButton();
    }

    @Then("^Check records displayed on page are correct as per the filter applied$")
    public void checkRecordCorrectlyAsPerFilters() throws InterruptedException {
        coinMarketCapPage.checkMarketCapWithInTheFilteredCriteria(marketCapMin.replace(",", ""),
                marketCapMax.replace(",", ""));
        coinMarketCapPage.checkPriceWithInTheFilteredCriteria(priceMin.replace(",", ""),
                priceMax.replace(",", ""));
        System.out.println("verified records");
    }
}
