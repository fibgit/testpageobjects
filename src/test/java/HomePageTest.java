
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import java.util.Arrays;
import java.util.List;

public class HomePageTest {

    private LoginPage loginPage;
    private HomePage homePage;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void expectedDashboardsVisible(){

        //given
        loginPage.login("validUsername", "haha2525_");

        //when
        List<String> actual = homePage.getListOfHomepageDashboards();

        //then
        List<String> expected = Arrays.asList("A Dashboards", "B Dashboards","C Dashboard","D Dashboard");

       Assert.assertEquals(expected, actual);

    }


}
