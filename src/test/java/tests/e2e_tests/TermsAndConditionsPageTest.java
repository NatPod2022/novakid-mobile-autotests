package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Terms and conditions page")
class TermsAndConditionsPageTest extends AppiumBaseTest {

    @Test
    @DisplayName("terms and conditions page shows General Terms and Conditions title")
    // Test Case #26 — check visibility of elements on Terms and Conditions screen
    void testTermsAndConditionsPageElements() {
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
        // Go to Terms and Conditions page
        pages.accountPage.getTermsAndConditions().click();
        // Check all elements on Terms and Conditions page
        pages.termsAndConditionsPage.getGeneralTermsTitle();
    }
}
