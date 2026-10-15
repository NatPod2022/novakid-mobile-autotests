package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import configuration.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Library page")
class LibraryPageTest extends AppiumBaseTest {

    @Test
    @DisplayName("library page shows back button and beginners section")
    // Test Case #18 — verify LibraryPage screen elements
    void testLibraryPageElements() {
        BasePages pages = new BasePages();
        pages.initPages(driver);
        // Tap "Allow" if the button is shown
        pages.allowPermission.clickAllowIfVisible();
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
        // Navigate to LibraryPage
        pages.rightMenuListPage.getLibrarySection().click();
        // Assert screen elements
        pages.libraryPage.getBackButton();
        pages.libraryPage.getBeginnersGroupsButton();
    }
}
