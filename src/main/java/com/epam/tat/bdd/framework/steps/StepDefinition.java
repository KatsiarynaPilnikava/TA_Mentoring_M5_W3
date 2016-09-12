package com.epam.tat.bdd.framework.steps;

import com.epam.tat.bdd.ebay.entity.Basket;
import com.epam.tat.bdd.ebay.entity.Product;
import com.epam.tat.bdd.ebay.page.BasketPage;
import com.epam.tat.bdd.ebay.page.ProductPage;
import com.epam.tat.bdd.framework.browser.Browser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import static com.epam.tat.bdd.framework.browser.Browser.browser;

public class StepDefinition  {
    private Basket basket = new Basket();
    @Given("'(.+)' browser is created successfully and '(.+)' is open")
    public void browserIsCreatedSuccessfully(String browserName, String url) {
        browser(browserName).open(url);
    }

  
    @Given("add '(.+)' product to card")
    public void addToCard (String productId) {
        Browser.getInstance().open(String.format("http://www.ebay.com/itm/%s",productId));
        double price = ProductPage.open().getPrice();
        String productName = ProductPage.open().getProductName();
        basket.addProduct(new Product(productName, price, productId));
        ProductPage.open().clickAddToBasketButton();
    }

    @Given("basket buff is empty")
    public void clearBasketBuff(){
        this.basket=new Basket();
    }
    @When("product is added successfully")
    public void checkIfProductAddedSuccessfully() {
        boolean elementsExist = true;
        for (Product product:basket.getProductList()) {
            if(!BasketPage.open().checkIfProductAdded(product.getId())) {
                elementsExist = false;
                break;
            }
        }
        Assert.assertTrue(elementsExist, "Element was not found");
    }

    @Then("check that price was calculated successfully")
    public void checkPriceCalculationAtBasket() {
        Assert.assertEquals(BasketPage.open().getTotalPrice(), basket.getTotalPrice(), "Total price at the baskets doesn't match");
    }

    @Then("close browser")
    public void closeBrowser() {
        Browser.getInstance().shutdown();
    }

    @Then("basket is cleared")
    public void clearBasket() {
        for (Product product:basket.getProductList()) {
            BasketPage.open().getDeleteButton(product.getId()).click();
        }
    }

    @Then("'(.+)' product is deleted")
    public void deleteProduct(String id) {
        BasketPage.open().getDeleteButton(id).click();
    }

    }
