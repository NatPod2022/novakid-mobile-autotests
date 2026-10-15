package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import configuration.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Pre-trial dashboard after cancel trial")
class PreTrialDashboardAfterCancelTrialTest extends AppiumBaseTest {

    @Test
    @DisplayName("dashboard shows logo, tabs and book button")
    // Test Case #8
    void testPreTrialDashboardAfterCancelTrialFlow() {
        // Initialize all page objects via BasePages
        BasePages pages = new BasePages();
        pages.initPages(driver);
        // Tap "Allow" if the button is shown
        pages.allowPermission.clickAllowIfVisible();
        // Steps:
        // Click on LogIn
        pages.preLogin.getLoginButton().click();
        // Click on LogInEmailPhoneButton
        pages.logInPageFirstStep.getLogInEmailPhoneButton().click();
        // Click on LoginWithPasswordButton
        pages.loginStepByPhone.getLoginWithPasswordPhoneButton().click();
        // Insert Email and Password
        TestUsers.TestUser user = TestUsers.afterCancelTrial();
        pages.loginStepByEmail.getLogInInputField().click();
        pages.loginStepByEmail.getLogInInputField().sendKeys(user.email());
        pages.loginWithPasswordEmail.getPasswordInputField().click();
        pages.loginWithPasswordEmail.getPasswordInputField().sendKeys(user.password());
        // Click on Sign in
        pages.loginWithPasswordPhone.getSignInPhoneButton().click();
        // Check:
        pages.preTrialDashboard.getLogoParent();
        pages.preTrialDashboard.getLabelNovakid();
        pages.preTrialDashboard.getTitle();
        pages.preTrialDashboard.getBookButton();
        pages.preTrialDashboard.getDashboardTab();
        pages.preTrialDashboard.getTextWeAreSorry();
        pages.preTrialDashboard.getSupportTab();
        pages.preTrialDashboard.getAchievementTab();
        pages.preTrialDashboard.getKaTab();
        pages.preTrialDashboard.getScheduleTab();
    }
}
