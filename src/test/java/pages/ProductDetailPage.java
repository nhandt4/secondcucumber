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

public class ProductDetailPage {
    public WebDriver driver;
    private WebDriverWait waitFunc;
    public ProductDetailPage(){
        this.driver = Hooks.driver;
        PageFactory.initElements(driver,this);
        this.waitFunc = new WebDriverWait(driver, 20);
    }
    @FindBy(xpath = "//input[@class='input']")
    public WebElement quantity;
    @FindBy(xpath = "//button[@class='btn btn-add-to-cart']")
    public WebElement btnBuy;
    @FindBy(xpath = "//i[@class='tikicon icon-cart']")
    public WebElement btnCart;
    @FindBy(id ="onesignal-popover-cancel-button")
    public WebElement btnCancel;
    @FindBy(xpath ="//h1[@class='title']")
    public WebElement itemTitle;
    @FindBy(xpath ="(//p[@class='price'])[1]")
    public WebElement itemPrice;

    public void clickBuyBtn(String qty) throws InterruptedException {
        waitFunc.until(ExpectedConditions.elementToBeClickable(quantity)).clear();
        quantity.sendKeys(qty);
        waitFunc.until(ExpectedConditions.elementToBeClickable(btnBuy)).click();
    }
    public Map getItemInfo() {
        Map item1 = new HashMap();
        String title = waitFunc.until(ExpectedConditions.visibilityOf(itemTitle)).getText().trim();
        System.out.println(title);
        item1.put("Title", title);
        String price = waitFunc.until(ExpectedConditions.visibilityOf(itemPrice)).getText().trim();
        price = price.substring(0, price.length()-3);
        item1.put("Price", price);
        item1.put("Qty", 1);
        return item1;
    }
    public void clickCartBtn(){
        try{waitFunc.until(ExpectedConditions.elementToBeClickable(btnCancel)).click();}
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        waitFunc.until(ExpectedConditions.elementToBeClickable(btnCart)).click();
    }

}
