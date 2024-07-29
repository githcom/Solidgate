package com.solidgate.ui.selenium.pagefactory;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.ui.FluentWait;

import java.lang.reflect.Field;
import java.time.Duration;
import java.util.function.Supplier;

public class AjaxSingleElementLocator extends AjaxElementLocator {

    public AjaxSingleElementLocator(SearchContext searchContext, Field field, int timeOutInSeconds) {
        super(searchContext, field, timeOutInSeconds);
    }

    @Override
    public WebElement findElement() {
        FluentWait<Supplier<WebElement>> wait = new FluentWait<>(super::findElement);
        return wait.withTimeout(Duration.ofSeconds(timeOutInSeconds))
                .ignoring(StaleElementReferenceException.class)
                .until(Supplier::get);
    }
}