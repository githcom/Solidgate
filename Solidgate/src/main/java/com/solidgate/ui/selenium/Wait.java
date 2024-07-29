package com.solidgate.ui.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {

    private static final ThreadLocal<WebDriverWait> webDriverWait = new ThreadLocal<>();
    private final WebDriver driver;

    public Wait(WebDriver driver, Duration timeout) {
        webDriverWait.set(new WebDriverWait(driver, timeout));
        this.driver = driver;
    }

    public void forElementToBeClickable(WebElement element) {
        webDriverWait
                .get()
                .ignoring(WebDriverException.class, StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
        highlightElement(element);
    }

    public void highlightElement(WebElement element) {
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 3; i++) {
            js.executeScript("arguments[0].style.backgroundColor = '" + "red" + "'", element);
            js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
        }
    }
}