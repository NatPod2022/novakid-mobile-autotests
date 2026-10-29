package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import configuration.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Schedule booking options")
class BookingOptionsTest extends AppiumBaseTest {

    @Test
    @DisplayName("booking sheet shows individual and speaking practice Book buttons")
    // Test Case #44
    void testBookingOptions() {
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
        TestUsers.TestUser user = TestUsers.schedule();
        pages.loginStepByEmail.getLogInInputField().click();
        pages.loginStepByEmail.getLogInInputField().sendKeys(user.email());
        pages.loginWithPasswordEmail.getPasswordInputField().click();
        pages.loginWithPasswordEmail.getPasswordInputField().sendKeys(user.password());
        // Click on Sign in
        pages.loginWithPasswordPhone.getSignInPhoneButton().click();
        // Open Schedule tab
        pages.preTrialDashboard.getScheduleTab().click();
        // Open booking options
        pages.openScheduleTabPage.getBookLessonsButton().click();
        // Check all booking options
        pages.bookingOptionsPage.getIndividualBookingButton();
        pages.bookingOptionsPage.getSpeakingPracticeBookingButton();
        pages.bookingOptionsPage.checkDistinctBookingButtons();
    }
}
