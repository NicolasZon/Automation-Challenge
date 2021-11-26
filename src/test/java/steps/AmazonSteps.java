package steps;

import Pages.AmazonHomePage;
import Pages.ItemPage;
import Pages.SearchResultsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonSteps {

    WebDriver driver;
    AmazonHomePage amazonHomePage;
    SearchResultsPage searchResultsPage;
    ItemPage itemPage;

    @Before()
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        amazonHomePage = new AmazonHomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        itemPage = new ItemPage(driver);
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
    public void theItemWouldBeAvailableForPurchase(){
        Assert.assertTrue("The item cannot be add to the cart", itemPage.itemCanBeAddedToTheCart());
        Assert.assertTrue("The item was not added to the cart", itemPage.wasTheItemAddedToTheCart());
    }
}
