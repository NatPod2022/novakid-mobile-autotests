package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Login step: email/phone tab, input, continue. iOS + Android via accessibility id. */
public class LoginStepByEmailPage extends BaseActions {

    public final By emailTab = AppiumBy.iOSNsPredicateString("name CONTAINS 'Email'");
    //public final By phoneTab = AppiumBy.accessibilityId("Phone");
    public final By phoneTab = AppiumBy.iOSNsPredicateString("name CONTAINS 'Phone'");
    public final By logInInputField = AppiumBy.className("XCUIElementTypeTextField");
    public final By continueButton = AppiumBy.accessibilityId("Continue");
    public final By loginWithPasswordButton = AppiumBy.accessibilityId("Sign in with password");
    public final By backButtonSecond = AppiumBy.accessibilityId("Back");

    public LoginStepByEmailPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getLogInInputField() {
        return waitForElementPresent(logInInputField, "Cannot find input field for login by Email", 5, true);
    }

    public WebElement getContinueButton() {
        return waitForElementPresent(continueButton, "Cannot find 'Continue' button", 5, true);
    }

    public WebElement getLoginWithPasswordButton() {
        return waitForElementPresent(loginWithPasswordButton, "Cannot find 'Sign in with password' button", 5, true);
    }

    public WebElement getEmailTab() {
        return waitForElementPresent(emailTab, "Cannot find 'Email Tab'", 5, true);
    }

    public WebElement getPhoneTab() {
        return waitForElementPresent(phoneTab, "Cannot find 'Phone Tab'", 5, true);
    }

    public WebElement getBackButtonSecond() {
        return waitForElementPresent(backButtonSecond, "Cannot find 'Back' button", 5, true);
    }
}
