import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCtrlV {
    public static void main(String [] arg){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://ruzine.ru");
        driver.findElement(By.cssSelector("input#searchstring")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
    }
}
