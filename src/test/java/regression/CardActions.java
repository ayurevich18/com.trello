package regression;

import com.trello.api.TrelloRestClient;
import com.trello.api.models.Card;
import com.trello.api.models.Checklists;
import com.trello.api.models.Members;
import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.BoardsPage;
import com.trello.ui.pages.CardPage;
import com.trello.ui.pages.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.IOException;

import java.util.Date;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;


public class CardActions extends BrowserFactory {
    public TrelloRestClient client = new TrelloRestClient();

    public LoginPage loginPage = new LoginPage();
    public BoardsPage boardsPage = new BoardsPage();
    public CardPage cardPage = new CardPage();

    Card card = new Card("Test_Card_" + new Date().getTime());


    @BeforeTest
    public void prepareData() throws IOException {
        card = client.cardsService.createCard("5d0fdada6309167542dc84bd", card).execute().body();
        System.out.println(card);
    }


    @Test
    @Step
    public void loginTest() throws IOException {
        driver().get("https://trello.com");
        loginPage.loginAPI();


    }


    @Test(dependsOnMethods = "loginTest")
    @Step
    public void openCard() {
        driver().get(card.url);
        Assert.assertTrue(!driver.findElements(By.cssSelector(".window")).isEmpty(), "Card page not opened");
    }

    @Test
    public void moveCard() {
        //   cardPage.moveToList(""):

    }

    @Test(dependsOnMethods = "loginTest")
    @Step
    public void renameCardTest() throws IOException {
        driver().get(card.url);
        cardPage.ranameCard("Test");
        String cardName = getCardItems(card.id).name;
        Assert.assertEquals("Test", getCardItems(card.id).name);

    }


    @Test(dependsOnMethods = "loginTest")
    @Step
    public void writeDescriptionTest() throws IOException,InterruptedException {
        driver().get(card.url);
        String setDesc = "test hhhhhhh";
        cardPage.writeDescription(setDesc);
        await().atMost(5, SECONDS).until(() -> (getCardItems(card.id).desc).equals(setDesc));
        Assert.assertEquals(setDesc, getCardItems(card.id).desc);
    }

    @Test(dependsOnMethods = "writeDescriptionTest")
    @Step
    public void editDescriptionTest() throws IOException,InterruptedException {
        driver().get(card.url);
        String setDesc1 = "Hello word";
        cardPage.editDescription(setDesc1);
        await().atMost(5, SECONDS).until(() -> (getCardItems(card.id).desc).equals(setDesc1));
        Assert.assertEquals(setDesc1, getCardItems(card.id).desc);

    }

    @Test(dependsOnMethods = "loginTest")
    @Step
    public void addComentTest() throws IOException {
        driver().get(card.url);
        String addCom = "Test";
        cardPage.addComment(addCom);
        String qtyComments = client.cardsService.getCard(card.id).execute().body().badges.comments;
        Assert.assertEquals("1", qtyComments);

    }


    @Test(dependsOnMethods = "loginTest")
    @Step
    public void addLabelTest() throws IOException,InterruptedException {
        driver().get(card.url);
        String setColor = "green";
        cardPage.addLabel(setColor);
        await().atMost(5, SECONDS).until(() -> getCardItems(card.id).labels.size() == 1);
        Assert.assertEquals(setColor, getCardItems(card.id).labels.get(0).color);
    }

    @Test(dependsOnMethods = "loginTest")
    @Step
    public void addMemberTest() throws IOException {
        driver().get(card.url);
        cardPage.addMember("Aleksey");
        Assert.assertEquals("Aleksey", getMembersItems(getIdMember()).fullName);
    }

    @Test(dependsOnMethods = "loginTest")
    @Step
    public void addChecklistTest() throws IOException {
        driver().get(card.url);
        cardPage.addChecklist("test");
         Assert.assertEquals("test", getChecklistItems(getChecklistId()).name);


    }


    @AfterTest
    public void clearData() throws IOException {
        client.cardsService.deleteCard(card.id).execute();
    }

    private Card getCardItems(String cardId) throws IOException {
        return client.cardsService.getCard(cardId).execute().body();
    }

    private Members getMembersItems(String memberId) throws IOException {
        return client.membersServise.getMembers(memberId).execute().body();
    }

    private Checklists getChecklistItems(String checklistId) throws IOException {
        return client.checklistsService.getChecklist(checklistId).execute().body();
    }

    private String getChecklistId() throws IOException {
        await().atMost(5, SECONDS).until(() -> getCardItems(card.id).getIdChecklist().size() == 1);
        return getCardItems(card.id).getIdChecklist().get(0);
    }

    private String getIdMember() throws IOException {
        return getCardItems(card.id).getIdMembers().get(0);
    }
}
