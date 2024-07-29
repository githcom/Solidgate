package com.solidgate.ui.config;

import com.solidgate.ui.config.converters.BrowserTypeConverter;
import com.solidgate.ui.config.converters.EnvironmentConverter;
import com.solidgate.ui.config.converters.PlatformTypeConverter;
import com.solidgate.ui.constants.Environment;
import com.solidgate.ui.constants.PlatformType;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "classpath:properties/preprod.properties"
})
public interface TestConfig extends Config {

    @Key("hostUrl")
    String hostUrl();

    @Key("onetimePageEndpoint")
    String onetimePageEndpoint();

    @Key("apiHostUrl")
    String apiHostUrl();

    @Key("platform")
    @DefaultValue("LOCAL")
    @ConverterClass(PlatformTypeConverter.class)
    PlatformType platformType();

    @Key("browser")
    @DefaultValue("CHROME")
    @ConverterClass(BrowserTypeConverter.class)
    DriverManagerType browserType();

    @Key("environment")
    @ConverterClass(EnvironmentConverter.class)
    Environment environment();
}