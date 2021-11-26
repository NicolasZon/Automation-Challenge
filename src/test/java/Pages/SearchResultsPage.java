package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage{

    private String pagination_buttons = "//ul[@class='a-pagination']/li/a[text()='%s']";

    private final By data_results = By.xpath("//div[@data-component-type='s-search-result']//h2");

    public SearchResultsPage(WebDriver driver){
        super(driver);
    }

    public void getPage(int i) {
        pagination_buttons = String.format(pagination_buttons, i);
        driver.findElement(By.xpath(pagination_buttons)).click();
    }

    public void selectItem(int i) {
        waitUntilNumberOfElementsBeMoreThan(data_results,i);
        driver.findElements(data_results).get(i).click();
    }
}
