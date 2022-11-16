import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.css.model.Value;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class WebDriverRockBastionTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new EdgeDriver();
    }

@Test (description = "first test for rock bastion")
    public void commonSearchTermResultsNotEmpty(){
       // WebDriver driver = new EdgeDriver();
        driver.get("https://rockbastion.by/");
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.click();
        searchInput.sendKeys("кольцо стальное");
        searchInput.sendKeys(Keys.ENTER);
        WebElement searchResult = driver.findElement(By.name("search"));
        Assert.assertNotNull(searchResult, "search string not empty");

    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;

    }

}
