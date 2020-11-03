package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getListOfHomepageDashboards() {

        List<String> dashBoards = new ArrayList<>();

        List<WebElement> elements = driver
                .findElement(By.cssSelector(".mainMenu"))
                .findElements(By.tagName("li"));

        for(WebElement we : elements) {
            dashBoards.add(we.getText().trim());
        }

        return dashBoards;

    }








}

