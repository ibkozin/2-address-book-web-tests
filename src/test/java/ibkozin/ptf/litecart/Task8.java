package ibkozin.ptf.litecart;

import ibkozin.ptf.litecart.Task10.LiteCartBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Task8 extends LiteCartBase {


    @Test
    public void task8(){
        driver.navigate().to("http://localhost/litecart/");
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


}
