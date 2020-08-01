package com.hepsiBurada;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AbstractPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final int DEFAULT_WAIT = 60;
    protected Logger log = Logger.getLogger(this.getClass().getName());


    protected WebElement findElement(By by) {

        return driver.findElement(by);
    }

    protected List<WebElement> findElements(By by) {

        return driver.findElements(by);
    }

    protected void click(By by) {

        findElement(by).click();
    }

    protected String getTextOfElement(By by, int... index) {
        String text;
        try {
            if (index.length == 0)
                text = findElement(by).getText();
            else
                text = findElements(by).get(index[0]).getText();
        } catch (Exception e) {
            log.info("Error while getting text of element : " + e);
            throw new RuntimeException(e);
        }
        return text;
    }

    protected void sendKeys(By by, String text) {
        WebElement element;
        try {
            element = findElement(by);
            if (element.isEnabled()) {
                element.sendKeys(text);
            }
        } catch (Exception e) {
            log.info("Error while filling field : " + e);
            throw new RuntimeException(e);
        }
    }

    protected void control(boolean condition, String onTrue, String onFalse) {
        Assert.assertTrue(condition, onFalse);
        log.info(onTrue);
    }

    protected boolean isElementExist(By by) {

        return isElementExist(by, AbstractPage.DEFAULT_WAIT);
    }

    protected boolean isElementExist(By by, int timeSeconds) {
        driver.manage().timeouts().implicitlyWait(timeSeconds, TimeUnit.SECONDS);
        boolean isExist = driver.findElements(by).size() > 0;
        driver.manage().timeouts().implicitlyWait(AbstractPage.DEFAULT_WAIT, TimeUnit.SECONDS);
        return isExist;
    }

    protected void moveToElement(By by) {
        Actions action = new Actions(driver);
        WebElement we = findElement(by);
        action.moveToElement(we).build().perform();
    }

    protected void scrollMainWindow(int numberX, int numberY) throws InterruptedException {

        ((JavascriptExecutor) driver).executeScript("window.scrollBy('" + numberX + "','" + numberY + "')", "");

    }

}