package PageObjectModel.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Result {
    public Result(WebDriver driver) {
        this.driver = driver;
    }
    private WebDriver driver;
    public String GetSearchResult(){

        WebElement SearchResult = driver.findElement(By.xpath("//*[@id=\"search\"]/input"));
        String AttrValue = SearchResult.getAttribute("value");
        return AttrValue;
    }
}
