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

    // click on Store & Availability
    public void clickAvailability() {
        setWait(storeAvailability);
        driver.findElement(storeAvailability).click();
    }

    //Select and filter for Click and collect
    public void clickClickAndCollect() {
        driver.findElement(clickAndCollect).click();
    }

    //add items to card by item index, index start with 0
    public void addItemToCart(int index) {
        getData(index);
        driver.findElement(addToCartButton).click();
    }

    //go to cart page
    public CartPage goToCart() {
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }

    // return name of the item added to cart
    public String getItem() {
        return item;
    }

    //return price of the item added to card
    public String getPrice() {
        return price;
    }

    //set wait for different web elements
    private void setWait(By element) {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    // set price and name
    private void getData(int id) {
        WebElement element;
        setIndex(id);
        setWait(itemTitle);
        item = driver.findElement(itemTitle).getText();
        price = driver.findElement(itemPrice).getText();
        System.out.println(price);
    }

    //update the xpath base on the item user added to cart
    private void setIndex(int index) {
        addToCartButton = By.xpath("//*[@data-index="+index+"]//*[contains(@data-locator,\"Button\")]");
        itemTitle = By.xpath("//*[@data-index ="+index+"]//*[contains (@class,\"product-title\")]");
        itemPrice = By.xpath("//*[@data-index ="+index+"]//*[contains (@data-locator,\"price\")]");
    }
}
