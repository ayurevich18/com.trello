package com.trello.ui.pages;

import com.trello.ui.core.Elem;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.trello.ui.core.BrowserFactory.driver;

public class BoardsPage {
    public static final String PATH="aleksey899/boards";




    public void open(String name){
        boardByUrlName(name).click();
        new WebDriverWait(driver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".open-add-list")));

    }

    public void isOpened(){}

    public Elem boardByUrlName(String urlName){
        return new Elem(By.cssSelector(".board-tile[href*='"+urlName+"']"), urlName);
    }

    public void openBoard(String urlName){
        boardByUrlName(urlName).click();
    }
}
