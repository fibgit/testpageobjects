
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;

import java.util.Properties;

public class LoginPageTest {

    WebDriver driver;
    private LoginPage loginPage;
    Properties properties;

    @Before
    public void setUp(){

        loginPage = new LoginPage(driver);

    }

    @Test
    public void getToLoginPage(){

        //given
        String url = properties.getProperty("home.url");

        //when
        String currentURL = loginPage.goToHomePage();

        //then
        Assert.assertEquals(url, currentURL);

    }

    @Test
    public void successLoginTest() {

        //given
        String url = "https://www.validurl/home.do";

        //when
        String currentURL = loginPage.login("avaliduser.com","correctPassword#");

        //then
        Assert.assertEquals(url, currentURL);
    }

    @Test

    public void unsuccessfulLogin(){

        //given
        String expected = "Incorrect details, or account has expired.";

        //when
        String actual = loginPage.login("invaliduser.com","incorrectPassword#");

        //then
        Assert.assertEquals(expected, actual);
    }


}
