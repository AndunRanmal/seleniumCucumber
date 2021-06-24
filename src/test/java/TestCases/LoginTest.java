package TestCases;

import General.BaseTest;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {


    @BeforeTest
    public void initialzeBrowser() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }


    @Test
   public void loginIntoApplication()
   {
       LoginPage cp = new LoginPage(driver);
       cp.loginIntoWeb("ramsha@vsd.com","password123");
       Assert.assertEquals(cp.getErrorLoginMsg(),"Invalid user please check your email or password." );



   }



//    @Test(dataProvider = "getData")
//    public void loginIntoApplication(String username, String password) throws IOException {
//        LoginPage cp = new LoginPage(driver);
//        cp.loginIntoWeb(username,password );
//        Assert.assertEquals(cp.getErrorLoginMsg(),"Invalid user please check your email or password." );
//        log.info("Successfully validated the message");
//
//    }
//   @DataProvider
//    public Object[][] getData()
//   {
//       Object[][] data = new Object[2][2];
//
//       //1st login creds
//       data[0][0] = "ramsha@vsd.com";
//       data[0][1] = "pass123";
//
//       //2nd attempt correct
//       data[1][0] = "ramsha@vd.com";
//       data[1][1] = "pass123";
//
//       return data;
//   }

   @AfterTest
    public void closeWindow()
   {
      driver.close();
      driver=null;
   }
}
