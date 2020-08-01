package com.hepsiBurada.page;

import com.hepsiBurada.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Product extends AbstractPage {
    public static final By commentTab = By.id("reviewsTabTrigger");
    public static final By firstCommentYesButton = By.xpath("//div[@class='ReviewCard-module-34AJ_'][1]//button[@class='ReviewCard-module-1MoiF'][1]");
    public static final By thanksTextBy = By.xpath("//div[@class='ReviewCard-module-34AJ_'][1]//span[@class='ReviewCard-module-1ZiTv']");

    public static final String thanks = "Teşekkür Ederiz.";


    public Product(WebDriver driver) {
        this.driver = driver;
    }

    public void messagePopupControl() {
        String thanksText = findElement(thanksTextBy).getText();
        control(thanksText.contains(thanks), thanks + " is appered", thanks + " is not appeared");
    }

    public void clickYesBtn() {
        if (isElementExist(firstCommentYesButton, 3)) {
            moveToElement(firstCommentYesButton);
            click(firstCommentYesButton);
            log.info("clickYesBtn");
        }
    }

    public void clickCommentTab() throws InterruptedException {
        //Move-scroll yapılırken araya başka ürün resimleri giriyor.
        Thread.sleep(5000);
        moveToElement(commentTab);
        log.info("Moved Comment Tab");
        click(commentTab);
        log.info("Clicked Comment Tab");
    }
}