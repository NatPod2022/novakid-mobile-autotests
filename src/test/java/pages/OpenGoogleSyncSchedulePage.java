package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/**
 * "Calendar sync" detail screen that opens from the Schedule tab
 * after tapping "Add to Google Calendar".
 *
 * Visually the screen looks similar to the one opened from Account ("Calendar sync" header
 * and "Add all lessons" CTA), but copy is different — here we have
 * "Add lessons to Google Calendar" title and a note about Google Calendar changes
 * not affecting the schedule.
 *
 * In TestPad this case is called "OpenGoogleSyncSchedule" [#40].
 */
public class OpenGoogleSyncSchedulePage extends BaseActions {

    /** Back arrow — no name/label in DOM, anchored on the "Calendar sync" header. */
    public final By backButton = AppiumBy.xpath(
            "//XCUIElementTypeOther[@name='Calendar sync']/preceding::XCUIElementTypeButton[1]");

    /** Header title "Calendar sync" (XCUIElementTypeOther on this screen). */
    public final By calendarSyncTitle = AppiumBy.iOSNsPredicateString(
            "name == 'Calendar sync' AND type == 'XCUIElementTypeOther'");

    /** Body title: "Add lessons to Google Calendar". */
    public final By addLessonsToGoogleCalendarTitle = AppiumBy.iOSNsPredicateString(
            "name == 'Add lessons to Google Calendar' OR label == 'Add lessons to Google Calendar'");

    /** Info text: "Changes in Google Calendar won't affect your schedule. ..." */
    public final By changesInGoogleCalendarNoticeText = AppiumBy.iOSNsPredicateString(
            "name BEGINSWITH[cd] 'Changes in Google Calendar' OR label BEGINSWITH[cd] 'Changes in Google Calendar'");

    /** Primary CTA "Add all lessons". */
    public final By addAllLessonsButton = AppiumBy.iOSNsPredicateString(
            "name == 'Add all lessons' OR label == 'Add all lessons'");

    public OpenGoogleSyncSchedulePage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getBackButton() {
        return waitForElementPresent(backButton,
                "Cannot find Back button on 'Add lessons to Google Calendar' screen", 5, true);
    }

    public WebElement getCalendarSyncTitle() {
        return waitForElementPresent(calendarSyncTitle,
                "Cannot find 'Calendar sync' header", 5, true);
    }

    public WebElement getAddLessonsToGoogleCalendarTitle() {
        return waitForElementPresent(addLessonsToGoogleCalendarTitle,
                "Cannot find 'Add lessons to Google Calendar' body title", 5, true);
    }

    public WebElement getChangesInGoogleCalendarNoticeText() {
        return waitForElementPresent(changesInGoogleCalendarNoticeText,
                "Cannot find 'Changes in Google Calendar...' notice text", 5, true);
    }

    public WebElement getAddAllLessonsButton() {
        return waitForElementPresent(addAllLessonsButton,
                "Cannot find 'Add all lessons' button", 5, true);
    }
}
