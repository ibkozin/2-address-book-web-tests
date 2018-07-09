package ibkozin.Asurion.tests;

import ibkozin.Asurion.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected  static final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();

    }


    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}
