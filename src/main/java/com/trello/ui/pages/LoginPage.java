package com.trello.ui.pages;

import com.trello.api.SimpleOkHttpCookieJar;
import com.trello.ui.core.Constants;
import com.trello.ui.core.Elem;
import okhttp3.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.trello.ui.core.BrowserFactory.driver;
import static com.trello.ui.core.BrowserFactory.get;

public class LoginPage {
    public static final String PATH = "login";
    public Elem loginFld = new Elem(By.cssSelector("#user"), "Login Field");
    public Elem passwordFld = new Elem(By.cssSelector("#password"), "Password field");
    public Elem loginButton = new Elem(By.cssSelector("#login"), "Login Button");

    public void open() {
        get(Constants.URL + PATH);
        Assert.assertTrue(isOpened(), "Page 'Login' [" + PATH + "] not Opened");
    }

    public boolean isOpened() {
        return loginButton.isPresent() && driver().getCurrentUrl().equals(Constants.URL + PATH);
    }

    public void login(String email, String password) {
        loginFld.type(email);
        passwordFld.type(password);
        loginButton.click();
        System.out.println(driver().manage().getCookies());

    }

    public void setCookies() {
        Cookie ck = new Cookie("dsc", "b87dcbf9e520c6934d3a9cfb962b21d900f249c3252eb4264d2afa0ef30b3a19");
        Cookie ck1 = new Cookie("token", "5c23b46c203b752e0cec7634%2FaVnJTvYO8x22R4z211eMnoMw220cyVf7dy8LCQJu0o4bQMLSJUdiW8fWOjxS7BRU");
        driver().manage().addCookie(ck);
        driver().manage().addCookie(ck1);

    }

    public void loginAPI() throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder().cookieJar(new SimpleOkHttpCookieJar()).build();

        Request request3 = new Request.Builder()
                .url("https://trello.com")
                .build();
        String cookie="";
        Response response3 = client.newCall(request3).execute();
        for (okhttp3.Cookie s : SimpleOkHttpCookieJar.storage) {
            cookie=s.name()+"="+s.value();

            System.out.println("cookies: " + s);
        }


System.out.println(SimpleOkHttpCookieJar.storage.get(0));


        MediaType textPlainMT = MediaType.parse("application/x-www-form-urlencoded");
        String bodyMessage = "method=password&factors%5Buser%5D=aleksej.yurevich%40gmail.com&factors%5Bpassword%5D=12345678q&castleClientId=fc3fea79-3694-40f5-8880-907c5aa2c2b6-af7e0e1eb84f131a4dbce0bd";
        Request request = new Request.Builder().url("https://trello.com/1/authentication")
                .post(RequestBody.create(textPlainMT, bodyMessage)).build();
        Response response = client.newCall(request).execute();


        String s = response.body().string();
        String code = s.substring(s.indexOf(":") + 2, s.lastIndexOf("\""));
        System.out.println(s);
        System.out.println("CODE : " + code);


        MediaType textPlainMT1 = MediaType.parse("application/x-www-form-urlencoded");
        String helloMsg1 = "authentication=" + code + "&" + cookie;
        System.out.println(helloMsg1);
        Request request1 = new Request.Builder().url("https://trello.com/1/authorization/session")
                .post(RequestBody.create(textPlainMT1, helloMsg1)).build();
        Response response1 = client.newCall(request1).execute();
        System.out.println(response1.body().string());


    }

}
