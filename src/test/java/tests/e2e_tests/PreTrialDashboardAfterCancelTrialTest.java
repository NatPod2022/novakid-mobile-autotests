package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
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
        pages.loginStepByEmail.getLogInInputField().click();
        pages.loginStepByEmail.getLogInInputField().sendKeys("np_test@mail.nv");
        pages.loginWithPasswordEmail.getPasswordInputField().click();
        pages.loginWithPasswordEmail.getPasswordInputField().sendKeys("12345678");
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
