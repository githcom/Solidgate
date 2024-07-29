package com.solidgate.ui.pageobjects;

import com.solidgate.ui.selenium.Wait;
import com.solidgate.ui.selenium.pagefactory.AjaxSingleElementLocatorFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public abstract class BasePage {

    private static final int TIMEOUT_SECONDS = 30;
    protected final WebDriver driver;
    protected final Wait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Wait(driver, Duration.ofSeconds(getTimeoutSeconds()));
        PageFactory.initElements(new AjaxSingleElementLocatorFactory(driver, getTimeoutSeconds()), this);
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void setText(String value, WebElement element) {
        wait.forElementToBeClickable(element);
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    public void click(WebElement element) {
        wait.forElementToBeClickable(element);
        element.click();
    }

    public static int getTimeoutSeconds() {
        return TIMEOUT_SECONDS;
    }
}
