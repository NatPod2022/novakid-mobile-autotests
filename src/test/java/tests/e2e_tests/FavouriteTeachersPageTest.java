package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Favourite teachers page")
class FavouriteTeachersPageTest extends AppiumBaseTest {

    @Test
    @DisplayName("favourite teachers page shows after tapping heart on choose teacher")
    // Test Case #34 — check visibility of elements on Favourite Teachers screen (after heart tap)
    void testFavouriteTeachersPageElements() {
        BasePages pages = new BasePages();
        pages.initPages(driver);
        pages.allowPermission.clickAllowIfVisible();
        // Click "Login"
        pages.preLogin.getLoginButton().click();
        // Click "Log In with Email/Phone"
        pages.logInPageFirstStep.getLogInEmailPhoneButton().click();
        // Click "Login with Password"
        pages.loginStepByPhone.getLoginWithPasswordPhoneButton().click();
        // Enter email and password
        pages.loginStepByEmail.getLogInInputField().click();
        pages.loginStepByEmail.getLogInInputField().sendKeys("Auto_Test_schedule@mail.ru");
        pages.loginWithPasswordEmail.getPasswordInputField().click();
        pages.loginWithPasswordEmail.getPasswordInputField().sendKeys("12345678");
        // Click "Sign In"
        pages.loginWithPasswordPhone.getSignInPhoneButton().click();
        // Schedule tab
        pages.preTrialDashboard.getScheduleTab().click();
        // Book lessons
        pages.openScheduleTabPage.getBookLessonsButton().click();
        // Choose teacher → Heart in header → Favourite teachers list
        pages.chooseTeacherPage.getHeaderHeartButton().click();
        // Check all elements on Favourite Teachers screen
        pages.favouriteTeachersPage.getBackButton();
        pages.favouriteTeachersPage.getPageTitle();
        pages.favouriteTeachersPage.getYourFavouritesLabel();
        pages.favouriteTeachersPage.getTeacherNameNatTest();
        pages.favouriteTeachersPage.getTeacherCardHeartButton();
        pages.favouriteTeachersPage.getReadMoreButton();
        pages.favouriteTeachersPage.getBookLessonButton();
    }
}
