import com.hepsiBurada.AbstractPage;
import com.hepsiBurada.Automation;
import com.hepsiBurada.page.Home;
import com.hepsiBurada.page.Product;
import com.hepsiBurada.page.Search;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestScenario extends AbstractPage {

    private Automation automation;
    private Home home;
    private Product product;
    private Search search;


    @Before
    public void openBrowser() {
        automation = new Automation();
        automation.openChromeBrowser();
        home=new Home(driver);
        product =new Product(driver);
        search=new Search(driver);
    }


    @Test
    public void gotoN11WebPageTest() {
        home.navigateToUrl();
    }

    @Test
    public void clickAraBtnTest() {
        home.navigateToUrl();
        home.typeProductInSearch();
        home.clickAraBtn();
    }

    @Test
    public void clickCommentTabTest() throws InterruptedException {
        home.navigateToUrl();
        home.typeProductInSearch();
        home.clickAraBtn();
        search.clickFirstProduct();
        product.clickCommentTab();
    }

    @Test
    public void messagePopupControlTest() throws InterruptedException {
        home.navigateToUrl();
        home.typeProductInSearch();
        home.clickAraBtn();
        search.clickFirstProduct();
        product.clickCommentTab();
        product.clickYesBtn();
        product.messagePopupControl();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}