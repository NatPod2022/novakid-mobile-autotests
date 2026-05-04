package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Sign in first step (Google / email/phone). iOS + Android via accessibility id. */
public class LogInPageFirstStepPage extends BaseActions {

    public final By logInTitle = AppiumBy.accessibilityId("Sign in to Novakid");
    public final By logInGoogleButton = AppiumBy.accessibilityId("Sign in with Google");
    public final By logInEmailPhoneButton = AppiumBy.accessibilityId("Sign in with email/phone");
    public final By haveYouAccountTitle = AppiumBy.accessibilityId("Don't have an account");
    public final By registerButton = AppiumBy.accessibilityId("Register");

    public LogInPageFirstStepPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getLogInTitle() {
        return waitForElementPresent(logInTitle, "Cannot find 'Sign in to Novakid' title", 5, true);
    }

    public WebElement getLogInGoogleButton() {
        return waitForElementPresent(logInGoogleButton, "Cannot find 'Sign in with Google' button", 5, true);
    }

    public WebElement getLogInEmailPhoneButton() {
        return waitForElementPresent(logInEmailPhoneButton, "Cannot find 'Sign in with email/phone' button", 5, true);
    }

    public WebElement getHaveYouAccountTitle() {
        return waitForElementPresent(haveYouAccountTitle, "Cannot find 'Don't have an account yet?' title", 5, true);
    }

    public WebElement getRegisterButton() {
        return waitForElementPresent(registerButton, "Cannot find 'Register' button", 5, true);
    }
}
