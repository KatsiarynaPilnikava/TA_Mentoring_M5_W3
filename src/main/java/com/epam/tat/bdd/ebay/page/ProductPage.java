package com.epam.tat.bdd.ebay.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage{
    private static final String ADD_TO_BASKET = "//a[@id=\"isCartBtn_btn\"]";
    private static final String BODY = "//body";
    private static final String PRICE_XPATH = "//span[@id=\"prcIsum\"]";
    private static final String NAME_XPATH = "//h1[@id=\"itemTitle\"]";
    @FindBy(xpath = BODY)
    private WebElement page;
    @FindBy(xpath = ADD_TO_BASKET)
    private WebElement addToBasketButton;
    @FindBy(xpath = PRICE_XPATH)
    private WebElement priceValue;
    @FindBy(xpath = NAME_XPATH)
    private WebElement productName;

    public ProductPage clickAddToBasketButton() {
        addToBasketButton.click();
        return this;
    }

    public static ProductPage open() {
        return new ProductPage();
    }

    public double getPrice() {
        return Double.valueOf(priceValue.getText().substring(4).replace(",","."));
    }

    public String getProductName() {
        return productName.getText();
    }
}
