package regression;

import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.BoardPage;
import com.trello.ui.pages.BoardsPage;
import com.trello.ui.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BrowserFactory {
    LoginPage loginPage=new LoginPage();
    BoardsPage boardsPage=new BoardsPage();
    BoardPage boardPage=new BoardPage();

    @Test
    public void login() throws InterruptedException {

        driver().get("https://trello.com/b/rwRWidif/999");








    }
}
