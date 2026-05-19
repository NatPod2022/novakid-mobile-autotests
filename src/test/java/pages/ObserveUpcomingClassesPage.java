package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/**
 * Schedule tab — Upcoming view for a user with booked lessons.
 *
 * Verifies the upcoming classes list (tabs, time zone, "N lessons booked" header,
 * the recurring Sunday lesson tile and the bottom "Book lessons" CTA).
 *
 * The lesson tile name in Inspector contains the day of the week and the date
 * (e.g. "Sun\n24\n18:00 - 18:25\nIndividual lesson • Nat TEST and Vika"),
 * but those change weekly. To stay date-independent the locator matches only the STABLE parts:
 * the time slot, the teacher and the student.
 *
 * In TestPad this case is called "ObserveUpcomingClasses" [#43].
 */
public class ObserveUpcomingClassesPage extends BaseActions {

    /** "All students" filter dropdown above the tabs (XCUIElementTypeOther with value="All students"). */
    public final By allStudentsFilter = AppiumBy.iOSNsPredicateString(
            "value == 'All students' OR name == 'All students' OR label == 'All students'");

    /** "Upcoming" tab (Inspector: name = "Upcoming\nTab 1 of 2"). */
    public final By upcomingTab = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Upcoming' AND name CONTAINS[cd] '1 of 2'");

    /** "Completed" tab (Inspector: name = "Completed\nTab 2 of 2"). */
    public final By completedTab = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Completed' AND name CONTAINS[cd] '2 of 2'");

    /** Time zone label, e.g. "Time zone: Europe/Belgrade, UTC+2". TZ depends on the device. */
    public final By timeZoneLabel = AppiumBy.iOSNsPredicateString(
            "name BEGINSWITH[cd] 'Time zone' OR label BEGINSWITH[cd] 'Time zone'");

    /** Any month section header like "May 2 lessons booked", "June 5 lessons booked". */
    public final By lessonsBookedHeader = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'lessons booked' OR label CONTAINS[cd] 'lessons booked'");

    /**
     * Recurring weekly lesson tile: every Sunday 18:00–18:25, teacher "Nat TEST", student "Vika".
     * Date and day of week change every week, so we ignore them and match only the stable parts
     * (time slot + teacher + student). Selector will find the next upcoming Sunday lesson
     * no matter the actual calendar date.
     */
    public final By individualLessonNatTestVika = AppiumBy.iOSNsPredicateString(
            "name CONTAINS '18:00 - 18:25' AND name CONTAINS 'Nat TEST' AND name CONTAINS 'Vika'");

    public final By bookLessonsButton = AppiumBy.iOSNsPredicateString(
            "name == 'Book lessons' OR label == 'Book lessons'");

    public ObserveUpcomingClassesPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getAllStudentsFilter() {
        return waitForElementPresent(allStudentsFilter, "Cannot find 'All students' filter", 5, true);
    }

    public WebElement getUpcomingTab() {
        return waitForElementPresent(upcomingTab, "Cannot find 'Upcoming' tab", 5, true);
    }

    public WebElement getCompletedTab() {
        return waitForElementPresent(completedTab, "Cannot find 'Completed' tab", 5, true);
    }

    public WebElement getTimeZoneLabel() {
        return waitForElementPresent(timeZoneLabel, "Cannot find 'Time zone' label", 5, true);
    }

    public WebElement getLessonsBookedHeader() {
        return waitForElementPresent(lessonsBookedHeader, "Cannot find 'N lessons booked' month header", 5, true);
    }

    /** Main check — the recurring weekly lesson tile must be present. */
    public WebElement getIndividualLessonNatTestVika() {
        return waitForElementPresent(individualLessonNatTestVika,
                "Cannot find recurring 18:00 lesson tile with 'Nat TEST' and 'Vika'", 5, true);
    }

    public WebElement getBookLessonsButton() {
        return waitForElementPresent(bookLessonsButton, "Cannot find 'Book lessons' button", 5, true);
    }
}
