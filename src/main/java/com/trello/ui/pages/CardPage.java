package com.trello.ui.pages;

import com.trello.ui.core.Elem;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.trello.ui.core.BrowserFactory.driver;

public class CardPage {

    private Elem nameFld = new Elem(By.cssSelector("textarea.js-card-detail-title-input"), "Card name field");
    private Elem openDescr = new Elem(By.cssSelector(".js-hide-with-draft"), "Open Description Body");
    private Elem descriptionBody = new Elem(By.cssSelector(".card-description"), "Description Body");
    private Elem saveButton = new Elem(By.cssSelector(".mod-submit-edit"), "Save Button");
    private Elem editBtn = new Elem(By.cssSelector(".button.js-edit-desc"), "Edit Button");
    private Elem commentInput = new Elem(By.cssSelector("textarea.js-new-comment-input"), "Comment Input");
    private Elem commentSaveBtn = new Elem(By.cssSelector(".mod-no-top-bottom-margin"), "Save comment button");
    private Elem labelBtn= new Elem(By.cssSelector(".js-edit-labels"), "Add label button");
    private Elem searchInput= new Elem(By.cssSelector(".js-label-search"), "Search input label menu");
    private Elem selectLabel= new Elem(By.cssSelector(".js-select-label"), "Select label");
    private Elem membersBtn= new Elem(By.cssSelector(".js-change-card-members"), "Members");
    private Elem searchMembers= new Elem(By.cssSelector(".js-search-mem"), "Search Members");
    private Elem selectMember= new Elem(By.cssSelector(".js-select-member"), "Select member");
    private Elem checklistAdd= new Elem(By.cssSelector(".js-add-checklist-menu"), "Add checklist");
    private Elem titleCheckList= new Elem(By.cssSelector("#id-checklist"), "Title cheklist");
    private Elem checkAddBtn= new Elem(By.cssSelector(".js-add-checklist"), "Add checklist Button");








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

    public void addMember(String name){
        membersBtn.click();
        searchMembers.type(name);
        selectMember.click();
        new WebDriverWait(driver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".card-detail-item-header.mod-no-top-margin")));

    }

    public void addChecklist(String name){
        checklistAdd.click();
        titleCheckList.type(name);
        checkAddBtn.click();
        new WebDriverWait(driver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h3.current.hide-on-edit")));

    }








}