package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Bonuses / Invite friends screen. iOS + Android via accessibility id. */
public class OldBonusPage extends BaseActions {

    /**
     * Подзаголовок «Invite your friends to Novakid and unlock exclusive rewards!» — единственный стабильный текст экрана.
     * Inspector: {@code XCUIElementTypeStaticText}, name равен этой строке.
     */
    public final By inviteFriendsText = AppiumBy.iOSClassChain(
            "**/XCUIElementTypeStaticText[`name == \"Invite your friends to Novakid and unlock exclusive rewards!\"`]");

    public OldBonusPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getInviteFriendsText() {
        return waitForElementPresent(inviteFriendsText, "Cannot find 'Invite your friends to Novakid and unlock exclusive rewards!' text", 10, true);
    }
}
