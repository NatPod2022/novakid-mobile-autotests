package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import configuration.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Open Class Details (tap upcoming lesson → class details screen)")
class OpenClassDetailsTest extends AppiumBaseTest {

    @Test
    @DisplayName("Tapping first upcoming lesson opens class details with title, sections and action buttons")
    // Test Case #42 — OpenClassDetails (based on Test Case #43); uses schedule user with booked lessons
    void testOpenClassDetailsFromUpcomingLesson() throws InterruptedException {
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
        // Click on the first upcoming lesson tile (recurring Sunday 18:00 lesson — Nat TEST + Vika)
        pages.observeUpcomingClassesPage.getIndividualLessonNatTestVika().click();
        // Wait for Class details screen to render
        Thread.sleep(1_000);
        // Verify top section of Class details
        pages.openClassDetailsPage.getBackButton();
        pages.openClassDetailsPage.getLessonTitle();
        pages.openClassDetailsPage.getStudentTeacherLabel();
        pages.openClassDetailsPage.getWarmUpSection();
        pages.openClassDetailsPage.getMaterialsSection();
        // Scroll down to the action buttons row
        pages.openClassDetailsPage.scrollToActionButtons();
        // Verify 3 action buttons
        pages.openClassDetailsPage.getEnterLessonButton();
        pages.openClassDetailsPage.getRescheduleLessonButton();
        pages.openClassDetailsPage.getCancelTheLessonButton();
    }
}
