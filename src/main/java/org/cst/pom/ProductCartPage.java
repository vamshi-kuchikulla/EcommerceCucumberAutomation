package org.cst.pom;

import org.cst.baseutil.AbstractUtilComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ProductCartPage extends AbstractUtilComponents {
    WebDriver driver;

    public ProductCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[routerlink*='cart']")
    WebElement cart;

    @FindBy(css = ".totalRow button")
    WebElement checkout;


    @FindBy(css = ".cartSection h3")
    List<WebElement> itemList;

    //Keep this in uitll class
    public void goToCartPage() {
        cart.click();
    }

    public void validateItemsListInCart(String productName) {
        Boolean status = itemList.stream().anyMatch(item -> item.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(status);
    }

    public PaymentConfirmationPage goToCheckOut() {
        checkout.click();
        return new PaymentConfirmationPage(driver);
    }

}