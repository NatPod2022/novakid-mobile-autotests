package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Pre-login welcome screen. iOS: accessibility id; Android: xpath from ui_test. */
public class PreLoginPage extends BaseActions {

    // iOS (XCUIElementType): name/label; Android: content-desc
    public final By welcomeTitle = AppiumBy.accessibilityId("Welcome to Novakid");
    public final By subtitleText = AppiumBy.accessibilityId("Exciting gamified English learning for kids aged 4 to 12");
    public final By tryForFreeButton = AppiumBy.accessibilityId("welcome.try_for_free_button");
    public final By loginButton = AppiumBy.accessibilityId("welcome.sign_in_button");

    public PreLoginPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getWelcomeTitle() {
        return waitForElementPresent(welcomeTitle, "Cannot find 'Welcome to Novakid' title", 5, true);
    }

    public WebElement getSubtitleText() {
        return waitForElementPresent(subtitleText, "Cannot find subtitle text", 5, true);
    }

    public WebElement getTryForFreeButton() {
        return waitForElementPresent(tryForFreeButton, "Cannot find 'Try for Free' button", 5, true);
    }

    public WebElement getLoginButton() {
        return waitForElementPresent(loginButton, "Cannot find 'Sign in' button", 5, true);
    }
}
