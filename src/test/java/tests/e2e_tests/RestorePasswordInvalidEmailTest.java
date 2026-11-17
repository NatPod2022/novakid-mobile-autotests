package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Restore password with invalid email")
class RestorePasswordInvalidEmailTest extends AppiumBaseTest {

    @Test
    @DisplayName("invalid email on Reset password page shows error and keeps the page open")
    // Test Case #49 — RestorePasswordInvalidEmail (based on Test Case #48)
    void testRestorePasswordInvalidEmail() {
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
        // Enter invalid email (without "@")
        pages.restorePasswordPage.getSubmitButton();
        pages.restorePasswordPage.getEmailInputField().click();
        pages.restorePasswordPage.getEmailInputField().sendKeys("invalid.email");
        // Click on "Send request"
        pages.restorePasswordPage.getSubmitButton().click();
        // Check:
        pages.restorePasswordPage.getInvalidEmailError();
        pages.restorePasswordPage.getSubmitButton();
    }
}
