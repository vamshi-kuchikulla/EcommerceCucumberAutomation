package org.cst.pom;

import org.cst.baseutil.AbstractUtilComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PaymentConfirmationPage extends AbstractUtilComponents {
    WebDriver driver;

    public PaymentConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Select Country']")
    WebElement selectCountry;

    @FindBy(css = ".ta-item:nth-of-type(2)")
    WebElement dropDownItem;

    @FindBy(xpath = "//a[@class='btnn action__submit ng-star-inserted']")
    WebElement submit;

    @FindBy(css = ".hero-primary")
    WebElement conformationText;

    By result = By.cssSelector(".ta-results");

    public void validateAddress(String country) {
        Actions actions = new Actions(driver);
        actions.sendKeys(selectCountry, country).build().perform();
        waitForElementVisibility(result);
        dropDownItem.click();
        submit.click();
    }

    public void confirmOrder(String message) {
        String confirmation = conformationText.getText();
        Assert.assertTrue(confirmation.equalsIgnoreCase(message));
    }
}
