package NPO.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RockBastionHome {
    public RockBastionHome(WebDriver driver) {
        this.driver = driver;
    }
    private WebElement searchInput;
    private WebElement SearchResult;
    private WebDriver driver;


    public void OpenMainPage(){
        driver.get("https://rockbastion.by/");
    }

    public void SearchTerm(){
                WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.click();
        searchInput.sendKeys("череп");
        searchInput.sendKeys(Keys.ENTER);
    }

    public WebElement FindElementAndClick(String xpath){
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
        return element;

    }


}
