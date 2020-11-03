package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver) {
        super(driver);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public String login(String username, String password) {

        goToHomePage();

        WebElement username_field = driver.findElement(By.id("username"));
        username_field.clear();
        username_field.sendKeys(username);

        WebElement password_field = driver.findElement(By.name("password"));
        password_field.clear();
        password_field.sendKeys(password);

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        boolean login = isLoggedIn();

        if(!login) {
            WebElement invalidLoginMessage = driver.findElement(By.xpath("//font[1]"));
            return invalidLoginMessage.getText();
        }

        return driver.getCurrentUrl();


    }

    public Boolean isLoggedIn() {
        String currentUrl = driver.getCurrentUrl();
        return (currentUrl.endsWith("home.do"));
    }




 /*
    Update isLoggedIn method to logout user before login test.
              if (isLoggedIn()){
                if (Logout button is present){
                  then click Logout button
              }else {
                 click the Home button
                 click Logout button
               }

            }
*/


}




