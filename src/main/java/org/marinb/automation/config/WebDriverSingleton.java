package org.marinb.automation.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.marinb.automation.service.TestDataReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;


public class WebDriverSingleton{

    private static final Logger logger = LogManager.getLogger(WebDriverSingleton.class);
    private static  final String AD_BLOCKER= "testdata.adblocker";
    private static WebDriver driver;
    private WebDriverSingleton() {}
    public static WebDriver createDriver() {
        if(driver == null){
            String browser = System.getProperty("browser");
            switch (browser) {
                case "firefox":
                    logger.info("Setting browser: Firefox");
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    logger.info("Setting browser: Edge");
                    driver = new EdgeDriver();
                    break;
                case "chrome":
                default:
                    logger.info("Setting browser: Chrome");
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addExtensions(new File("src/test/resources/AdBlock-el-mejor-bloqueador-de-anuncios.crx"));
                    driver = TestDataReader.getTestData(AD_BLOCKER).equals("true") ? new ChromeDriver(chromeOptions) : new ChromeDriver();

            }
            driver.manage().window().maximize();
        }
        logger.info("Driver was created and set up");
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }

}
