package com.solidgate.ui.selenium;

import com.solidgate.ui.pageobjects.PaymentPage;
import org.openqa.selenium.WebDriver;

import java.util.Optional;

public class PageObjectManager {

    private final WebDriver driver;
    private PaymentPage paymentPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public PaymentPage getPaymentPage() {
        return Optional.ofNullable(paymentPage).orElse(new PaymentPage(driver));
    }
}