package NPO.Test;

import NPO.Page.RockBastionHome;
import NPO.Page.RockBastionResultSearch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class WebDriverRockBastionTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        //System.setProperty("webdriver.edge.driver", "D:\\JavaApps\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();

    }

    @Test(description = "first test for rock bastion")
    public void commonSearchTermResultsAreEqual() {

        RockBastionHome rockBastionHome = new RockBastionHome(driver);
        rockBastionHome.OpenMainPage();
        rockBastionHome.SearchTerm();
        RockBastionResultSearch result = new RockBastionResultSearch(driver);
        result.GetSearchResult();

        Assert.assertEquals(result.GetSearchResult(), "череп", "search string get entered values");

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;

    }

}
