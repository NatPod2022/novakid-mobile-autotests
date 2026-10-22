package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Set password screen. iOS + Android via accessibility id. */
public class PasswordPage extends BaseActions {

    public final By backButton = AppiumBy.accessibilityId("navigation.back_button");
    public final By setPasswordTitle = AppiumBy.iOSNsPredicateString("name CONTAINS 'Set password'");
    public final By passwordInfoText = AppiumBy.iOSNsPredicateString("name CONTAINS 'When you reset the password'");
    /** Fields are XCUIElementTypeTextField (not SecureTextField); caption as separate StaticText; the field itself has an empty label. XPath from Inspector. */
    public final By newPasswordField = AppiumBy.xpath(
            "//XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField[1]");
    public final By repeatPasswordField = AppiumBy.xpath(
            "//XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField[2]");
    public final By generatePasswordButton = AppiumBy.accessibilityId("set_password.generate_password_button");
    public final By proceedButton = AppiumBy.accessibilityId("set_password.continue_button");

    public PasswordPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getBackButton() {
        return waitForElementPresent(backButton, "Cannot find Back button", 5, true);
    }

    public WebElement getSetPasswordTitle() {
        return waitForElementPresent(setPasswordTitle, "Cannot find Set Password title", 5, true);
    }

    public WebElement getPasswordInfoText() {
        return waitForElementPresent(passwordInfoText, "Cannot find password info text", 5, true);
    }

    public WebElement getNewPasswordField() {
        return waitForElementPresent(newPasswordField, "Cannot find New Password field", 10, true);
    }

    public WebElement getRepeatPasswordField() {
        return waitForElementPresent(repeatPasswordField, "Cannot find Repeat Password field", 10, true);
    }

    public WebElement getGeneratePasswordButton() {
        return waitForElementPresent(generatePasswordButton, "Cannot find Generate Password button", 5, true);
    }

    public WebElement getProceedButton() {
        return waitForElementPresent(proceedButton, "Cannot find Proceed button", 5, true);
    }
}
