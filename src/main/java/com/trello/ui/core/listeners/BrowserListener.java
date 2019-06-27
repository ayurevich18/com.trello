package com.trello.ui.core.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class BrowserListener implements WebDriverEventListener {

    private Logger logger = LoggerFactory.getLogger(BrowserListener.class);

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    public void beforeNavigateTo(String url, WebDriver driver) {
        logger.info("Navigate: '"+url+"'");
    }

    public void afterNavigateTo(String url, WebDriver driver) {

    }

    public void beforeNavigateBack(WebDriver driver) {

    }

    public void afterNavigateBack(WebDriver driver) {

    }

    public void beforeNavigateForward(WebDriver driver) {

    }

    public void afterNavigateForward(WebDriver driver) {

    }

    public void beforeNavigateRefresh(WebDriver driver) {

    }

    public void afterNavigateRefresh(WebDriver driver) {

    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver) {

    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {

    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger.info("Click element: '"+extractBy(element)+"'");
    }

    public void afterClickOn(WebElement element, WebDriver driver) {

    }

    private String webElementToString = "";

    //@Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        if(charSequences == null){
            logger.info("Clear text in element: '"+extractBy(webElement)+"'");
        } else {
            if(!webElementToString.equals(webElement.toString())) {
                logger.info("Type in element: '" + extractBy(webElement) + "' text: " + Arrays.toString(charSequences));
                webElementToString = webElement.toString();
            }
        }

    }

    //@Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    private String scriptAndPage = "";

    public void beforeScript(String script, WebDriver driver) {
        String currentUrl = driver.getCurrentUrl();
        if(!scriptAndPage.equals(script+currentUrl)){
            scriptAndPage = script+currentUrl;
            logger.info("Execute JS: '"+script+"' on page: "+currentUrl);
        }
    }

    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {
        logger.info("Switch to window: '"+s+"'");
    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {

    }


    public void onException(Throwable throwable, WebDriver driver) {

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
        logger.info("Get text from element: '" + extractBy(webElement) + "'");

    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }

    private String extractBy(WebElement element){
        String s = element.toString().substring(element.toString().indexOf("-> ")+3);
        return s.substring(0, s.length()-1);
    }

}