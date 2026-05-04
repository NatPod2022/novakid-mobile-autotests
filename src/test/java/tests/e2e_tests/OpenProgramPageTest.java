package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Program page")
class OpenProgramPageTest extends AppiumBaseTest {

    @Test
    @DisplayName("program page shows title and levels")
    // Test Case #11
    void testOpenProgramPageElements() {
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
        // Click on Achievement tab
        pages.preTrialDashboard.getAchievementTab().click();
        // Checks:
        pages.openAchievementTabPage.getLevelCard().click();
        // Check elements:
        pages.openProgramPage.getProgramTitle();
        pages.openProgramPage.getBackButton();
        pages.openProgramPage.getLevel0();
        pages.openProgramPage.getLevel1();
        pages.openProgramPage.getLevel2();
        // Scroll down
        pages.openProgramPage.scrollDown();
        pages.openProgramPage.getLevel3();
        pages.openProgramPage.getLevel4();
        pages.openProgramPage.getLevel5();
        pages.openProgramPage.getLevel6();
    }
}
