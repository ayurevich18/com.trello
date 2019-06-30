package junk;

import com.trello.api.TrelloRestClient;
import com.trello.api.models.Card;
import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.LoginPage;
import jdk.nashorn.internal.ir.Labels;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class TryLogger extends BrowserFactory {
    private Logger logger= LoggerFactory.getLogger(TryLogger.class);
    public TrelloRestClient client = new TrelloRestClient();
    LoginPage loginPage=new LoginPage();

    @Test
    public  void as(){
        logger.info("fgdfgdgdfg");
    }

    @Test
    public void tryLogginApi() throws IOException,InterruptedException {
        driver().get("https://trello.com/b/rwRWidif/999");
        loginPage.loginAPI();
        driver().get("https://trello.com/b/rwRWidif/999");
        Thread.sleep(10000);

    }
    @Test
    public void tryqq()throws IOException{

        Card card= new Card();
       card= client.cardsService.getCard("5d1670c8c47def2a20f8678c").execute().body();
       System.out.println(card.labels.get(0).color);

    }
}
