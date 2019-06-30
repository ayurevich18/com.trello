package com.trello.ui.pages;

import com.trello.ui.core.Elem;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.trello.ui.core.BrowserFactory.driver;

public class CardPage {

    public Elem nameFld = new Elem(By.cssSelector("textarea.js-card-detail-title-input"), "Card name field");
    public Elem openDescr = new Elem(By.cssSelector(".js-hide-with-draft"), "Open Description Body");
    public Elem descriptionBody = new Elem(By.cssSelector(".card-description"), "Description Body");
    public Elem saveButton = new Elem(By.cssSelector(".mod-submit-edit"), "Save Button");
    public Elem editBtn = new Elem(By.cssSelector(".button.js-edit-desc"), "Edit Button");
    public Elem commentInput = new Elem(By.cssSelector("textarea.js-new-comment-input"), "Comment Input");
    public Elem commentSaveBtn = new Elem(By.cssSelector(".mod-no-top-bottom-margin"), "Save comment button");
    public Elem labelBtn= new Elem(By.cssSelector(".js-edit-labels"), "Add label button");
    public Elem searchInput= new Elem(By.cssSelector(".js-label-search"), "Search input label menu");
    public Elem selectLabel= new Elem(By.cssSelector(".js-select-label"), "Select label");







    public void ranameCard(String name){
        nameFld.click();
        nameFld.type(name);
        nameFld.clickKeyBoardBtn(Keys.ENTER);
        new WebDriverWait(driver(), 10).until(ExpectedConditions.titleIs(name+" on 999 | Trello"));

    }

    public void writeDescription(String description){
        openDescr.click();
        descriptionBody.type(description);
        saveButton.click();
        new WebDriverWait(driver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".button.js-edit-desc")));

    }

    public void editDescription(String description){
        editBtn.click();
        descriptionBody.type(description);
        saveButton.click();
        new WebDriverWait(driver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".button.js-edit-desc")));


    }

    public void addComment(String comment){
        commentInput.click();
        commentInput.type(comment);
        commentSaveBtn.click();
        new WebDriverWait(driver(), 10).until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.cssSelector(".js-add-comment"))));


    }

    public void addLabel(String color){
        labelBtn.click();
        searchInput.type(color);
        selectLabel.click();
        new WebDriverWait(driver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".js-card-detail-labels .card-detail-item-header")));


    }



}