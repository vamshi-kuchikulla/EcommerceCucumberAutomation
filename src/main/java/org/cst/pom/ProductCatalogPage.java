package org.cst.pom;

import org.cst.baseutil.AbstractUtilComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogPage extends AbstractUtilComponents {

    WebDriver driver;

    public ProductCatalogPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css = ".ng-animation")
    WebElement spinner;

    By productBy = By.cssSelector(".mb-3");
    By productByName = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");

    public List<WebElement> getProductList() {
        waitForElementVisibility(productBy);
        return products;
    }

    public WebElement getProductByName(String productName) {
        WebElement prod = getProductList().stream()
                .filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
                .orElse(null);
        return prod;
    }

    public ProductCartPage addProductToCart(String productName) {
        WebElement prod = getProductByName(productName);
        prod.findElement(productByName).click();
        waitForElementVisibility(toastMessage);
        waitForElementInvisibility(spinner);
        return new ProductCartPage(driver);
    }

}
