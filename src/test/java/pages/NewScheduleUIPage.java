package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/**
 * New schedule UI screen for a specific teacher
 * (header "Teacher <Name>", Weekly / One-time tabs, week list with slots, "More slots" button).
 *
 * Dates and weekdays in slot rows change every day,
 * so day rows are matched by the stable substring "No available slots" instead of a specific date.
 */
public class NewScheduleUIPage extends BaseActions {

    public final By backButton = AppiumBy.accessibilityId("navigation.back_button");

    /** Header "Teacher <Name>". Not tied to a specific teacher name. */
    public final By teacherTitle = AppiumBy.iOSNsPredicateString(
            "name BEGINSWITH[cd] 'Teacher ' OR label BEGINSWITH[cd] 'Teacher '");

    /** "Time zone: Europe/Belgrade, UTC+2". TZ depends on the device, so we match by prefix. */
    public final By timeZoneLabel = AppiumBy.iOSNsPredicateString(
            "name BEGINSWITH[cd] 'Time zone' OR label BEGINSWITH[cd] 'Time zone'");

    /** Weekly tab (Inspector: name = "Weekly\nTab 1 of 2"). */
    public final By weeklyTab = AppiumBy.accessibilityId("teacher_schedule.weekly_tab");

    /** One-time tab (Inspector: name = "One-time\nTab 2 of 2"). */
    public final By oneTimeTab = AppiumBy.accessibilityId("teacher_schedule.one_time_tab");

    /**
     * Any day row with "No available slots".
     * Each row's name in Inspector is "<date>\n<day>\nNo available slots" — dates change daily,
     * so we match only the stable part.
     */
    public final By noAvailableSlotsLabel = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'No available slots' OR label CONTAINS[cd] 'No available slots'");

    public final By moreSlotsButton = AppiumBy.iOSNsPredicateString(
            "name == 'More slots' OR label == 'More slots'");

    public NewScheduleUIPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getBackButton() {
        return waitForElementPresent(backButton, "Cannot find Back button on Teacher schedule", 5, true);
    }

    public WebElement getTeacherTitle() {
        return waitForElementPresent(teacherTitle, "Cannot find 'Teacher <name>' title", 5, true);
    }

    public WebElement getTimeZoneLabel() {
        return waitForElementPresent(timeZoneLabel, "Cannot find 'Time zone' label", 5, true);
    }

    public WebElement getWeeklyTab() {
        return waitForElementPresent(weeklyTab, "Cannot find 'Weekly' tab", 5, true);
    }

    public WebElement getOneTimeTab() {
        return waitForElementPresent(oneTimeTab, "Cannot find 'One-time' tab", 5, true);
    }

    public WebElement getNoAvailableSlotsLabel() {
        return waitForElementPresent(noAvailableSlotsLabel, "Cannot find 'No available slots' row", 5, true);
    }

    public WebElement getMoreSlotsButton() {
        return waitForElementPresent(moreSlotsButton, "Cannot find 'More slots' button", 5, true);
    }
}
