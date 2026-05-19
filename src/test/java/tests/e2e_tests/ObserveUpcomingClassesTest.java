package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import configuration.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Observe Upcoming Classes (Schedule tab Upcoming view)")
class ObserveUpcomingClassesTest extends AppiumBaseTest {

    @Test
    @DisplayName("Schedule tab shows recurring 18:00 lesson 'Nat TEST + Vika' in Upcoming list")
    // Test Case #43 — ObserveUpcomingClasses (based on Test Case #8); uses schedule user with booked lessons
    void testUpcomingClassesShownOnScheduleTab() {
        BasePages pages = new BasePages();
        pages.initPages(driver);
        // Tap "Allow"
        pages.allowPermission.clickAllowIfVisible();
        // Click on Login
        pages.preLogin.getLoginButton().click();
        // Click on LogInEmailPhoneButton
        pages.logInPageFirstStep.getLogInEmailPhoneButton().click();
        // Click on LoginWithPasswordButton
        pages.loginStepByPhone.getLoginWithPasswordPhoneButton().click();
        // Insert email and password — user with booked lessons (has populated schedule)
        TestUsers.TestUser user = TestUsers.schedule();
        pages.loginStepByEmail.getLogInInputField().click();
        pages.loginStepByEmail.getLogInInputField().sendKeys(user.email());
        pages.loginWithPasswordEmail.getPasswordInputField().click();
        pages.loginWithPasswordEmail.getPasswordInputField().sendKeys(user.password());
        // Click on Sign in
        pages.loginWithPasswordPhone.getSignInPhoneButton().click();
        // Click on Schedule tab
        pages.preTrialDashboard.getScheduleTab().click();
        // Verify Upcoming view elements
        pages.observeUpcomingClassesPage.getAllStudentsFilter();
        pages.observeUpcomingClassesPage.getUpcomingTab();
        pages.observeUpcomingClassesPage.getCompletedTab();
        pages.observeUpcomingClassesPage.getTimeZoneLabel();
        pages.observeUpcomingClassesPage.getLessonsBookedHeader();
        // Main check — recurring Sunday 18:00 lesson tile (date-independent)
        pages.observeUpcomingClassesPage.getIndividualLessonNatTestVika();
        pages.observeUpcomingClassesPage.getBookLessonsButton();
    }
}
