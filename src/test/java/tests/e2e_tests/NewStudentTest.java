package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("New student page")
class NewStudentTest extends AppiumBaseTest {

    @Test
    @DisplayName("new student page shows form elements")
    // Test Case #17 — verify New Student screen elements
    void testNewStudentPageElements() {
        // Initialize all page objects via BasePages
        BasePages pages = new BasePages();
        pages.initPages(driver);
        // Tap "Allow" if the button is shown
        pages.allowPermission.clickAllowIfVisible();
        // Steps:
        // Click on LogIn
        pages.preLogin.getLoginButton().click();
        // Click on LogInEmailPhoneButton
        pages.logInPageFirstStep.getLogInEmailPhoneButton().click();
        // Click on LoginWithPasswordButton
        pages.loginStepByPhone.getLoginWithPasswordPhoneButton().click();
        // Insert Email and Password
        pages.loginStepByEmail.getLogInInputField().click();
        pages.loginStepByEmail.getLogInInputField().sendKeys("np_test@mail.nv");
        pages.loginWithPasswordEmail.getPasswordInputField().click();
        pages.loginWithPasswordEmail.getPasswordInputField().sendKeys("12345678");
        // Click on Sign in
        pages.loginWithPasswordPhone.getSignInPhoneButton().click();
        // Open the right menu
        pages.preTrialDashboard.getLogoParent().click();
        // Click New student
        pages.rightMenuListPage.getNewStudentIcon().click();
        //* Assert screen elements
        pages.newStudentPage.getBackButton();
        pages.newStudentPage.getNewStudentTitle();
        pages.newStudentPage.getGirlRadioButton();
        pages.newStudentPage.getGirlLabel();
        pages.newStudentPage.getBoyRadioButton();
        pages.newStudentPage.getBoyLabel();
        pages.newStudentPage.getFirstNameInput();
        pages.newStudentPage.getDateOfBirthInput();
        pages.newStudentPage.getAddNewChildButton();
    }
}
