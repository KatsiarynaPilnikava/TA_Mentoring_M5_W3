package com.epam.tat.bdd.framework.browser;

import com.epam.tat.bdd.framework.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public final class Browser {

    private static final int TIMEOUT = 20;
    private static Browser instance;
    private static WebDriver driver;

    private Browser(String browserName) throws IOException {
        driver = WebDriverFactory.getWebDriver(browserName);
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
    }

    public static Browser browser(String browserName) {
        if (instance == null) {
            try {
				instance = new Browser(browserName);
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        return instance;
    }

    public static Browser getInstance() {
        return instance;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void shutdown() {
        driver.close();
    }

    public WebDriver getWebDriver() {
        return driver;
    }
}
