package TestCases;

import General.BaseTest;
import PageObjects.DropDownPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class DropDownsTest extends BaseTest {

    @BeforeTest
    public void initialzeBrowser() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void selectDropdown() throws InterruptedException {
        DropDownPage dp = new DropDownPage(driver);
        dp.selectDepartureCity();
        dp.selectArrivalCity();
        dp.selectDepartureDate();
        dp.selectAdultsDropdown();
        dp.selectCurrencyDropdown();

    }


}
