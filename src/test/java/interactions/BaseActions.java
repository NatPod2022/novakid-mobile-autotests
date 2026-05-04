package interactions;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

/**
 * Base actions and waits for mobile (based on ui_test BaseActions).
 * Uses Selenium 4 WebDriverWait and W3C actions for scroll.
 */
public class BaseActions {

    protected final AppiumDriver driver;
    private static final Duration DEFAULT_WAIT = Duration.ofSeconds(10);

    public BaseActions(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementPresent(By by, String errorMessage, long timeoutInSeconds, boolean throwException) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.withMessage(errorMessage + "\n");
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception e) {
            if (throwException) {
                throw new AssertionError("❌ " + errorMessage, e);
            }
            return null;
        }
    }

    public WebElement waitForElementClickable(By by, String errorMessage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }


    public WebElement elementsClick(By by, String errorMessage, long timeoutInSeconds, boolean throwException) {
        WebElement element = waitForElementPresent(by, errorMessage, timeoutInSeconds, throwException);
        if (element != null) {
            element.click();
        }
        return element;
    }

    public WebElement elementsSendKey(By by, String value, String errorMessage, long timeoutInSeconds, boolean throwException) {
        WebElement element = waitForElementPresent(by, errorMessage, timeoutInSeconds, throwException);
        if (element != null) {
            element.sendKeys(value);
        }
        return element;
    }

    /** Scroll down the screen (W3C pointer actions). */
    public void scrollDown() {
        Dimension size = driver.manage().window().getSize();
        int width = size.getWidth() / 2;
        int startY = (int) (size.getHeight() * 0.7);
        int endY = (int) (size.getHeight() * 0.3);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 1);
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), width, startY));
        scroll.addAction(finger.createPointerDown(0));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), width, endY));
        scroll.addAction(finger.createPointerUp(0));
        driver.perform(Collections.singletonList(scroll));
    }

    /** Scroll until element is found (max 5 scrolls). */
    public void scrollToElement(By by) {
        boolean isDisplayed = false;
        int maxScrolls = 5;
        int alreadyScrolled = 0;

        while (!isDisplayed && alreadyScrolled < maxScrolls) {
            try {
                WebElement element = driver.findElement(by);
                if (element.isDisplayed()) {
                    isDisplayed = true;
                    break;
                }
            } catch (Exception e) {
                scrollDown();
                alreadyScrolled++;
            }
        }

        if (!isDisplayed) {
            throw new AssertionError("❌ Element not found after scrolling: " + by);
        }
    }
}
