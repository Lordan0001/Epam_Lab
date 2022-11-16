package PageObjectModel.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Home {
    public Home(WebDriver driver) {
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


}
