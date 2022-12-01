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

public class CurrentStickerSearch {
    private static Logger logger = LogManager.getRootLogger();
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = DriverSingleton.getDriver();

    }


    @Test(description = "find all metallica stickers")
    public void FindStickers() throws InterruptedException {
        driver.get("https://rockbastion.by/");



        WebElement mainMenu = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a[1]"));
        mainMenu.click();
        logger.info("open main menu");

        Thread.sleep(2000);
        WebElement prints = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[8]/a[1]"));
        prints.click();
        logger.info("click on prints link");



        WebElement stickerLink = driver.findElement(By.xpath("//*[@id=\"subcats\"]/div[2]/a"));
        stickerLink.click();
        Thread.sleep(1000);

        WebElement groupCheckbox = driver.findElement(By.xpath("//*[@id=\"oct-product-filter-data\"]/div[2]/div[1]/div[2]/div[1]/label"));
        groupCheckbox.click();
        Thread.sleep(1000);
        logger.info("take AC/DC checkbox");

        WebElement showStickers = driver.findElement(By.xpath("//*[@id=\"oct-ismobile\"]/div[3]/div[2]/button"));
        showStickers.click();

        Thread.sleep(1000);
        WebElement searchValue = driver.findElement(By.xpath("//*[@id=\"oct-selected-values\"]/div/div[2]/button"));
        Assert.assertEquals(searchValue.getAttribute("innerText"),"AC/DC ");
    }




    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();

    }



}
