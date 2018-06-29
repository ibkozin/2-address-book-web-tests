package ibkozin.ptf.litecart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Task7 {
    private WebDriver wd;
    private WebDriverWait wait;
    public boolean isElementPresents(By locator){
        try {
            wd.findElements(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }

    }

    @BeforeMethod
    public void start(){
        wd = new ChromeDriver();
//      wait = new WebDriverWait(wd, 5);
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Test
    public void task7(){
        wd.navigate().to("http://localhost/litecart/admin/");
        type("div#box-login [name=username]", "admin");
        type("div#box-login [name=password]", "admin");
        wd.findElement(By.name("login")).click();
        assertHeader(By.cssSelector("ul#box-apps-menu>li:nth-child(1)"));
        assertHeader(By.cssSelector("#doc-template"));
        assertHeader(By.cssSelector("#doc-logotype"));
        assertHeader(By.cssSelector("ul#box-apps-menu>li:nth-child(2)"));
        assertHeader(By.cssSelector("#doc-catalog"));
        assertHeader(By.cssSelector("#doc-product_groups"));
        assertHeader(By.cssSelector("#doc-option_groups"));
        assertHeader(By.cssSelector("#doc-manufacturers"));
        assertHeader(By.cssSelector("#doc-suppliers"));
        assertHeader(By.cssSelector("#doc-delivery_statuses"));
        assertHeader(By.cssSelector("#doc-sold_out_statuses"));
        assertHeader(By.cssSelector("#doc-quantity_units"));
        assertHeader(By.cssSelector("#doc-csv"));
        assertHeader(By.cssSelector("ul#box-apps-menu>li:nth-child(3)"));
        assertHeader(By.cssSelector("ul#box-apps-menu>li:nth-child(4)"));
        assertHeader(By.cssSelector("ul#box-apps-menu>li:nth-child(5)"));
        assertHeader(By.cssSelector("ul#box-apps-menu>li:nth-child(6)"));
        assertHeader(By.cssSelector("ul#box-apps-menu>li:nth-child(7)"));
        assertHeader(By.cssSelector("ul#box-apps-menu>li:nth-child(8)"));
        assertHeader(By.cssSelector("ul#box-apps-menu>li:nth-child(9)"));
        assertHeader(By.cssSelector("ul#box-apps-menu>li:nth-child(10)"));
        assertHeader(By.cssSelector("ul#box-apps-menu>li:nth-child(11)"));
        assertHeader(By.cssSelector("ul#box-apps-menu>li:nth-child(12)"));
        assertHeader(By.cssSelector("ul#box-apps-menu>li:nth-child(13)"));
        assertHeader(By.cssSelector("ul#box-apps-menu>li:nth-child(14)"));
        assertHeader(By.cssSelector("ul#box-apps-menu>li:nth-child(15)"));
        assertHeader(By.cssSelector("ul#box-apps-menu>li:nth-child(16)"));
        assertHeader(By.cssSelector("ul#box-apps-menu>li:nth-child(17)"));

    }

    private void assertHeader(By locator) {
        wd.findElement(locator).click();
        isElementPresents(By.cssSelector("h1"));
    }

    public void type(String locator, String text) {
        wd.findElement(By.cssSelector(locator)).click();
        wd.findElement(By.cssSelector(locator)).clear();
        wd.findElement(By.cssSelector(locator)).sendKeys(text);
    }

    @AfterMethod
    public void stop(){
        wd.quit();
        wd =null;

    }

}


