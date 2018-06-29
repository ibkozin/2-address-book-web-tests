package ibkozin.ptf.litecart;

import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class Task1 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod

    public void start() {

//        driver = new ChromeDriver();
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(new FirefoxBinary(new File("C:\\Program Files\\Firefox Nightly\\firefox.exe")));
        driver = new FirefoxDriver(options);
        wait = new WebDriverWait(driver, 10);

    }
        @Test
        public void exercise1 () {

            driver.navigate().to("http://ruzine.ru");
            driver.findElement(By.id("root_cat_adult_men")).click();
            driver.findElement(By.xpath("//img[@src='/published/publicdata/RUZINERTEST/attachments/SC/products_pictures/kostjum-indeec-majja-karnaval%27nyj-maskaradnyj-muzhskoj-ruzineaf_thm.jpg']")).click();
            driver.findElement(By.name("option_1")).click();
            driver.findElement(By.name("add2cart")).click();
            driver.findElement(By.name("checkout")).click();
        }


            @AfterMethod

            public void stop () {

                driver.quit();

                driver = null;

            }

}