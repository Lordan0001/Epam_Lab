package Epam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ICanWin {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://pastebin.com");
        WebElement CodeInput = driver.findElement(By.id("postform-text"));
        CodeInput.sendKeys("Hello from WebDriver");
        driver.findElement(By.id("select2-postform-expiration-container")).click();
        driver.findElement(By.xpath("//li[text()='10 Minutes']")).click();
        WebElement NameInput = driver.findElement(By.id("postform-name"));
        NameInput.sendKeys("helloweb");
        driver.findElement(By.xpath("//button[@class='btn -big']")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
          driver.quit();
    }

}
