package com.trello.ui.pages;

import com.trello.ui.core.Elem;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.trello.ui.core.BrowserFactory.driver;

public class BoardPage {



    public Elem addList=new Elem(By.cssSelector("form>a"),"Add a list");
    public Elem listTitle=new Elem(By.cssSelector("input.list-name-input"),"Enter list title");
    public Elem addListButton=new Elem(By.cssSelector("input[value='Add List']"),"Add List Button");
    public Elem list=new Elem(By.cssSelector(".list.js-list-content"),"List");
    public Elem addCardBtn=new Elem(By.cssSelector("a.open-card-composer"),"Add card");
    public Elem cardTitle=new Elem(By.cssSelector(".list-card-composer-textarea"),"Card title");
    public Elem menuList=new Elem(By.cssSelector(".list-header-extras-menu"),"Menu List");
    public Elem copyList=new Elem(By.cssSelector(".js-copy-list"),"Copy List");
    public Elem creteListBtn=new Elem(By.cssSelector("input[value='Create List']"),"Create list Button");
    public Elem deleteListBtn=new Elem(By.cssSelector(".js-close-list"),"Delete");





    public void setAddList(String name){
        addList.click();
        listTitle.type(name);
        addListButton.click();
        new WebDriverWait(driver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".list.js-list-content")));

    }

    public void openListMenu(){
        menuList.finds().get(0).click();
        new WebDriverWait(driver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".pop-over-header")));

    }

    public void copyList(){
        openListMenu();
        copyList.click();
        creteListBtn.click();

    }

    public void deleteList(){
        openListMenu();
        deleteListBtn.click();


    }



    public boolean listCheck(){
        return list.isPresent();
    }

    public boolean checkListCopy(){
        if(list.finds().size()>1)return true;
        return false;
    }

}
