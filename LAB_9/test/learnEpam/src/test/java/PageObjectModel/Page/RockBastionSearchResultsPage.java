package PageObjectModel.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RockBastionSearchResultsPage {

    private String searchTerm;
    private WebDriver driver;
    @FindBy(xpath = "//*[@id=\\\"search\\\"]/input")
    private WebElement searchElement;
    private String attrValue = searchElement.getAttribute("value");

    public RockBastionSearchResultsPage(WebDriver driver, String searchTerm) {
        this.driver = driver;
        this.searchTerm = searchTerm;
        PageFactory.initElements(driver,this);
    }

    public RockBastionSearchResultsPage OpenResultResultPage(){
        WebElement SearchResult = driver.findElement(By.xpath("//*[@id=\"search\"]/input"));
        return this;
    }
    public String GetAttr(WebElement SearchResult){
        String AttrValue = SearchResult.getAttribute("value");
        return AttrValue;
    }


    WebElement searchResult = driver.findElement(By.name("search"));
}
