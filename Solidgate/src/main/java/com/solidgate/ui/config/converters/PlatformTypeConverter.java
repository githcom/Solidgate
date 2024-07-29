package com.solidgate.ui.config.converters;

import com.solidgate.ui.constants.PlatformType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class PlatformTypeConverter implements Converter<Enum<PlatformType>> {

    @Override
    public Enum<PlatformType> convert(Method method, String input) {
        return PlatformType.valueOf(input.toUpperCase());
    }
}
