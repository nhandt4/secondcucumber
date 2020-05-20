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

public class SearchResultPage {
    private WebDriverWait waitFunc;
    public WebDriver driver;
    @FindBy(xpath = "//div[@class = 'result-text']")
    public WebElement noResult;
    @FindBy(xpath = "//div[@class = 'filter-list-box']")
    public WebElement result;
    @FindBy(xpath = "(//div[@class = 'product-item    search-div-product-item'])[1]")
    public WebElement item;

//    @FindBy(xpath = "(//a[@class='search-a-product-item'])[1]//p[@class='title']")
    @FindBy(xpath = "(//a[@class='search-a-product-item'])[1]")
    public WebElement itemTitle;
    @FindBy(xpath = "(//span[@class='final-price'])[1]")
    public WebElement itemPrice;

    public SearchResultPage(){
        this.driver = Hooks.driver;
        PageFactory.initElements(driver,this);
        this.waitFunc = new WebDriverWait(driver, 20);
    }
    public Map getItemInfo(){
        Map item1=new HashMap();
        String title = waitFunc.until(ExpectedConditions.visibilityOf(itemTitle)).getAttribute("title").trim();
        item1.put("Title", title);
        String price = waitFunc.until(ExpectedConditions.visibilityOf(itemPrice)).getText().trim();
        item1.put("Price", price);
        item1.put("Qty", 1);
        return item1;
    }
    public String checkSearchResult(){
        String searchResult = "";
        try{
            searchResult= waitFunc.until(ExpectedConditions.visibilityOf(result)).getText();
        }
        catch (Exception e){
            if(e.getMessage().contains("NoSuch")){
                searchResult= waitFunc.until(ExpectedConditions.visibilityOf(noResult)).getText();
            }
        }
        return searchResult;
    }
    public boolean  clickFirstItem(){
        String result = this.checkSearchResult();
        if(result.contains("Không tìm thấy")){
            return false;
        } else{
            waitFunc.until(ExpectedConditions.elementToBeClickable(item)).click();
            return true;
        }
    }

}
