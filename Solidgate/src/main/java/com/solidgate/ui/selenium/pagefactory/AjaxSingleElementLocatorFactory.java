package com.solidgate.ui.selenium.pagefactory;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Field;
import java.util.List;

public class AjaxSingleElementLocatorFactory extends AjaxElementLocatorFactory {

    private final SearchContext searchContext;
    private final int timeOutInSeconds;

    public AjaxSingleElementLocatorFactory(SearchContext searchContext, int timeOutInSeconds) {
        super(searchContext, timeOutInSeconds);
        this.searchContext = searchContext;
        this.timeOutInSeconds = timeOutInSeconds;
    }

    @Override
    public ElementLocator createLocator(Field field) {
        // it's necessary to use DefaultElement locator for List<WebElement>
        // because sometimes we may have no elements on the page
        // and, according to this, we need to use verification like
        // !listFields.isEmpty()
        // if non-DefaultElement locator is using - we will wait every time full timeOutInSeconds
        return field.getType().isAssignableFrom(List.class)
                ? new DefaultElementLocator(searchContext, field)
                : new AjaxSingleElementLocator(searchContext, field, timeOutInSeconds);
    }
}