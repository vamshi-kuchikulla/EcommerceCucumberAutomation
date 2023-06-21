package org.cst.stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.cst.base.BaseTests;
import org.cst.pom.LandingPage;
import org.cst.pom.PaymentConfirmationPage;
import org.cst.pom.ProductCartPage;
import org.cst.pom.ProductCatalogPage;

import java.io.IOException;

public class StepDefinitionImpl extends BaseTests {
    public LandingPage landingPage;
    public ProductCatalogPage productCatalogPage;
    public ProductCartPage productCartPage;
    public PaymentConfirmationPage paymentPage;

    @Given("I Landed on the ECommerce Page")
    public void I_Landed_on_the_ECommerce_Page() throws IOException {
        landingPage = launchApplication();
    }

    @Given("^Logged in with username(.+) and password (.+)$")
    public void Logged_in_username_and_password(String userName, String password) {
        productCatalogPage = landingPage.loginApplication(userName, password);
    }

    @When("^I Add product (.+) to cart$")
    public void I_Add_Product_to_Cart(String productName) {
        productCatalogPage.getProductList();
        productCartPage = productCatalogPage.addProductToCart(productName);
    }

    @And("^Checkout (.+) and submit the order$")
    public void checkout_and_Submit_Order(String productName) {
        productCartPage.goToCartPage();
        productCartPage.validateItemsListInCart(productName);
        paymentPage = productCartPage.goToCheckOut();
    }

    @Then("{string} message displayed on confirmationPage")
    public void message_displayed_on_confirmation(String string){
        paymentPage.validateAddress("india");
        paymentPage.confirmOrder(string);
        System.out.println("End to End Automation Done!!!!!!!");
        tearDown();
    }
}
