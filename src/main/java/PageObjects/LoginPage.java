package PageObjects;

import General.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements( driver, this );
    }

    public WebDriver driver;

    //Login Locators

    @FindBy(id = "loginBox_username")
    WebElement userName;

    @FindBy(id = "loginBox_password")
    WebElement password;

    @FindBy(css = ".default")
    WebElement loginBtn;

    //Validation messages
    @FindBy(css = "span[class='ss-login-error']")
    WebElement errorLoginMsg;


    //Functions
    public WebElement getUserNameField() {
        return userName;
    }

    public WebElement getPasswordField() {
        return password;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }

    public String getErrorLoginMsg() {
        return errorLoginMsg.getText();
    }

    public void loginIntoWeb(String user, String pwd) {
        getUserNameField().sendKeys( user );
        getPasswordField().sendKeys( pwd );
        getLoginBtn().click();
    }


}
