package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import configuration.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Log out popup")
class LogOutPopupTest extends AppiumBaseTest {

    @Test
    @DisplayName("log out popup shows confirmation and buttons")
    // Test Case #21 — check visibility of elements in the Log Out popup
    void testLogOutPopupElements() {
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
        // Click on "Log Out"
        pages.rightMenuListPage.getLogOutIcon().click();
        // Assertions: check logout popup elements
        pages.logOutPopupPage.getPopupText();
        pages.logOutPopupPage.getCancelButton();
        pages.logOutPopupPage.getConfirmLogoutButton();
    }
}
