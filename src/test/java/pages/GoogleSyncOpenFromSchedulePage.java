package pages;

import io.appium.java_client.AppiumDriver;

/**
 * Google account chooser screen that opens in Safari (SFSafariViewController)
 * after tapping "Add all lessons" on the Calendar sync screen reached from the Schedule tab.
 *
 * The screen content is identical to the chooser reached from the Account flow
 * ({@link GoogleSyncOpenFromAccountPage}): same Google sign-in header, "Choose an account"
 * title, "novakidschool.com" button and "Use another account" option.
 *
 * Locators and getters are inherited as-is — the dedicated subclass keeps a 1:1 mapping
 * with the TestPad case "GoogleSyncOpenFromSchedule" [#41].
 */
public class GoogleSyncOpenFromSchedulePage extends GoogleSyncOpenFromAccountPage {

    public GoogleSyncOpenFromSchedulePage(AppiumDriver driver) {
        super(driver);
    }
}
