package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Login step: phone number / sign in with password. iOS + Android via accessibility id. */
public class LoginStepByPhonePage extends BaseActions {

    public final By phoneIndex = AppiumBy.iOSNsPredicateString("name CONTAINS '+'");
    public final By loginWithPasswordPhoneButton = AppiumBy.accessibilityId("Sign in with password");
    public final By logInInputFieldPhone = AppiumBy.className("XCUIElementTypeTextField");

    public LoginStepByPhonePage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getLoginWithPasswordPhoneButton() {
        return waitForElementPresent(loginWithPasswordPhoneButton, "Cannot find 'Sign in with password' button", 3, true);
    }

    public WebElement getLogInInputFieldPhone() {
        return waitForElementPresent(logInInputFieldPhone, "Cannot find input field for login by Phone number", 5, true);
    }

    public WebElement getphoneIndex() {
        return waitForElementPresent(phoneIndex, "Cannot find Phone Index", 5, true);
    }
}
