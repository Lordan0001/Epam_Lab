package PageObjectModel.Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RockBastionHomePage {

    private static final String HOMEPAGE_URL = "https://rockbastion.by/";
    private WebDriver driver;

    @FindBy(name = "search")
    private WebElement searchInput;

    public RockBastionHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public RockBastionHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }
    public RockBastionSearchResultsPage searchForTerms(String term){
        searchInput.sendKeys(term);
        searchInput.sendKeys(Keys.ENTER);
        return new RockBastionSearchResultsPage(driver,term);
    }
//    public RockBastionHomePage() {
//    }
//        searchInput.click();
//        searchInput.sendKeys("кольцо стальное");
//        searchInput.sendKeys(Keys.ENTER);
}
