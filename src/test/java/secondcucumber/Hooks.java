package secondcucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void initTest(){
        System.setProperty("webdriver.gecko.driver", "src\\test\\drivers\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver","src\\test\\drivers\\chromedriver.exe");
        String browserName = System.getProperty("browser","chrome");
        if(browserName.equalsIgnoreCase("chrome")){
            this.driver = new ChromeDriver();
        }else this.driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @After
    public void finishTC(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshots = ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshots, "image/png");
        }
        this.driver.quit();
    }
}
