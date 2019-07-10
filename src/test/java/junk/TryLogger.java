package junk;

import com.trello.api.TrelloRestClient;
import com.trello.api.models.Card;
import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.LoginPage;
import jdk.nashorn.internal.ir.Labels;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.*;
import static org.awaitility.pollinterval.FibonacciPollInterval.fibonacci;

public class TryLogger extends BrowserFactory {
    private Logger logger = LoggerFactory.getLogger(TryLogger.class);
    public TrelloRestClient client = new TrelloRestClient();
    LoginPage loginPage = new LoginPage();
    Card finalCard = new Card();

    @Test
    public void as() {
        logger.info("fgdfgdgdfg");
    }

    @Test
    public void tryLogginApi() throws IOException, InterruptedException {
        driver().get("https://trello.com/b/rwRWidif/999");
        loginPage.loginAPI();
        driver().get("https://trello.com/b/rwRWidif/999");
        Thread.sleep(10000);

    }

    @Test
    public void tryqq() throws IOException {

        Card card = new Card();
        card = client.cardsService.getCard("5d1670c8c47def2a20f8678c").execute().body();
                finalCard=card;

        Card finalCard = new Card();
        await().atMost(10, SECONDS).until(newUserIsAdded());







        Assert.assertEquals("5c23b46c203b752e0cec7634", card.getIdMembers().get(0));
        System.out.println(card.getIdMembers().get(0));
//       System.out.println(client.membersServise.getMembers("5c23b46c203b752e0cec7634").execute().body().fullName);
//       System.out.println(card.getIdChecklist().get(0));


    }

    private Callable<Boolean> newUserIsAdded() {
        return new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return finalCard.idMembers.size() == 1; // The condition that must be fulfilled
            }

        };
    }
}