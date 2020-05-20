package secondcucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.SearchResultPage;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MuaHangTiKi {
    WebDriver driver;
    HomePage homePage = new HomePage();
    SearchResultPage searchResultPage = new SearchResultPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    CartPage cartPage = new CartPage();
    Map item = new HashMap<>();
    public MuaHangTiKi(){
        this.driver = Hooks.driver;
    }
    @Given("The Tiki Homepage is displayed on browser")
    public void theTikiHomepageIsDisplayedOnBrowser() {
        this.driver.get("https://tiki.vn/");
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @When("User attempt to search keyword {string}")
    public void userAttemptToSearchKeyword(String keyword) {
        homePage.search_function(keyword);
    }

    @And("User select a desired item in the search result list")
    public void userSelectADesiredItemInTheSearchResultList() throws InterruptedException {
        Boolean check = searchResultPage.clickFirstItem();
    }

    @And("User attempt buy this item with quantity = {int}")
    public void userAttemptBuyThisItemWithQuantity(int qty) throws InterruptedException {
        String quantity = Integer.toString(qty);
        productDetailPage.clickBuyBtn(quantity);
        item = productDetailPage.getItemInfo();


    }

    @And("User go to the cart page to check the added item")
    public void userGoToTheCartPageToCheckTheAddedItem() {
        productDetailPage.clickCartBtn();

    }

    @Then("The system displayed the added item in the cart with correct name and price, quantity")
    public void theSystemDisplayedTheAddedItemInTheCartWithCorrectNameAndPriceQuantity() {
        Map itemResult = cartPage.checkInCart();
        Assert.assertEquals(item, itemResult);
    }
}
