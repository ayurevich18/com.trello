package junk;

import com.trello.ui.pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class TryLogger {
    private Logger logger= LoggerFactory.getLogger(TryLogger.class);
    LoginPage loginPage=new LoginPage();
    @Test
    public  void as(){
        logger.info("fgdfgdgdfg");
    }

    @Test
    public void tryLogginApi() throws IOException {
        loginPage.loginAPI();

    }
}
