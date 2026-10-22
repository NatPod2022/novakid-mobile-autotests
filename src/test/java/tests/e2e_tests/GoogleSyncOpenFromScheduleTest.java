package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import configuration.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@Disabled("Google Calendar temporarily unavailable; re-enable when functionality is restored.")
@DisplayName("Google Sync Open From Schedule (Google account chooser opens in Safari)")
class GoogleSyncOpenFromScheduleTest extends AppiumBaseTest {

    @Test
    @DisplayName("Tapping 'Add all lessons' on Calendar sync (Schedule flow) opens Google account chooser")
    // Test Case #41 — GoogleSyncOpenFromSchedule (based on Test Case #40)
    void testGoogleSyncOpenFromSchedule() throws InterruptedException {
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
        // Tap 'Add all lessons' — opens Safari with Google account chooser
        pages.openGoogleSyncSchedulePage.getAddAllLessonsButton().click();
        // Verify Google account chooser screen (same content as #38)
        pages.googleSyncOpenFromSchedulePage.getNovakidSchoolDomainButton();
        pages.googleSyncOpenFromSchedulePage.getGoogleSignInHeader();
        pages.googleSyncOpenFromSchedulePage.getChooseAccountTitle();
        pages.googleSyncOpenFromSchedulePage.getUseAnotherAccountOption();
    }
}
