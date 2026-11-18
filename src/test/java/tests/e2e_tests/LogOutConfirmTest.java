package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import configuration.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Log out confirm")
class LogOutConfirmTest extends AppiumBaseTest {

    @Test
    @DisplayName("'Yes, log out' returns the user to the Welcome screen")
    // Test Case #52 — LogOutConfirm (based on Test Case #21)
    void testLogOutConfirm() {
        BasePages pages = new BasePages();
        pages.initPages(driver);
        // Click "Allow" if permission prompt is shown
        pages.allowPermission.clickAllowIfVisible();
        // Steps:
        // Click on "Login"
        pages.preLogin.getLoginButton().click();
        // Click on "Log In with Email/Phone"
        pages.logInPageFirstStep.getLogInEmailPhoneButton().click();
        // Click on "Login with Password"
        pages.loginStepByPhone.getLoginWithPasswordPhoneButton().click();
        // Enter email and password
        TestUsers.TestUser user = TestUsers.afterCancelTrial();
        pages.loginStepByEmail.getLogInInputField().click();
        pages.loginStepByEmail.getLogInInputField().sendKeys(user.email());
        pages.loginWithPasswordEmail.getPasswordInputField().click();
        pages.loginWithPasswordEmail.getPasswordInputField().sendKeys(user.password());
        // Click "Sign In"
        pages.loginWithPasswordPhone.getSignInPhoneButton().click();
        // Open right menu
        pages.preTrialDashboard.getLogoParent().click();
        // Click on "Log Out" (scroll the menu to the button first)
        pages.rightMenuListPage.clickLogOutIcon();
        // Wait for the Log out popup
        pages.logOutPopupPage.getPopupText();
        // Click "Yes, log out"
        pages.logOutPopupPage.getConfirmLogoutButton().click();
        // Check: Welcome screen is shown
        pages.preLogin.getLoginButton();
        pages.preLogin.getTryForFreeButton();
    }
}
