package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomePage extends BasePage{

    private By searchBox = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");


    public AmazonHomePage(WebDriver driver){
        super(driver);
    }


    public void searchFor(String item) {
        driver.findElement(searchBox).sendKeys(item);
        driver.findElement(searchButton).click();
    }
}
