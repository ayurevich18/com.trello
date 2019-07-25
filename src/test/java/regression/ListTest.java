package regression;

import com.trello.api.TrelloRestClient;
import com.trello.ui.core.BrowserFactory;
import com.trello.ui.core.Constants;
import com.trello.ui.pages.BoardPage;
import com.trello.ui.pages.BoardsPage;
import com.trello.ui.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ListTest extends BrowserFactory {
    public LoginPage loginPage = new LoginPage();
    public BoardsPage boardsPage = new BoardsPage();
    public BoardPage boardPage = new BoardPage();
    public TrelloRestClient client = new TrelloRestClient();


    @Test
    public void loginApi() throws IOException {
        get(Constants.URL);
        loginPage.loginAPI();

    }

    @Test(dependsOnMethods = "loginApi")
    public void createListTest() {
        get(Constants.URL + BoardsPage.PATH);
        boardsPage.open("25");
        boardPage.setAddList("Test");
        Assert.assertTrue(boardPage.listCheck());
    }

    @Test(dependsOnMethods = "createListTest")
    public void copyListTest() {
        boardPage.copyList();
        Assert.assertTrue(boardPage.checkListCopy());
    }

    @Test(dependsOnMethods = "copyListTest")
    public void deleteList() {
        boardPage.deleteList();
        Assert.assertFalse(boardPage.checkListCopy());
    }
}
