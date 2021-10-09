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

    public String getItemName(int index) {
        setTitle(index);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        return driver.findElement(title).getText();
    }

    public String getItemPrice(int index) {
        setPrice(index);
        return driver.findElement(price).getText();
    }

    public String getItemCount(int index) {
        setCount(index);
        return driver.findElement(count).getAttribute("value");
    }

    public void setTitle(int index) {
        title = By.xpath("(//*[@class = \"ProductName \"])["+index+"]");
    }

    public void setPrice(int index) {
        price = By.xpath("(//*[@data-locator = \"undefined\"])["+index+"]");
    }

    public void setCount(int index) {
        count = By.xpath("(//input[@class = \"quantityEdit\"])["+index+"]");
    }
}
