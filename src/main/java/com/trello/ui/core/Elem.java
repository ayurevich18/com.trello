package com.trello.ui.core;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;

import static com.trello.ui.core.BrowserFactory.driver;
import static com.trello.ui.core.BrowserFactory.getWebDriverWait;


public class Elem {

    private By by;
    private String name;
    private long timeout = 10;

    public Elem(By by,String name) {
        this.by=by;
        this.name=name;

    }

    public Elem(By by) {
        this(by,"");
    }


    public WebElement find(){
        return getWebDriverWait(timeout).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(){
        find().click();
    }

    public void type(String text){
        find().clear();
        find().sendKeys(text);
    }

    public boolean isPresent(){
        try {
            getWebDriverWait(timeout).until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (TimeoutException e){
            return false;
        }
    }

    public List<WebElement> finds() {
        return getWebDriverWait(timeout)
                .withMessage("Element: " + name + " not found on page: " + driver().getCurrentUrl())
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }



}
