package com.solidgate.ui.config.converters;

import com.solidgate.ui.constants.Environment;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class EnvironmentConverter implements Converter<Enum<Environment>> {

    @Override
    public Enum<Environment> convert(Method method, String input) {
        return Environment.valueOf(input.toUpperCase());
    }
}
