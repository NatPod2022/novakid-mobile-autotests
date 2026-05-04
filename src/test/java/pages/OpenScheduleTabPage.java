package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/**
 * Schedule tab. iOS: prefer NSPredicate so name/label/value match RN/Flutter; accessibility id alone often breaks after UI changes.
 */
public class OpenScheduleTabPage extends BaseActions {

    public final By titleSchedule = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Schedule' OR label CONTAINS[cd] 'Schedule' OR value CONTAINS[cd] 'Schedule'");
    public final By upcomingTab = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Upcoming' OR label CONTAINS[cd] 'Upcoming' OR value CONTAINS[cd] 'Upcoming'");
    public final By completedTab = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Completed' OR label CONTAINS[cd] 'Completed' OR value CONTAINS[cd] 'Completed'");
    public final By timeZoneText = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Time zone' OR label CONTAINS[cd] 'Time zone' OR value CONTAINS[cd] 'Time zone'");
    public final By noLessonsMessage = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'no lessons' OR label CONTAINS[cd] 'no lessons' OR value CONTAINS[cd] 'no lessons' "
                    + "OR name CONTAINS[cd] 'Book lesson' OR label CONTAINS[cd] 'Book lesson' "
                    + "OR name CONTAINS[cd] 'child has no' OR label CONTAINS[cd] 'child has no' "
                    + "OR name CONTAINS[cd] 'lessons scheduled' OR label CONTAINS[cd] 'lessons scheduled'");
    public final By bookLessonsButton = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Book lessons' OR label CONTAINS[cd] 'Book lessons' OR name CONTAINS[cd] 'Book lesson' OR label CONTAINS[cd] 'Book lesson'");
    public final By premiumLesson = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Premium lesson' OR label CONTAINS[cd] 'Premium lesson' OR value CONTAINS[cd] 'Premium lesson' OR "
                    + "((name CONTAINS[cd] 'Premium' OR label CONTAINS[cd] 'Premium' OR value CONTAINS[cd] 'Premium') "
                    + "AND (name CONTAINS[cd] 'lesson' OR label CONTAINS[cd] 'lesson' OR value CONTAINS[cd] 'lesson'))");
    public final By standardLesson = AppiumBy.iOSNsPredicateString(
            "name CONTAINS[cd] 'Standard lesson' OR label CONTAINS[cd] 'Standard lesson' OR value CONTAINS[cd] 'Standard lesson' OR "
                    + "((name CONTAINS[cd] 'Standard' OR label CONTAINS[cd] 'Standard' OR value CONTAINS[cd] 'Standard') "
                    + "AND (name CONTAINS[cd] 'lesson' OR label CONTAINS[cd] 'lesson' OR value CONTAINS[cd] 'lesson'))");
    /**
     * Numeric lesson counters. If both resolve to the same element, split locators using Inspector (e.g. parent scope or index).
     */
    public final By premiumLessonCount = AppiumBy.iOSNsPredicateString(
            "name == '1' OR label == '1' OR value == '1'");
    public final By standardLessonCount = AppiumBy.iOSNsPredicateString(
            "name == '1' OR label == '1' OR value == '1'");

    public OpenScheduleTabPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getTitleSchedule() {
        return waitForElementPresent(titleSchedule, "Cannot find Schedule title", 10, true);
    }

    public WebElement getBookLessonsButton() {
        return waitForElementPresent(bookLessonsButton, "Cannot find 'Book lessons' button", 5, true);
    }

    public WebElement getUpcomingTab() {
        return waitForElementPresent(upcomingTab, "Cannot find Upcoming tab", 5, true);
    }

    public WebElement getCompletedTab() {
        return waitForElementPresent(completedTab, "Cannot find Completed tab", 5, true);
    }

    public WebElement getNoLessonsMessage() {
        return waitForElementPresent(noLessonsMessage, "Cannot find empty schedule message", 5, true);
    }

    public WebElement getPremiumLesson() {
        return waitForElementPresent(premiumLesson, "Cannot find Premium lesson", 5, true);
    }

    public WebElement getStandardLesson() {
        return waitForElementPresent(standardLesson, "Cannot find Standard lesson", 5, true);
    }

    public WebElement getPremiumLessonCount() {
        return waitForElementPresent(premiumLessonCount, "Cannot find Premium lesson count", 5, true);
    }

    public WebElement getStandardLessonCount() {
        return waitForElementPresent(standardLessonCount, "Cannot find Standard lesson count", 5, true);
    }

    public WebElement getTimeZoneText() {
        return waitForElementPresent(timeZoneText, "Cannot find Time zone text", 5, true);
    }
}
