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
@DisplayName("Google Sync Open From Account (Google account chooser opens in Safari)")
class GoogleSyncOpenFromAccountTest extends AppiumBaseTest {

    @Test
    @DisplayName("Tapping 'Add all lessons' opens Google account chooser in Safari")
    // Test Case #38 — GoogleSyncOpenFromAccount (Google account chooser opens after tapping 'Add all lessons')
    void testGoogleSyncOpenFromAccount() throws InterruptedException {
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
        // Tap 'Calendar sync' row (Google Synchronize section)
        pages.calendarSyncAccountPage.getCalendarSyncSection().click();
        // Wait for Calendar sync detail screen to render
        Thread.sleep(2_000);
        // Tap 'Add all lessons' — opens Safari with Google account chooser
        pages.openGoogleSyncAccountPage.getAddAllLessonsButton().click();
        // Verify Google account chooser screen (primary anchor first — has longer timeout for Safari to load)
        pages.googleSyncOpenFromAccountPage.getNovakidSchoolDomainButton();
        pages.googleSyncOpenFromAccountPage.getGoogleSignInHeader();
        pages.googleSyncOpenFromAccountPage.getChooseAccountTitle();
        pages.googleSyncOpenFromAccountPage.getUseAnotherAccountOption();
    }
}
