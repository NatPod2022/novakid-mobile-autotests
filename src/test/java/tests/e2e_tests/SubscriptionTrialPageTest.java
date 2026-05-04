package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Subscription trial page")
class SubscriptionTrialPageTest extends AppiumBaseTest {

    @Test
    @DisplayName("subscription trial page shows package and top up")
    // Test Case #16
    void testSubscriptionTrialPageElements() {
        // Initialize all page objects via BasePages
        BasePages pages = new BasePages();
        pages.initPages(driver);
        // Tap "Allow" if the button is shown
        pages.allowPermission.clickAllowIfVisible();
        // Steps:
        // Click on Login
        pages.preLogin.getLoginButton().click();
        // Click on LogInEmailPhoneButton
        pages.logInPageFirstStep.getLogInEmailPhoneButton().click();
        // Click on LoginWithPasswordButton
        pages.loginStepByPhone.getLoginWithPasswordPhoneButton().click();
        // Insert email and password
        pages.loginStepByEmail.getLogInInputField().click();
        pages.loginStepByEmail.getLogInInputField().sendKeys("np_test@mail.nv");
        pages.loginWithPasswordEmail.getPasswordInputField().click();
        pages.loginWithPasswordEmail.getPasswordInputField().sendKeys("12345678");
        // Click on Sign in
        pages.loginWithPasswordPhone.getSignInPhoneButton().click();
        // Open the right menu
        pages.preTrialDashboard.getLogoParent().click();
        // Click Subscription
        pages.rightMenuListPage.getSubscriptionIcon().click();
        //* Assert screen elements
        pages.subscriptionTrialPage.getBackButton();
        pages.subscriptionTrialPage.getTitlePackage();
        pages.subscriptionTrialPage.getTitleStandardPackage();
        pages.subscriptionTrialPage.getTitlePremium();
        pages.subscriptionTrialPage.getPrice1st();
        pages.subscriptionTrialPage.getTextOr();
        pages.subscriptionTrialPage.getTitleStandard();
        pages.subscriptionTrialPage.getPrice2nd();
        pages.subscriptionTrialPage.getTopUpBalanceButton();
    }
}
