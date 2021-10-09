package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private String item;
    private String price;

    By searchBox = By.id("custom-css-outlined-input");
    By storeAvailability = By.id("panel1bh-header");
    By clickAndCollect = By.xpath("//*[@class =\"productranges\"]//*[text() = \"Click & Collect\"]");
    By cartButton = By.id("icon-cart");
    By addToCartButton;
    By itemTitle;
    By itemPrice;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForItem(String item) {
        driver.findElement(searchBox).sendKeys(item, Keys.ENTER);
    }

    public void clickAvailability() {
        setWait(storeAvailability);
        driver.findElement(storeAvailability).click();
    }

    public void clickClickAndCollect() {
        driver.findElement(clickAndCollect).click();
    }

    public void addItemToCart(int index) {
        getData(index);
        driver.findElement(addToCartButton).click();
    }

    public CartPage goToCart() {
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }

    public String getItem() {
        return item;
    }

    public String getPrice() {
        return price;
    }

    private void setWait(By element) {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    private void getData(int id) {
        WebElement element;
        setIndex(id);
        setWait(itemTitle);
        item = driver.findElement(itemTitle).getText();
        price = driver.findElement(itemPrice).getText();
        System.out.println(price);
    }

    private void setIndex(int index) {
        addToCartButton = By.xpath("//*[@data-index="+index+"]//*[contains(@data-locator,\"Button\")]");
        itemTitle = By.xpath("//*[@data-index ="+index+"]//*[contains (@class,\"product-title\")]");
        itemPrice = By.xpath("//*[@data-index ="+index+"]//*[contains (@data-locator,\"price\")]");
    }
}
