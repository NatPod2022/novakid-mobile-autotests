package tests.e2e_tests;

import base.AppiumBaseTest;
import base.BasePages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("e2e")
@DisplayName("Registration first step")
class RegistrationFirstStepTest extends AppiumBaseTest {

    @Test
    @DisplayName("registration first step shows 'How old is your child?' title")
    // Test Case #30
    void testRegistrationFirstStep() {
        BasePages pages = new BasePages();
        pages.initPages(driver);
        // Click "Allow" if permission popup appears
        pages.allowPermission.clickAllowIfVisible();
        //*Steps:
        // Click on LogIn
        pages.preLogin.getLoginButton().click();
        // Click on Register:
        pages.logInPageFirstStep.getRegisterButton().click();
        // Check RegistrationFirstStepPage elements
        pages.registrationFirstStepPage.getHowOldIsYourChildTitle();
    }
}
