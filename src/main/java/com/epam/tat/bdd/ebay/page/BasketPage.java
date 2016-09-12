package com.epam.tat.bdd.ebay.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends AbstractPage {
    private final static String FINAL_PRICE_XPATH = "//div[@id=\"asyncTotal\"]";
    private final static String DELETE_BUTTONS_XPATH = "//a[@aria-describedby=\"%s_title\"]";
    @FindBy(xpath = FINAL_PRICE_XPATH)
    private WebElement finalPrice;
    public static BasketPage open() {
        return new BasketPage();
    }

    public boolean checkIfProductAdded (String id) {
        try {
            getWebElement(By.xpath(String.format("//a[@href=\"http://www.ebay.com/itm/%s\"]",id)));
            return true;
        } catch (NoSuchElementException e) {
            System.out.println(String.format("Element id%s was not found at the basket",id));
            return false;
        }
    }

    public double getTotalPrice() {
        return Double.valueOf(finalPrice.getText().substring(4).replace(",","."));
    }

    public WebElement getDeleteButton(String productId) {
        try {
            return getWebElement(By.xpath(String.format(DELETE_BUTTONS_XPATH,productId)));
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
