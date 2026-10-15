package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import configuration.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Speaking practice page")
class SpeakingPracticePageTest extends AppiumBaseTest {

    @Test
    @DisplayName("speaking practice page shows title and age groups")
    // Test Case #19 — check visibility of elements on Speaking Practice screen
    void testSpeakingPracticePageElements() {
        BasePages pages = new BasePages();
        pages.initPages(driver);
        // Click on "Allow" button if visible
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
        // Открываем правое меню
        pages.preTrialDashboard.getLogoParent().click();
        // Click на Speaking Practice
        pages.rightMenuListPage.getSpeakingPracticeIcon().click();
        //* Check
        pages.speakingPracticePage.getTitleText();
        pages.speakingPracticePage.getSubtitleText();
        pages.speakingPracticePage.getAgeGroup4to6();
        pages.speakingPracticePage.getAgeGroup7to9();
        pages.speakingPracticePage.getAgeGroup10to13();
        pages.speakingPracticePage.getJoinNowButton();
        pages.speakingPracticePage.getVideoPreviewImage();
        pages.speakingPracticePage.getGlobeImage();
    }
}
