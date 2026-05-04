package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Terms and Conditions (открывается во встроенном браузере novakidschool.com). */
public class TermsAndConditionsPage extends BaseActions {

    /**
     * Заголовок «General Terms and Conditions» — единственный стабильный текст на странице.
     * Inspector: {@code XCUIElementTypeStaticText} с одинаковыми name/label/value. На странице такой текст встречается дважды
     * (хлебные крошки + сам заголовок), поэтому используем class chain без индекса — берём первый найденный.
     */
    public final By generalTermsTitle = AppiumBy.iOSClassChain(
            "**/XCUIElementTypeStaticText[`name == \"General Terms and Conditions\"`]");

    public TermsAndConditionsPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getGeneralTermsTitle() {
        return waitForElementPresent(generalTermsTitle, "Cannot find 'General Terms and Conditions' title", 10, true);
    }
}
