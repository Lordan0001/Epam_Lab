package PageObjectModel.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public void commonSearchTermResultsAreEqual(){

        driver.get("https://rockbastion.by/");
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.click();
        searchInput.sendKeys("череп");
        searchInput.sendKeys(Keys.ENTER);
        //result

    WebElement SearchResult = driver.findElement(By.xpath("//*[@id=\"search\"]/input"));
    String AttrValue = SearchResult.getAttribute("value");
    System.out.println(AttrValue + "_____________value");
    Assert.assertEquals(AttrValue, "череп", "search string get entered values");


    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;

    }

}
