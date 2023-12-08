package tests;

import org.marinb.automation.config.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonTestsConditions {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverSingleton.createDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        WebDriverSingleton.closeDriver();
    }

}
