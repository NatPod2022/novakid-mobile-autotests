package base;

import configuration.CapabilitiesProvider;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.SessionNotCreatedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

/**
 * Base test class for iOS automation using Appium XCUITest.
 * Keeps current Maven, Java 17 and JUnit 5.
 * Retries session creation if app is still installing.
 */
public abstract class AppiumBaseTest {

    private static final Logger log = LoggerFactory.getLogger(AppiumBaseTest.class);

    /** Количество попыток создать сессию (приложение может ещё устанавливаться). */
    private static final int SESSION_RETRY_COUNT = 2;
    /** Пауза между попытками (мс). */
    private static final long SESSION_RETRY_DELAY_MS = 15_000;

    protected IOSDriver driver;

    @BeforeEach
    void setUp() throws Exception {
        URL appiumUrl = new URL(CapabilitiesProvider.getAppiumServerUrl());
        XCUITestOptions capabilities = CapabilitiesProvider.getIOSCapabilities();

        for (int attempt = 1; attempt <= SESSION_RETRY_COUNT; attempt++) {
            try {
                driver = new IOSDriver(appiumUrl, capabilities);
                log.info("iOS driver session started");
                return;
            } catch (SessionNotCreatedException e) {
                log.warn("Session creation failed (attempt {}/{}): {}. Retrying in {} sec...",
                        attempt, SESSION_RETRY_COUNT, e.getMessage(), SESSION_RETRY_DELAY_MS / 1000);
                if (attempt == SESSION_RETRY_COUNT) {
                    throw e;
                }
                Thread.sleep(SESSION_RETRY_DELAY_MS);
            }
        }
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
            log.info("iOS driver session closed");
        }
    }
}
