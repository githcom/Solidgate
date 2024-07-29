package com.solidgate.ui.config.converters;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class BrowserTypeConverter implements Converter<Enum<DriverManagerType>> {

    @Override
    public Enum<DriverManagerType> convert(Method method, String input) {
        return DriverManagerType.valueOf(input.toUpperCase());
    }
}
