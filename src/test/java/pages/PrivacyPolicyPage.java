package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Privacy Policy (открывается во встроенном браузере novakidschool.com). */
public class PrivacyPolicyPage extends BaseActions {

    /**
     * Заголовок «Privacy Policy» — единственный стабильный текст на странице.
     * Inspector: {@code XCUIElementTypeStaticText} с одинаковыми name/label/value. На странице такой текст встречается дважды
     * (хлебные крошки + сам заголовок), поэтому используем class chain без индекса — берём первый найденный.
     */
    public final By privacyPolicyTitle = AppiumBy.iOSClassChain(
            "**/XCUIElementTypeStaticText[`name == \"Privacy Policy\"`]");

    public PrivacyPolicyPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getPrivacyPolicyTitle() {
        return waitForElementPresent(privacyPolicyTitle, "Cannot find 'Privacy Policy' title", 10, true);
    }
}
