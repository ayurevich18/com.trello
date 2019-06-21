package com.trello.ui.pages;

import com.trello.ui.core.Constants;
import com.trello.ui.core.Elem;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.trello.ui.core.BrowserFactory.get;

public class LoginPage {
    public static final String PATH="login";
    public Elem loginFld=new Elem(By.cssSelector("#user"),"Login Field");
    public Elem passwordFld=new Elem(By.cssSelector("#password"),"Password field");
    public Elem loginButton=new Elem(By.cssSelector("#login"),"Login Button");

    public void open(){
        get(Constants.URL+PATH);
        Assert.assertTrue(isOpened());
    }

    public boolean isOpened(){
        return true;
    }

    public void login(String email, String password){
        loginFld.type(email);
        passwordFld.type(password);
        loginButton.click();
    }


}
