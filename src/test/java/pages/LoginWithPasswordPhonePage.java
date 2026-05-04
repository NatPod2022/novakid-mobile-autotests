package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Login with password (phone flow). iOS + Android via accessibility id. */
public class LoginWithPasswordPhonePage extends BaseActions {

    //public final By passwordPhoneInputField = AppiumBy.accessibilityId("Password");
    public final By signInPhoneButton = AppiumBy.accessibilityId("Sign in");
    public final By passwordPhoneInputField = AppiumBy.iOSNsPredicateString("label CONTAINS 'Password' OR name CONTAINS 'Password'");
    public final By loginWithAccessPhoneCodeButton = AppiumBy.accessibilityId("Sign in with access code");
    public final By forgotPasswordPhoneButton = AppiumBy.accessibilityId("I forgot password");

    public LoginWithPasswordPhonePage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getSignInPhoneButton() {
        return waitForElementPresent(signInPhoneButton, "Cannot find 'Sign in' button", 3, true);
    }

    public WebElement getPasswordPhoneInputField() {
        return waitForElementPresent(passwordPhoneInputField, "Cannot find password input field", 3, true);
    }

    public WebElement getLoginWithAccessPhoneCodeButton() {
        return waitForElementPresent(loginWithAccessPhoneCodeButton, "Cannot find 'Login with access code' button", 3, true);
    }

    public WebElement getForgotPasswordPhoneButton() {
        return waitForElementPresent(forgotPasswordPhoneButton, "Cannot find 'I forgot password' button", 3, true);
    }
}
