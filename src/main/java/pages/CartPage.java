package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private WebDriver driver;

    private By title;
    private By price;
    private By count;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    //return item name
    public String getItemName(int index) {
        setTitle(index);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        return driver.findElement(title).getText();
    }

    //return item price
    public String getItemPrice(int index) {
        setPrice(index);
        return driver.findElement(price).getText();
    }

    //return item count
    public String getItemCount(int index) {
        setCount(index);
        return driver.findElement(count).getAttribute("value");
    }

    //set xpath base on  how many items in the cart; name
    public void setTitle(int index) {
        title = By.xpath("(//*[@class = \"ProductName \"])["+index+"]");
    }

    //set xpath based on the how many items in the cart; price
    public void setPrice(int index) {
        price = By.xpath("(//*[@data-locator = \"undefined\"])["+index+"]");
    }

    //set xpath based on the how many items in the cart; count
    public void setCount(int index) {
        count = By.xpath("(//input[@class = \"quantityEdit\"])["+index+"]");
    }
}
