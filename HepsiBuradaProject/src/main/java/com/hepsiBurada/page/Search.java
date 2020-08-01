package com.hepsiBurada.page;

import com.hepsiBurada.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Search extends AbstractPage {

    public static final By clickFirstProduct = By.xpath("//ul[@class='product-list results-container do-flex list']/li[1]//div[@class='product-detail']");

    public Search(WebDriver driver){
        this.driver=driver;
    }

    public void clickFirstProduct() {
        click(clickFirstProduct);
        log.info("Clicked First Product");
    }
}