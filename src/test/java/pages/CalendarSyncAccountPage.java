package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/**
 * "Calendar sync" section on the Account page.
 *
 * In TestPad this case is called "Google Synchronize Account" [#36]; in the iOS app
 * the section is rendered as a "Calendar sync" row between "Personal information"
 * and "Change password" on the Account page.
 */
public class CalendarSyncAccountPage extends BaseActions {

    public final By calendarSyncSection = AppiumBy.accessibilityId("account.calendar_sync_button");

    public CalendarSyncAccountPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getCalendarSyncSection() {
        return waitForElementPresent(
                calendarSyncSection,
                "Cannot find 'Calendar sync' section on Account page",
                5,
                true);
    }
}
