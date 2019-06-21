package logintest;

import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BrowserFactory {
    LoginPage loginPage=new LoginPage();

    @Test
    public void login(){

        loginPage.open();
        loginPage.login("aleksej.yurevich@gmail.com","12345678q");


    }
}
