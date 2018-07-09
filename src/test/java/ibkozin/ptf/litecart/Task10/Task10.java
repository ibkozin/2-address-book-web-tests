package ibkozin.ptf.litecart.Task10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task10 extends LiteCartBase {

    @Test
    public void task10(){
        driver.navigate().to("http://localhost/litecart");
        WebElement productCampaignsBox = driver.findElement(By.cssSelector("div#box-campaigns li.product:nth-child(1)"));
        productCampaignsBox.click();
        WebElement productPage = driver.findElement(By.cssSelector("div#box-product"));
        Assert.assertEquals(productCampaignsBox.findElement(By.cssSelector("div.name")).getText(), productPage.findElement(By.cssSelector("h1.title")).getText());
    }
}
