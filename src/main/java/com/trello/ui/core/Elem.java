package com.trello.ui.core;

import org.openqa.selenium.By;

import static com.trello.ui.core.BrowserFactory.driver;


public class Elem {
    private By by;
    private String name;
    public Elem(By by,String name) {
        this.by=by;
        this.name=name;

    }

    public Elem(By by) {
        this(by,"");
    }

    public void click(){
        driver().findElement(by).click();
    }

    public void type(String text){
        driver().findElement(by).clear();
        driver().findElement(by).sendKeys(text);
    }




}
