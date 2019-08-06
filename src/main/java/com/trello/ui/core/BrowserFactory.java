package com.trello.ui.core;



import com.trello.ui.core.listeners.BrowserListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class BrowserFactory {

    public static WebDriver driver;
    private Logger logger = LoggerFactory.getLogger(BrowserFactory.class);


    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "var/jenkins_home/.m2/repository/webdriver/chromedriver/linux64/76.0.3809.68/chromedriver");
        driver = new ChromeDriver();
        driver = new EventFiringWebDriver(driver).register(new BrowserListener());
        logger.info("OPEN BROWSER");
    }


    @AfterSuite
    public void tearDown() {
        driver.quit();
        logger.info("CLOSE BROWSER");
    }


    public static WebDriver driver() {
        return driver;
    }

    public static void get(String url) {
        driver().get(url);
    }

    public static WebDriverWait getWebDriverWait(long timeout) {
        return new WebDriverWait(driver(), timeout);
    }
}