package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Login with password (email flow). iOS + Android via accessibility id. */
public class LoginWithPasswordEmailPage extends BaseActions {

    public final By passwordInputField = AppiumBy.accessibilityId("Password");
    public final By signInButton = AppiumBy.accessibilityId("login.submit_button");
    public final By loginWithAccessCodeButton = AppiumBy.accessibilityId("login.access_code_mode_button");
    public final By forgotPasswordButton = AppiumBy.accessibilityId("login.forgot_password_link");

    public LoginWithPasswordEmailPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getPasswordInputField() {
        return waitForElementPresent(passwordInputField, "Cannot find password input field", 5, true);
    }

    public WebElement getSignInButton() {
        return waitForElementPresent(signInButton, "Cannot find 'Sign in' button", 3, true);
    }

    public WebElement getLoginWithAccessCodeButton() {
        return waitForElementPresent(loginWithAccessCodeButton, "Cannot find 'Sign in with access code' button", 3, true);
    }

    public WebElement getForgotPasswordButton() {
        return waitForElementPresent(forgotPasswordButton, "Cannot find 'I forgot password' button", 3, true);
    }
}
