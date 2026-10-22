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
@DisplayName("Google Synchronize Account (Calendar sync on Account page)")
class CalendarSyncAccountTest extends AppiumBaseTest {

    @Test
    @DisplayName("'Calendar sync' section is present on Account page")
    // Test Case #36 — Google Synchronize Account (rendered as 'Calendar sync' in the app)
    void testCalendarSyncSectionOnAccountPage() {
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
        // Open right menu via parent logo
        pages.preTrialDashboard.getLogoParent().click();
        // Go to Account Page
        pages.rightMenuListPage.getAccountIcon().click();
        // Check that 'Calendar sync' section is present on Account page
        pages.calendarSyncAccountPage.getCalendarSyncSection();
    }
}
