package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Restore password page")
class RestorePasswordPageTest extends AppiumBaseTest {

    @Test
    @DisplayName("'I forgot password' opens Reset password page with email field and submit button")
    // Test Case #47 — RestorePasswordPage (based on Test Case #6)
    void testRestorePasswordPage() {
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
        // Click on "I forgot password"
        pages.loginWithPasswordEmail.getForgotPasswordButton().click();
        // Check:
        pages.restorePasswordPage.getSubmitButton();
        pages.restorePasswordPage.getEmailInputField();
    }
}
