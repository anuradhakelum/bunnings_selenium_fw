package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.HomePage;

public class AddItemToCartStepDefinition {
    protected HomePage homePage;
    protected CartPage cartPage;
    protected WebDriver driver;

    @Given("User is in Home page")
    public void user_is_in_home_page() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.bunnings.com.au");
        driver.manage().window().fullscreen();
        homePage = new HomePage(driver);
    }

    @Given("User search for paint items")
    public void user_search_for_paint_items() {
        homePage.searchForItem("paint");
    }

    @Given("User filter items which are available for click and collect")
    public void user_filter_items_which_are_available_for_click_and_collect() {
        homePage.clickAvailability();
        homePage.clickClickAndCollect();
    }

    @When("User add item to the cart")
    public void user_add_item_to_the_cart() {
        homePage.addItemToCart(0);
    }

    @When("Go to cart page")
    public void go_to_cart_page() {
        cartPage = homePage.goToCart();
    }

    @Then("User should see item quantity and amount in cart page")
    public void user_should_see_item_quantity_and_amount_in_cart_page() {
        Assert.assertEquals(homePage.getItem(), cartPage.getItemName(1));
        Assert.assertEquals(homePage.getPrice(), cartPage.getItemPrice(1));
        Assert.assertEquals("1", cartPage.getItemCount(1));
        driver.quit();
    }
}
