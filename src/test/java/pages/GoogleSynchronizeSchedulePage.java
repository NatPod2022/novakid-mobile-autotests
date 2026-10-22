package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/**
 * "Add to Google Calendar" CTA on the Schedule tab
 * (visible above the "no lessons scheduled" empty-state illustration).
 *
 * In TestPad this case is called "Google Synchronize Schedule" [#39].
 */
public class GoogleSynchronizeSchedulePage extends BaseActions {

    public final By addToGoogleCalendarButton = AppiumBy.accessibilityId("schedule.calendar_sync_button");

    public GoogleSynchronizeSchedulePage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getAddToGoogleCalendarButton() {
        return waitForElementPresent(
                addToGoogleCalendarButton,
                "Cannot find 'Add to Google Calendar' button on Schedule tab",
                5,
                true);
    }
}
