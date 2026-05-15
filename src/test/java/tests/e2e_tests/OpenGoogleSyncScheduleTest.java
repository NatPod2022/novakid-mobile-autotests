package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import configuration.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Open Google Sync Schedule (Calendar sync screen from Schedule tab)")
class OpenGoogleSyncScheduleTest extends AppiumBaseTest {

    @Test
    @DisplayName("'Add to Google Calendar' opens Calendar sync screen with 'Add all lessons' CTA")
    // Test Case #40 — OpenGoogleSyncSchedule (based on Test Case #39)
    void testOpenGoogleSyncScheduleFromScheduleTab() throws InterruptedException {
        BasePages pages = new BasePages();
        pages.initPages(driver);
        // Tap "Allow"
        pages.allowPermission.clickAllowIfVisible();
        // Click on Login
        pages.preLogin.getLoginButton().click();
        // Click on LogInEmailPhoneButton
        pages.logInPageFirstStep.getLogInEmailPhoneButton().click();
        // Click on LoginWithPasswordButton
        pages.loginStepByPhone.getLoginWithPasswordPhoneButton().click();
        // Insert email and password
        TestUsers.TestUser user = TestUsers.afterCancelTrial();
        pages.loginStepByEmail.getLogInInputField().click();
        pages.loginStepByEmail.getLogInInputField().sendKeys(user.email());
        pages.loginWithPasswordEmail.getPasswordInputField().click();
        pages.loginWithPasswordEmail.getPasswordInputField().sendKeys(user.password());
        // Click on Sign in
        pages.loginWithPasswordPhone.getSignInPhoneButton().click();
        // Click on Schedule tab
        pages.preTrialDashboard.getScheduleTab().click();
        // Click on 'Add to Google Calendar' button on Schedule tab
        pages.googleSynchronizeSchedulePage.getAddToGoogleCalendarButton().click();
        // Wait for Calendar sync detail screen to render
        Thread.sleep(2_000);
        // Check all elements on 'Add lessons to Google Calendar' screen
        pages.openGoogleSyncSchedulePage.getBackButton();
        pages.openGoogleSyncSchedulePage.getCalendarSyncTitle();
        pages.openGoogleSyncSchedulePage.getAddLessonsToGoogleCalendarTitle();
        pages.openGoogleSyncSchedulePage.getChangesInGoogleCalendarNoticeText();
        pages.openGoogleSyncSchedulePage.getAddAllLessonsButton();
    }
}
