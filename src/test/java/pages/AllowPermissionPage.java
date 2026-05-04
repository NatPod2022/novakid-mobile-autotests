package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import interactions.BaseActions;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

/** Permission dialog. iOS: Allow/Don't Allow (system alert); Android: permission_allow_button. */
public class AllowPermissionPage extends BaseActions {

    /** Primary: accessibility id (name/label in XCUITest). */
    public final By allowButton = AppiumBy.accessibilityId("Allow");
    /** Fallback: by label (predicate). */
    public final By allowButtonByLabel = AppiumBy.iOSNsPredicateString("label == 'Allow'");
    /** Fallback: by name (XCUITest). */
    public final By allowButtonByName = AppiumBy.iOSNsPredicateString("name == 'Allow'");
    /** Fallback: second button in alert (Allow is often the 2nd). */
    public final By allowButtonSecond = AppiumBy.iOSClassChain("**/XCUIElementTypeAlert/**/XCUIElementTypeButton[2]");
    public final By permissionMessage = AppiumBy.accessibilityId("permission_message");
    public final By denyButton = AppiumBy.accessibilityId("Don't Allow");

    private static final int WAIT_FOR_DIALOG_SEC = 5;

    public AllowPermissionPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getPermissionMessage() {
        return waitForElementPresent(permissionMessage, "Cannot find permission message", 5, true);
    }

    public WebElement getAllowButton() {
        return waitForElementPresent(allowButton, "Cannot find Allow button", 5, true);
    }

    public WebElement getDenyButton() {
        return waitForElementPresent(denyButton, "Cannot find Deny button", 5, true);
    }

    /**
     * Clicks "Allow" if the permission dialog is visible.
     * Tries: 1) Alert.accept(), 2) locators + click(), 3) locators + tap by coordinates.
     */
    public void clickAllowIfVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_DIALOG_SEC));

        // 1) iOS native alert — accept() often works
        try {
            wait.until(d -> {
                try {
                    return d.switchTo().alert() != null;
                } catch (Exception e) {
                    return false;
                }
            });
            driver.switchTo().alert().accept();
            return;
        } catch (Exception ignored) {
            // not an alert or not yet
        }

        // 2) Find button with various locators and tap
        By[] locators = {allowButton, allowButtonByLabel, allowButtonByName, allowButtonSecond};
        for (By locator : locators) {
            try {
                WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                if (btn != null && btn.isDisplayed()) {
                    btn.click();
                    return;
                }
            } catch (Exception ignored) {
                // try next
            }
        }

        // 3) Any found Allow — tap center (sometimes click() fails on iOS)
        List<WebElement> elements = driver.findElements(allowButton);
        if (elements.isEmpty()) {
            elements = driver.findElements(allowButtonByLabel);
        }
        if (elements.isEmpty()) {
            elements = driver.findElements(allowButtonByName);
        }
        if (!elements.isEmpty()) {
            WebElement btn = elements.get(0);
            tapAtCenter(btn);
        }
    }

    /** Tap element center (W3C actions) — workaround for click() on iOS system alerts. */
    private void tapAtCenter(WebElement element) {
        Point loc = element.getLocation();
        Dimension size = element.getSize();
        int x = loc.getX() + size.getWidth() / 2;
        int y = loc.getY() + size.getHeight() / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(0));
        tap.addAction(new Pause(finger, Duration.ofMillis(100)));
        tap.addAction(finger.createPointerUp(0));
        driver.perform(Collections.singletonList(tap));
    }
}
