package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import configuration.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Account page")
class AccountPageTest extends AppiumBaseTest {

    @Test
    @DisplayName("account page shows all elements")
    // Test Case #15
    void testAccountPageElements() {
        BasePages pages = new BasePages();
        pages.initPages(driver);
        // Tap "Allow"
        pages.allowPermission.clickAllowIfVisible();
        // Steps:
        // Click on Login
        pages.preLogin.getLoginButton().click();
        // Click on LogInEmailPhoneButton
        pages.logInPageFirstStep.getLogInEmailPhoneButton().click();
        // Click on LoginWithPasswordButton
        pages.loginStepByPhone.getLoginWithPasswordPhoneButton().click();
        // Insert email and password
        TestUsers.TestUser user = TestUsers.afterCancelTrial();
        pages.loginStepByEmail.getLogInInputField().click();
        pages.loginStepByEmail.getLogInInputField().sendKeys(user.email());
        pages.loginWithPasswordEmail.getPasswordInputField().click();
        pages.loginWithPasswordEmail.getPasswordInputField().sendKeys(user.password());
        // Click on Sign in
        pages.loginWithPasswordPhone.getSignInPhoneButton().click();
        // Open right menu
        pages.preTrialDashboard.getLogoParent().click();
        // Go to Account Page
        pages.rightMenuListPage.getAccountIcon().click();
        // Check all elements on AccountPage
        //pages.accountPage.getUserHeader();
        pages.accountPage.getAccountTitle();
        pages.accountPage.getPersonalInfo();
        pages.accountPage.getChangePassword();
        pages.accountPage.getBalanceHistory();
        pages.accountPage.getPrivacyPolicy();
        pages.accountPage.getTermsAndConditions();
    }
}
