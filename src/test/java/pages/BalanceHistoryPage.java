package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Balance history screen. iOS + Android via accessibility id. */
public class BalanceHistoryPage extends BaseActions {

    public final By backButton = AppiumBy.accessibilityId("Back");
    public final By balanceHistoryTitle = AppiumBy.accessibilityId("Balance history");
    /** Trial lesson row: screen shows "1 lesson: Trial lesson". */
    //public final By trialLessonEntry = AppiumBy.accessibilityId("Trial lesson");
    public final By trialLessonEntry =
            AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeImage' AND name CONTAINS 'Trial lesson'");

    public BalanceHistoryPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getBackButton() {
        return waitForElementPresent(backButton, "Cannot find Back button", 5, true);
    }

    public WebElement getBalanceHistoryTitle() {
        return waitForElementPresent(balanceHistoryTitle, "Cannot find Balance History title", 5, true);
    }

    public WebElement getTrialLessonEntry() {
        return waitForElementPresent(trialLessonEntry, "Cannot find Trial Lesson entry", 5, true);
    }
}
