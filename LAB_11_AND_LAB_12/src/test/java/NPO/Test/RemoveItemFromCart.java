package NPO.Test;

import NPO.Page.RockBastionHome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveItemFromCart {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        //System.setProperty("webdriver.edge.driver", "D:\\JavaApps\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();

    }

    @Test(description = "remove item from card")
    public void RemoveFromCard() throws InterruptedException {

        RockBastionHome rockBastionHome = new RockBastionHome(driver);
        rockBastionHome.OpenMainPage();
        rockBastionHome.FindElementAndClick("//*[@id=\"oct-bluring-box\"]/div[5]/div[1]/div/div[1]/div[2]/div[3]/div[2]/ul/li[3]/a");

        rockBastionHome.FindElementAndClick("//*[@id=\"res-products\"]/div[1]/div[1]/div/div[2]/div/div[1]/a");
        rockBastionHome.FindElementAndClick("//*[@id=\"input-option25844\"]");
        rockBastionHome.FindElementAndClick("//*[@id=\"input-option25844\"]/option[2] ");
        Thread.sleep(1000);
        rockBastionHome.FindElementAndClick("//*[@id=\"button-cart\"]");
        Thread.sleep(2000);
        rockBastionHome.FindElementAndClick("//*[@id=\"popup-cart-inner\"]/div[4]/div/div[2]/a[1]");
        driver.navigate().refresh();


        //remove part
        Thread.sleep(2000);
        WebElement cart = driver.findElement(By.xpath("//*[@id=\"m-cart\"]/i"));
        cart.click();

        Thread.sleep(2000);
        WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"popup-cart-inner\"]/div[4]/form/div/div/div[1]/button"));
        deleteButton.click();

        Thread.sleep(2000);
        WebElement continueShoppingBtn = driver.findElement(By.xpath("//*[@id=\"popup-cart-inner\"]/div[3]/a"));
        continueShoppingBtn.click();

        WebElement resultPrice = driver.findElement(By.xpath("//*[@id=\"cart-total\"]/span"));
        Assert.assertEquals(resultPrice.getAttribute("innerText"), "0.00 руб.");

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;

    }


}
