package NPO.Test;

import NPO.driver.DriverSingleton;
import NPO.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTest {
    private static Logger logger = LogManager.getRootLogger();

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = DriverSingleton.getDriver();

    }

    @Test(description = "sign in (already) have account")
    public void SignInTest() throws InterruptedException {
        driver.get("https://rockbastion.by/");


        User user = new User("abuqe@mailto.plus", "c3e12dsaCCD");
        logger.info("Create user");

        WebElement signMenu = driver.findElement(By.xpath("//*[@id=\"top-right-links\"]/ul/li[2]/a/span"));
        signMenu.click();

        Thread.sleep(1000);
        WebElement signButton = driver.findElement(By.xpath("//*[@id=\"top-right-links\"]/ul/li[2]/ul/li[2]/a"));
        signButton.click();

        Thread.sleep(1000);
        WebElement inputEmail = driver.findElement(By.xpath("//*[@id=\"popup-login-form\"]/input[1]"));
        inputEmail.click();
        inputEmail.sendKeys(user.getEmail());
        logger.info("Enter email");

        Thread.sleep(1000);
        WebElement inputPassword = driver.findElement(By.xpath("//*[@id=\"popup-login-form\"]/input[2]"));
        inputPassword.click();
        inputPassword.sendKeys(user.getPassword());
        logger.info("Enter password");

        Thread.sleep(1000);
        WebElement enterPassword = driver.findElement(By.xpath("//*[@id=\"popup-login-button\"]"));
        enterPassword.click();


        Thread.sleep(1000);

        WebElement ProfileText = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        Assert.assertEquals(ProfileText.getAttribute("innerText"),"ЛИЧНЫЙ КАБИНЕТ");


    }


    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();

    }
}
