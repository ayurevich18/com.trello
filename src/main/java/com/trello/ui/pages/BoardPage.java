package com.trello.ui.pages;

import com.trello.ui.core.Elem;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.trello.ui.core.BrowserFactory.driver;

public class BoardPage {

    public static final String PATH="aleksey899/boards";

    public Elem addList=new Elem(By.cssSelector("form>a"),"Add a list");
    public Elem listTitle=new Elem(By.cssSelector("input.list-name-input"),"Enter list title");
    public Elem addListButton=new Elem(By.cssSelector("input[value='Add List']"),"Add List Button");
    public Elem list=new Elem(By.cssSelector(".list.js-list-content"),"List");
    public Elem addCardBtn=new Elem(By.cssSelector("a.open-card-composer"),"Add card");
    public Elem cardTitle=new Elem(By.cssSelector(".list-card-composer-textarea"),"Card title");

    public void setAddList(String name){
        addList.click();
        listTitle.type(name);
        addListButton.click();
        new WebDriverWait(driver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".list.js-list-content")));

    }

    public void setAddCard(){
        addCardBtn.finds().get(0).click();
        cardTitle.type("yyy");
//        addListButton.click();
//        new WebDriverWait(driver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".list-card-details> span")));


    }

}
