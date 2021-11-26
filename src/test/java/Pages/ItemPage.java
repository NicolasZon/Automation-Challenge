package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class ItemPage extends BasePage{

    private final By addToCart = By.id("add-to-cart-button");
    private final By addedToCart = By.xpath("//h1[contains(text(),'Added to Cart')]");

    public ItemPage(WebDriver driver){
        super(driver);
    }


    public boolean itemCanBeAddedToTheCart() {
        try {
            mapElementWhenVisible(addToCart);
            return true;
        } catch (TimeoutException e){
            return false;
        }
    }

    public boolean wasTheItemAddedToTheCart() {
        try {
            mapElementWhenVisible(addedToCart);
            return true;
        } catch (TimeoutException e){
            return false;
        }
    }
}
