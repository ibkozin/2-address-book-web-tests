package ibkozin.ptf.litecart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task8 {
    private WebDriver driver;


    @BeforeMethod
    public void start() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void task8(){
        driver.navigate().to("http://localhost/litecart/");
//        areElementsPresent(By.cssSelector("a.link[title='Purple Duck']"));
//        areElementsPresent(By.cssSelector("a.link[title='Yellow Duck']"));
//        areElementsPresent(By.cssSelector("a.link[title='Blue Duck']"));
//        areElementsPresent(By.cssSelector("a.link[title='Red Duck']"));
//        areElementsPresent(By.cssSelector("a.link[title='Green Duck']"));
          List<WebElement> products = driver.findElements(By.cssSelector("[class^=listing] a.link"));
          for (WebElement product : products){
              List<WebElement> stickers = product.findElements(By.cssSelector("div.sticker"));
              Assert.assertEquals(stickers.size(), 1);
          }

    }
//    boolean areElementsPresent(By locator) {
//        WebElement product = driver.findElement(locator);
//        return product.findElements(By.cssSelector("div.sticker")).size() == 1;
//    }



    @AfterMethod
    public void stop(){
        driver.quit();
        driver = null;

    }
}
