package com.trello.ui.pages;

import com.trello.ui.core.Elem;
import org.openqa.selenium.By;

public class BoardsPage {
    public static final String PATH="aleksey899/boards";




    public void open(){}

    public void isOpened(){}

    public Elem boardByUrlName(String urlName){
        return new Elem(By.cssSelector(".board-tile[href*='"+urlName+"']"), urlName);
    }

    public void openBoard(String urlName){
        boardByUrlName(urlName).click();
    }
}
