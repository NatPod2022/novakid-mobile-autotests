package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Program screen (levels). iOS: locators use NSPredicate CONTAINS on name/label/value (RN/Flutter-friendly). */
public class OpenProgramPage extends BaseActions {

    public final By programTitle = AppiumBy.accessibilityId("Program");
    public final By backButton = AppiumBy.accessibilityId("Back");
    public final By level0 = AppiumBy.accessibilityId("Level 0: Pre-K");
    public final By level1 = AppiumBy.accessibilityId("Level 1: Juniors");
    /** Карточка «Level 2: Starters» — полный name «Level 2: Starters\nUnit 0: Trial Level 2» (Inspector). По чистому id не находится — берём BEGINSWITH. */
    public final By level2 = AppiumBy.iOSNsPredicateString(
            "type == 'XCUIElementTypeStaticText' AND (name BEGINSWITH 'Level 2: Starters' OR label BEGINSWITH 'Level 2: Starters')");
    public final By level3 = AppiumBy.accessibilityId("Level 3: Movers");
    public final By level4 = AppiumBy.accessibilityId("Level 4: Flyers");
    public final By level5 = AppiumBy.accessibilityId("Level 5: Time2Talk");
    public final By level6 = AppiumBy.accessibilityId("Level 6: Virtual Explorer");

    public OpenProgramPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getProgramTitle() {
        return waitForElementPresent(programTitle, "Cannot find Program title", 10, true);
    }

    public WebElement getBackButton() {
        return waitForElementPresent(backButton, "Cannot find Back button", 5, true);
    }

    public WebElement getLevel0() {
        return waitForElementPresent(level0, "Cannot find Level 0: Pre-K", 5, true);
    }

    public WebElement getLevel1() {
        return waitForElementPresent(level1, "Cannot find Level 1: Juniors", 5, true);
    }

    public WebElement getLevel2() {
        return waitForElementPresent(level2, "Cannot find Level 2: Starters", 5, true);
    }

    public WebElement getLevel3() {
        return waitForElementPresent(level3, "Cannot find Level 3: Movers", 5, true);
    }

    public WebElement getLevel4() {
        return waitForElementPresent(level4, "Cannot find Level 4: Flyers", 5, true);
    }

    public WebElement getLevel5() {
        return waitForElementPresent(level5, "Cannot find Level 5: Time2Talk", 5, true);
    }

    public WebElement getLevel6() {
        return waitForElementPresent(level6, "Cannot find Level 6: Virtual Explorer", 5, true);
    }
}
