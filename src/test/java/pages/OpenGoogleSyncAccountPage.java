package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/**
 * "Calendar sync" detail screen (opens after tapping the "Calendar sync" row on the Account page).
 * Contains a back arrow, header title "Calendar sync", two description lines
 * and a primary "Add all lessons" button.
 *
 * In TestPad this case is called "OpenGoogleSyncAccount" [#37].
 */
public class OpenGoogleSyncAccountPage extends BaseActions {

    /** AppBar back button, identified independently of the screen title. */
    public final By backButton = AppiumBy.accessibilityId("navigation.back_button");

    /** Header title "Calendar sync" (on this screen it is an XCUIElementTypeOther). */
    public final By calendarSyncTitle = AppiumBy.iOSNsPredicateString(
            "name == 'Calendar sync' AND type == 'XCUIElementTypeOther'");

    /** First description line: "Add your child's lessons to your Google Calendar." */
    public final By addChildLessonsDescription = AppiumBy.iOSNsPredicateString(
            "name BEGINSWITH[cd] 'Add your child' OR label BEGINSWITH[cd] 'Add your child'");

    /** Second description line: "It will be updated automatically when you make any schedule changes in your Novakid account." */
    public final By updatedAutomaticallyDescription = AppiumBy.iOSNsPredicateString(
            "name BEGINSWITH[cd] 'It will be updated' OR label BEGINSWITH[cd] 'It will be updated'");

    /** Primary CTA "Add all lessons" (button with the Google Calendar icon). */
    public final By addAllLessonsButton = AppiumBy.accessibilityId("calendar_sync.connect_google_button");

    public OpenGoogleSyncAccountPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getBackButton() {
        return waitForElementPresent(backButton, "Cannot find Back button on Calendar sync screen", 5, true);
    }

    public WebElement getCalendarSyncTitle() {
        return waitForElementPresent(calendarSyncTitle, "Cannot find 'Calendar sync' title", 5, true);
    }

    public WebElement getAddChildLessonsDescription() {
        return waitForElementPresent(addChildLessonsDescription,
                "Cannot find 'Add your child's lessons...' description", 5, true);
    }

    public WebElement getUpdatedAutomaticallyDescription() {
        return waitForElementPresent(updatedAutomaticallyDescription,
                "Cannot find 'It will be updated...' description", 5, true);
    }

    public WebElement getAddAllLessonsButton() {
        return waitForElementPresent(addAllLessonsButton, "Cannot find 'Add all lessons' button", 5, true);
    }
}
