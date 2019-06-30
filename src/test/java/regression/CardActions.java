package regression;

import com.trello.api.TrelloRestClient;
import com.trello.api.models.Card;
import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.BoardsPage;
import com.trello.ui.pages.CardPage;
import com.trello.ui.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CardActions extends BrowserFactory  {
    public TrelloRestClient client = new TrelloRestClient();

    public LoginPage loginPage = new LoginPage();
    public BoardsPage boardsPage = new BoardsPage();
    public CardPage cardPage = new CardPage();

    Card card = new Card("Test_Card_"+new Date().getTime());


    @BeforeTest
    public void prepareData() throws IOException {
        card = client.cardsService.createCard("5d0fdada6309167542dc84bd", card).execute().body();
        System.out.println(card);
    }



    @Test
    public void loginTest()throws IOException{
        driver().get("https://trello.com");
        loginPage.loginAPI();


    }

    @Test(dependsOnMethods = "loginTest")
    public void openCard()throws InterruptedException{
        driver().get(card.url);
        Thread.sleep(10000);
    }

    @Test
    public void moveCard(){
        //   cardPage.moveToList(""):

    }

    @Test(dependsOnMethods ="loginTest")
    public void renameCardTest() throws IOException{
        driver().get(card.url);
        cardPage.ranameCard("Test");
        String cardName=getCardItems(card.id).name;
        Assert.assertEquals("Test",cardName);

    }



    @Test(dependsOnMethods ="loginTest")
    public void writeDescriptionTest()throws IOException{
        driver().get(card.url);
        String setDesc="test hhhhhhh";
        cardPage.writeDescription(setDesc);
        String cardDesc=getCardItems(card.id).desc;
        Assert.assertEquals(setDesc,cardDesc);
    }

    @Test(dependsOnMethods ="loginTest")
    public void editDescriptionTest()throws IOException{
        driver().get(card.url);
        String setDesc="test hhhhhhh";
        cardPage.writeDescription(setDesc);
        String setDesc1="Hello word";
        cardPage.editDescription(setDesc1);
        String cardDesc=getCardItems(card.id).desc;
        Assert.assertEquals(setDesc1,cardDesc);

    }

    @Test(dependsOnMethods ="loginTest")
    public void addComentTest()throws IOException{
        driver().get(card.url);
        String addCom="Test";
        cardPage.addComment(addCom);
        String qtyComments=client.cardsService.getCard(card.id).execute().body().badges.comments;
        Assert.assertEquals("1",qtyComments);

    }


    @Test(dependsOnMethods ="loginTest")
    public void addLabelTest()throws IOException{
        driver().get(card.url);
        String setColor="green";
        cardPage.addLabel(setColor);
        String apiGetColor=getCardItems(card.id).labels.get(0).color;
        Assert.assertEquals(setColor,apiGetColor);
    }








    @AfterTest
    public void clearData() throws IOException {
       client.cardsService.deleteCard(card.id).execute();
    }

    private Card getCardItems(String cardId) throws IOException{
        return client.cardsService.getCard(cardId).execute().body();
    }
}
