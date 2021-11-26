package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private final WebDriverWait wait;
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,5);
    }

    public void getHomePage() {
        driver.get("https://www.amazon.com/");
    }

    public WebElement mapElementWhenVisible(By element){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitUntilNumberOfElementsBeMoreThan(By element, int amount){
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(element, amount));
    }
}
