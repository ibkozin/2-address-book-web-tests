package ibkozin.ptf.litecart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task9 {
    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
            public void task9() {
        driver.navigate().to("http://localhost/litecart/admin/");
        type("div#box-login [name=username]", "admin");
        type("div#box-login [name=password]", "admin");
        driver.findElement(By.name("login")).click();
        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        List<WebElement> countries = driver.findElements(By.cssSelector("tr.row td:nth-child(5)"));
        List<String> countryList = new ArrayList<>();
        for (WebElement country : countries) {
            String countryName = country.getText();
            countryList.add(countryName);
        }

    }


    @AfterMethod

    public void stop() {
        driver.quit();
        driver = null;
    }
    public void type (String locator, String text){
        driver.findElement(By.cssSelector(locator)).click();
        driver.findElement(By.cssSelector(locator)).clear();
        driver.findElement(By.cssSelector(locator)).sendKeys(text);
    }

}
