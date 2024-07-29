package com.solidgate.ui.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

    @FindBy(id = "ccnumber")
    private WebElement cardNumber;

    @FindBy(css = "button[data-testid='language-switcher-eng']")
    private WebElement englishVersionButton;

    @FindBy(css = "input[name='cardExpiryDate']")
    private WebElement cardExpiryDate;

    @FindBy(id = "cvv2")
    private WebElement cvv2;

    @FindBy(css = "input[name='cardHolder']")
    private WebElement cardHolder;

    @FindBy(css = "div[data-testid='terms-checkbox']")
    private WebElement termsCheckboxr;

    @FindBy(css = "button[type='submit']")
    private WebElement submit;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void switchToEnglish() {
        click(englishVersionButton);
    }

    public void setCardNumber(String value) {
        setText(value, cardNumber);
    }

    public void setCardExpiryDate(String value) {
        setText(value, cardExpiryDate);
    }

    public void setCvv2(String value) {
        setText(value, cvv2);
    }

    public void setCardHolder(String value) {
        setText(value, cardHolder);
    }

    public void verifyTermsAndConditionsChecked() {
        if (!termsCheckboxr.isEnabled()) {
            termsCheckboxr.click();
        }
    }

    public void pay() {
        click(submit);
    }
}