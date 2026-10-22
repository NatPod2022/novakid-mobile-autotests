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
@DisplayName("Open Google Sync Account (Calendar sync detail screen)")
class OpenGoogleSyncAccountTest extends AppiumBaseTest {

    @Test
    @DisplayName("'Calendar sync' detail screen opens with title, descriptions and 'Add all lessons' button")
    // Test Case #37 — OpenGoogleSyncAccount (opens Calendar sync detail from Account page)
    void testOpenGoogleSyncAccountFromAccount() throws InterruptedException {
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
        // Go to Account page
        pages.rightMenuListPage.getAccountIcon().click();
        // Tap 'Calendar sync' row on Account page (this is the 'Google Synchronize' section)
        pages.calendarSyncAccountPage.getCalendarSyncSection().click();
        // Wait for the Calendar sync detail screen to render
        Thread.sleep(2_000);
        // Check all elements on Calendar sync detail screen
        pages.openGoogleSyncAccountPage.getBackButton();
        pages.openGoogleSyncAccountPage.getCalendarSyncTitle();
        pages.openGoogleSyncAccountPage.getAddChildLessonsDescription();
        pages.openGoogleSyncAccountPage.getUpdatedAutomaticallyDescription();
        pages.openGoogleSyncAccountPage.getAddAllLessonsButton();
    }
}
