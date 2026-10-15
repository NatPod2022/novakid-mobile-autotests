package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import configuration.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Right menu list")
class RightMenuListTest extends AppiumBaseTest {

    @Test
    @DisplayName("right menu shows all elements")
    // Test Case #13
    void testRightMenuListElements() {
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
        // Open the right menu
        pages.preTrialDashboard.getLogoParent().click();
        // Check all elements on page
        pages.rightMenuListPage.getPpSection();
        pages.rightMenuListPage.getMishaIcon();
        pages.rightMenuListPage.getNewStudentIcon();
        pages.rightMenuListPage.getAccountIcon();
        pages.rightMenuListPage.getSubscriptionIcon();
        pages.rightMenuListPage.getBonusesIcon();
        pages.rightMenuListPage.getLibrarySection();
        pages.rightMenuListPage.getSpeakingPracticeIcon();
        pages.rightMenuListPage.getHelpIcon();
        pages.rightMenuListPage.getLogOutIcon();
        pages.rightMenuListPage.getGoButton();
    }
}
