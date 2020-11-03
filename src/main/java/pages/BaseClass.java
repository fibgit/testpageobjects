package pages;

import org.openqa.selenium.WebDriver;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class BaseClass {

     protected Properties properties;
     protected final WebDriver driver;
     protected String url;

     public BaseClass (WebDriver driver) {
            this.driver= driver;
         properties = new Properties();

         try {
             FileReader reader = new FileReader("src\\test\\application.properties");
             properties.load(reader);
             reader.close();
         } catch (IOException e) {
             e.printStackTrace();
         }

         url = properties.getProperty("home.url");


     }

    public WebDriver getDriver() {
        return driver;

    }

    public String goToHomePage() {
        driver.get(url);
        return driver.getCurrentUrl();
    }

    public Boolean isLoggedIn() {
        goToHomePage();
        String currentUrl = driver.getCurrentUrl();
        return (currentUrl.endsWith("home.do"));
    }


}
