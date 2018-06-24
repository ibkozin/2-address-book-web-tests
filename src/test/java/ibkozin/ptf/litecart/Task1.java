package ibkozin.ptf.litecart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task1 {

    private WebDriver driver;



    @BeforeMethod



    public void start(){

        driver = new InternetExplorerDriver();

    }



    @Test



    public void exercise1 (){

        driver.navigate().to("http://www.ruzine.ru");

    }

    @AfterMethod



    public void stop(){

        driver.quit();

        driver = null;

    }
}
