package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Login step: phone number / sign in with password. iOS + Android via accessibility id. */
public class LoginStepByPhonePage extends BaseActions {

    // NPA-8057 tags the container; the country selector is its first button.
    public final By phoneIndex = AppiumBy.xpath("//*[@name='login.phone_input']//XCUIElementTypeButton[1]");
    public final By loginWithPasswordPhoneButton = AppiumBy.accessibilityId("login.password_mode_button");
    public final By logInInputFieldPhone = AppiumBy.xpath("//*[@name='login.phone_input']//XCUIElementTypeTextField");

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
