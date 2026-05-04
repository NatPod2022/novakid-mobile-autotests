package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Login step by email")
class LoginStepByEmailTest extends AppiumBaseTest {

    @Test
    @DisplayName("login step by email shows tabs and input")
    // Test Case #4
    void testLogInStepByEmail() {
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
        // Check LoginStepByEmailPage elements:
        pages.loginStepByEmail.getEmailTab();
        pages.loginStepByEmail.getPhoneTab();
        pages.loginStepByEmail.getLogInInputField();
        pages.loginStepByEmail.getContinueButton();
        pages.loginStepByEmail.getLoginWithPasswordButton();
        pages.loginStepByEmail.getBackButtonSecond();
    }
}
