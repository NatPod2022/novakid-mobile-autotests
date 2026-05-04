package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Account screen. iOS + Android via accessibility id. */
public class AccountPage extends BaseActions {

    /** User header (initials): on iOS name may differ. */
    public final By userHeader = AppiumBy.accessibilityId("PP");
    public final By accountTitle = AppiumBy.accessibilityId("Account");
    public final By personalInfo = AppiumBy.accessibilityId("Personal information");
    public final By changePassword = AppiumBy.accessibilityId("Change password");
    public final By balanceHistory = AppiumBy.accessibilityId("Balance history");
    public final By privacyPolicy = AppiumBy.accessibilityId("Privacy policy");
    public final By termsAndConditions = AppiumBy.accessibilityId("Terms and Conditions");
    public final By backButton = AppiumBy.accessibilityId("Back");

    public AccountPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getUserHeader() {
        return waitForElementPresent(userHeader, "Cannot find user header", 5, true);
    }

    public WebElement getAccountTitle() {
        return waitForElementPresent(accountTitle, "Cannot find Account title", 5, true);
    }

    public WebElement getPersonalInfo() {
        return waitForElementPresent(personalInfo, "Cannot find Personal information", 5, true);
    }

    public WebElement getChangePassword() {
        return waitForElementPresent(changePassword, "Cannot find Change password", 5, true);
    }

    public WebElement getBalanceHistory() {
        return waitForElementPresent(balanceHistory, "Cannot find Balance history", 5, true);
    }

    public WebElement getPrivacyPolicy() {
        return waitForElementPresent(privacyPolicy, "Cannot find Privacy policy", 5, true);
    }

    public WebElement getTermsAndConditions() {
        return waitForElementPresent(termsAndConditions, "Cannot find Terms and Conditions", 5, true);
    }

    public WebElement getBackButton() {
        return waitForElementPresent(backButton, "Cannot find back button", 5, true);
    }
}
