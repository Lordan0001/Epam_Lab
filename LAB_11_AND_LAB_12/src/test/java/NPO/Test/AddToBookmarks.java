package NPO.Test;

import NPO.driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToBookmarks {

    private static Logger logger = LogManager.getRootLogger();
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = DriverSingleton.getDriver();

    }


    @Test(description = "Add to bookmarks")
    public void Bookmarks() throws InterruptedException {
        driver.get("https://rockbastion.by/ukrasheniya/braslety_stalnyye/21587/");
        logger.info("Open product page");


        Thread.sleep(1000);
        WebElement bookmark = driver.findElement(By.xpath("//*[@id=\"product\"]/div[3]/div/div/a[3]"));
        bookmark.click();
        logger.info("press heart button");


        Thread.sleep(1000);
        WebElement closeWindow = driver.findElement(By.xpath("//*[@id=\"wishlist-popup\"]/button"));
        closeWindow.click();
        logger.info("close popup window");


        Thread.sleep(1000);
        WebElement favorites = driver.findElement(By.xpath("//*[@id=\"oct-favorite-link\"]/a"));
        favorites.click();


        Thread.sleep(1000);
        WebElement searchValue = driver.findElement(By.xpath("//*[@id=\"oct-favorite-carousel\"]/div[1]/div/div/div/div[2]/a"));
        Assert.assertEquals(searchValue.getAttribute("innerText"), "Браслет \"Колючая проволока\"");

    }


    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();

    }

}
