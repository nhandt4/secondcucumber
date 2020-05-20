package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import secondcucumber.Hooks;

import java.util.HashMap;
import java.util.Map;

public class CartPage {
    public WebDriver driver;
    private WebDriverWait waitFunc;
    public CartPage(){
        this.driver = Hooks.driver;
        PageFactory.initElements(driver,this);
        this.waitFunc = new WebDriverWait(driver, 20);
    }
    @FindBy(xpath = "//a[@class='cart-products__name']")
    public WebElement itemTitle;
    @FindBy(xpath = "//p[@class='cart-products__real-prices']")
    public WebElement itemPrice;
    @FindBy(xpath = "//input[@class='qty-input']")
    public WebElement itemQty;
    public Map checkInCart(){
        Map item1=new HashMap();
        String title = waitFunc.until(ExpectedConditions.visibilityOf(itemTitle)).getText().trim();
        item1.put("Title", title);
        String price = waitFunc.until(ExpectedConditions.visibilityOf(itemPrice)).getText().trim();
        price = price.substring(0, price.length()-2);
        item1.put("Price", price);
        String qty = waitFunc.until(ExpectedConditions.visibilityOf(itemQty)).getAttribute("value").trim();
        int qtyConvert = Integer.parseInt(qty);
        item1.put("Qty", qtyConvert);
        return item1;

    }

}
