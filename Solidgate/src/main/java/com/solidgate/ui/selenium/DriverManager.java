package com.solidgate.ui.selenium;

import com.solidgate.ui.config.TestConfig;
import com.solidgate.ui.constants.PlatformType;
import com.solidgate.ui.pageobjects.BasePage;
import org.aeonbits.owner.ConfigCache;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;
import java.time.Duration;

import static java.util.Objects.isNull;

public class DriverManager {

    private final PlatformType platformType;

    private static final DriverManager INSTANCE = new DriverManager();

    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public DriverManager() {
        var config = ConfigCache.getOrCreate(TestConfig.class);
        platformType = config.platformType();
    }


    public static DriverManager getInstance() {
        return INSTANCE;
    }

    public WebDriver getDriver() {
        if (isNull(driver.get())) {
            driver.set(createDriver());
        }
        return driver.get();
    }

    private WebDriver createDriver() {
        return switch (platformType) {
            case LOCAL -> createLocalDriver();
            case REMOTE -> null;
        };
    }

    private WebDriver createLocalDriver() {
        // since Selenium 4.12 version, chromedriver path is no longer automatically found in the
        // PATH environment variable
        var service = new ChromeDriverService.Builder().usingDriverExecutable(new File("/Users/andrewkramarenko/Documents/Chromedriver/chromedriver")).build();
        var chromeDriver = new ChromeDriver(service);
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(BasePage.getTimeoutSeconds()));
        chromeDriver.manage().deleteAllCookies();
        driver.set(chromeDriver);
        return driver.get();
    }

    public void closeDriver() {
        driver.get().close();
        driver.get().quit();
        driver.remove();
    }
}