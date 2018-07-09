package ibkozin.Asurion;

import ibkozin.Asurion.appmanager.ContactHelper;
import ibkozin.Asurion.appmanager.GroupHelper;
import ibkozin.Asurion.appmanager.NavigationHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class AsurionBase {
    WebDriver wd;
    private String browser;

    public AsurionBase(String browser) {
        this.browser = browser;
    }


    public void init() {
        if ( wd != null){ return;}
        if (browser.equals(BrowserType.FIREFOX)){

            wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
//            FirefoxOptions options = new FirefoxOptions();
//            options.setBinary(new FirefoxBinary(new File("C:\\Program Files\\Firefox Nightly\\firefox.exe")));
//            wd = new FirefoxDriver(options);
        } else if (browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)){
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);


        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> { wd.quit(); wd = null; }));


        wd.get("https://careers.asurion.com/");
    }

    public void stop() {
//        wd.quit();
    }

}
