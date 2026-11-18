package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import configuration.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@Tag("china")
@DisplayName("CH Delete account cancel")
class CH_DeleteAccountCancelTest extends AppiumBaseTest {

    @Test
    @DisplayName("delete account sheet opens and 'Cancel' keeps the account")
    // Test Case #53 — CH_DeleteAccountCancel (based on Test Case #22); CHINA app build only (NPA-9443).
    // In the global app "Delete account" opens Intercom (Test Case #51). "Delete forever" is never clicked.
    void testDeleteAccountCancel() {
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
        TestUsers.TestUser user = TestUsers.afterCancelTrial();
        pages.loginStepByEmail.getLogInInputField().click();
        pages.loginStepByEmail.getLogInInputField().sendKeys(user.email());
        pages.loginWithPasswordEmail.getPasswordInputField().click();
        pages.loginWithPasswordEmail.getPasswordInputField().sendKeys(user.password());
        // Click "Sign In"
        pages.loginWithPasswordPhone.getSignInPhoneButton().click();
        // Open right menu
        pages.preTrialDashboard.getLogoParent().click();
        // Go to Account Page
        pages.rightMenuListPage.getAccountIcon().click();
        // Go to Personal Information
        pages.accountPage.getPersonalInfo().click();
        // Click on "Delete account"
        pages.personalInformationPage.getDeleteAccountButton().click();
        // Check delete account sheet
        pages.removeAccountSheetPage.getTitle();
        pages.removeAccountSheetPage.getDeleteForeverButton();
        pages.removeAccountSheetPage.getCancelButton();
        // Click "Cancel"
        pages.removeAccountSheetPage.getCancelButton().click();
        // Check: sheet is closed, Personal information page is shown
        pages.removeAccountSheetPage.checkSheetIsClosed();
        pages.personalInformationPage.getPersonalInfoTitle();
        pages.personalInformationPage.getDeleteAccountButton();
    }
}
