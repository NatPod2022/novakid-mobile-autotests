package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Password page")
class PasswordPageTest extends AppiumBaseTest {

    @Test
    @DisplayName("password page shows set password form")
    // Test Case #23 — check visibility of elements on Password screen
    void testPasswordPageElements() {
        BasePages pages = new BasePages();
        pages.initPages(driver);
        // Click "Allow" if permission prompt is shown
        pages.allowPermission.clickAllowIfVisible();
        // Steps:
        // Click "Login"
        pages.preLogin.getLoginButton().click();
        // Click "Log In with Email/Phone"
        pages.logInPageFirstStep.getLogInEmailPhoneButton().click();
        // Click "Login with Password"
        pages.loginStepByPhone.getLoginWithPasswordPhoneButton().click();
        // Enter email and password
        pages.loginStepByEmail.getLogInInputField().click();
        pages.loginStepByEmail.getLogInInputField().sendKeys("np_test@mail.nv");
        pages.loginWithPasswordEmail.getPasswordInputField().click();
        pages.loginWithPasswordEmail.getPasswordInputField().sendKeys("12345678");
        // Click "Sign In"
        pages.loginWithPasswordPhone.getSignInPhoneButton().click();
        // Open right menu
        pages.preTrialDashboard.getLogoParent().click();
        // Go to Account Page
        pages.rightMenuListPage.getAccountIcon().click();
        // Go to Personal Information
        pages.accountPage.getChangePassword().click();
        // Check all elements on Password page
        pages.passwordPage.getBackButton();
        pages.passwordPage.getSetPasswordTitle();
        pages.passwordPage.getPasswordInfoText();
        pages.passwordPage.getNewPasswordField();
        pages.passwordPage.getRepeatPasswordField();
        pages.passwordPage.getGeneratePasswordButton();
        pages.passwordPage.getProceedButton();
    }
}
