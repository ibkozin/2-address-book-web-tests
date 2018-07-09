package ibkozin.ptf.litecart.Task10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class LiteCartBase {
    protected WebDriver driver;

    @BeforeMethod
    public void start() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void stop(){
        driver.quit();
        driver = null;

    }
}
