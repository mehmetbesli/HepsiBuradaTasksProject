package com.hepsiBurada.page;

import com.hepsiBurada.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Home extends AbstractPage {

    public static final By account = By.id("myAccount");
    public static final By productSearch = By.cssSelector("input[type='text']");
    public static final By araBtn = By.cssSelector("div[class='SearchBoxOld-buttonContainer']");

    public static final String urlHepsiBurada= "https://www.hepsiburada.com/";
    public static final String productName= "iphone";

    public Home(WebDriver driver){
        this.driver=driver;
    }


    public void navigateToUrl() {
        log.info("Navigate To Automation");
        driver.get(urlHepsiBurada);
        control(isElementExist(account, 5), " You are in HepsiBurada page", " You are not in HepsiBurada page");
        control(driver.getCurrentUrl().contains(urlHepsiBurada), "HepsiBurada page opened", "HepsiBurada did not open");
    }

    public void typeProductInSearch() {
        sendKeys(productSearch,productName);
        log.info(productName+ " typed in search field");
    }

    public void clickAraBtn() {
        click(araBtn);
        log.info("Clicked Ara Button");
    }
}