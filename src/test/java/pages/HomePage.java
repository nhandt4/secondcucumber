package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import secondcucumber.Hooks;

public class HomePage {
    public WebDriver driver;
    private WebDriverWait waitFunc;
    @FindBy(xpath = "//input[contains(@class, 'FormSearch__Input')]")
    public WebElement txtSearch;
    @FindBy(xpath = "//button[contains(@class, 'FormSearch__Button')]")
    public WebElement btnSearch;

    public HomePage(){
        this.driver = Hooks.driver;
        PageFactory.initElements(driver,this);
        this.waitFunc = new WebDriverWait(driver, 20);
    }
    public void search_function(String keyword){
        waitFunc.until(ExpectedConditions.visibilityOf(txtSearch)).sendKeys(keyword);
        txtSearch.sendKeys(Keys.ENTER);
//        waitFunc.until(ExpectedConditions.elementToBeClickable(btnSearch)).click();
    }

}
