package com.trello.ui.core;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class BrowserFactory {

    public static WebDriver driver;
    private Logger logger= LoggerFactory.getLogger(BrowserFactory.class);



@BeforeSuite
public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    logger.info("OPEN BROWSER");
}





@AfterTest
public void tearDown(){
    driver.quit();
    logger.info("CLOSE BROWSER");
}


public static WebDriver driver(){
    return driver;
}

public static void get(String url){
    driver().get(url);
}

public static void getWebDriverWait(){}
}