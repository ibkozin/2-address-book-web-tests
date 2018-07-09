package ibkozin.Asurion.CareersAsurion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HeaderTests {
    private WebDriver wd;
    private WebDriverWait wait;


    @BeforeSuite
    public void start() {
        wd = new ChromeDriver();
//      wait = new WebDriverWait(wd, 5);
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
        @Test
        public void test1(){
            wd.navigate().to("https://careers.asurion.com/");
            wd.findElements(By.cssSelector(""));

        }



        @AfterSuite
        public void stop(){
//            wd.quit();
//            wd =null;
        }

}
