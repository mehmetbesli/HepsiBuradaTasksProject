package com.hepsiBurada;



import com.hepsiBurada.page.Home;
import com.hepsiBurada.page.Product;
import com.hepsiBurada.page.Search;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Automation extends AbstractPage{

    private Home home;
    private Product product;
    private Search search;

    public void hepsiBuradaWebSiteTestCase() {
        try {
            openChromeBrowser();

            home=new Home(driver);
            search=new Search(driver);
            product=new Product(driver);

            navigateToUrl();
            typeProductInSearch();
            clickAraBtn();
            clickFirstProduct();
            clickCommentTab();
            clickYesBtn();
            messagePopupControl();
        }catch (Exception e){
            log.error("An error occurred ",e);
        }finally {
            if(driver!=null){
                driver.quit();
            }
        }
    }

    public void messagePopupControl() {
        product.messagePopupControl();
    }

    public void clickYesBtn() {
        product.clickYesBtn();
    }

    public void clickCommentTab() throws InterruptedException {
        product.clickCommentTab();
    }

    public void clickFirstProduct() {
        search.clickFirstProduct();
    }

    private void clickAraBtn() {
        home.clickAraBtn();
    }

    public void typeProductInSearch() throws InterruptedException {
        home.typeProductInSearch();
    }

    public void navigateToUrl() {
        home.navigateToUrl();
    }

    public void openChromeBrowser() {
        String path = System.getProperty("user.dir");
        System.out.println("Proje path : " + path);
        System.setProperty("webdriver.chrome.driver", path + "\\lib\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
}