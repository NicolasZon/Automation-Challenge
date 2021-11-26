package steps;

import Pages.AmazonHomePage;
import Pages.SearchResultsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSteps {

    WebDriver driver;
    AmazonHomePage amazonHomePage;
    SearchResultsPage searchResultsPage;

    @Before()
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        amazonHomePage = new AmazonHomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("the user navigates to the base page")
    public void theUserNavigatesToTheBasePage() {
        amazonHomePage.getHomePage();
    }

    @When("he searches for {string}")
    public void heSearchesFor(String item) {
        amazonHomePage.searchFor(item);
    }

    @And("navigates to the second page")
    public void navigatesToTheSecondPage() {
        searchResultsPage.getPage(2);
    }

    @And("he selects the third item")
    public void heSelectsTheThirdItem() {
        searchResultsPage.selectItem(3);
    }

    @Then("the item would be available for purchase")
    public void theItemWouldBeAvailableForPurchase() {

    }
}
