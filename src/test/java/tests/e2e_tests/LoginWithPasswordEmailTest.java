package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Login with password (email)")
class LoginWithPasswordEmailTest extends AppiumBaseTest {

    @Test
    @DisplayName("login with password email shows password field and sign in")
    // Test Case #6
    void testLoginWithPasswordEmail() {
        // Initialize all page objects via BasePages
        BasePages pages = new BasePages();
        pages.initPages(driver);
        // Tap "Allow" if the button is shown
        pages.allowPermission.clickAllowIfVisible();
        //* Steps:
        // Click on LogIn
        pages.preLogin.getLoginButton().click();
        // Click on LogInEmailPhoneButton
        pages.logInPageFirstStep.getLogInEmailPhoneButton().click();
        // Click on LoginWithPasswordButton
        pages.loginStepByEmail.getLoginWithPasswordButton().click();
        // Check:
        pages.loginWithPasswordEmail.getPasswordInputField();
        pages.loginWithPasswordEmail.getSignInButton();
        pages.loginWithPasswordEmail.getLoginWithAccessCodeButton();
        pages.loginWithPasswordEmail.getForgotPasswordButton();
    }
}
