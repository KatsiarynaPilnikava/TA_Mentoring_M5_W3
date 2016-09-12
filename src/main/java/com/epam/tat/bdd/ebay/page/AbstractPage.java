package com.epam.tat.bdd.ebay.page;

import com.epam.tat.bdd.framework.browser.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    private static final int HIGHLIGHT_TIME_MS = 1000;
    private static final String HIGHLIGHT_SCRIPT = "arguments[0].style.border='4px groove green'";
    private static final String DISABLE_HIGHLIGHT_SCRIPT = "arguments[0].style.border=''";
    private static final String GET_PAGE_TITLE_SCRIPT = "return document.title;";
    protected static WebDriver driver;
    private static JavascriptExecutor js;

    public AbstractPage() {
        driver = Browser.getInstance().getWebDriver();
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
        System.out.println(String.format("Navigated to \"%s\" page", getTitle()));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    protected static void highLight(WebElement webElement) {
        js.executeScript(HIGHLIGHT_SCRIPT, webElement);
        try {
            Thread.sleep(HIGHLIGHT_TIME_MS);
        } catch (InterruptedException interruptedException) {
            System.out.println(String.format("Unexpected exception:\n %s", interruptedException));
        }
        js.executeScript(DISABLE_HIGHLIGHT_SCRIPT, webElement);
    }

    protected static String getTitle() {
        return js.executeScript(GET_PAGE_TITLE_SCRIPT).toString();
    }

    protected void handleAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException ignore) {
        }
    }

    public WebElement getWebElement(By by) {
        return getDriver().findElement(by);
    }
}
