package com.trello.ui.pages;

import com.trello.ui.core.Elem;
import org.openqa.selenium.By;

public class BoardsPage {
    public static final String PATH="aleksey899/boards";

    public void open(){}

    public void isOpened(){}

    public void openBoard(String urlName){
        new Elem(By.cssSelector(".board-title[href*='"+urlName+"']"), urlName).click();
    }
}
