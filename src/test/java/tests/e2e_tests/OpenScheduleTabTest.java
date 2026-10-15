package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import configuration.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Schedule tab")
class OpenScheduleTabTest extends AppiumBaseTest {

    @Test
    @DisplayName("schedule tab shows title and main elements")
    // Test Case #9
    void testOpenScheduleTabElements() {
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
        // Click on Schedule tab
        pages.preTrialDashboard.getScheduleTab().click();
        // Checks:
        pages.openScheduleTabPage.getTitleSchedule();
        pages.openScheduleTabPage.getTimeZoneText();
        pages.openScheduleTabPage.getNoLessonsMessage();
        pages.openScheduleTabPage.getBookLessonsButton();
    }
}
