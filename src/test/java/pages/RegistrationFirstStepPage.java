package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Registration first step — экран с вопросом о возрасте ребёнка. */
public class RegistrationFirstStepPage extends BaseActions {

    /** Заголовок «How old is your child?» — Inspector: {@code XCUIElementTypeStaticText}, name == "How old is your child?". */
    public final By howOldIsYourChildTitle = AppiumBy.iOSClassChain(
            "**/XCUIElementTypeStaticText[`name == \"How old is your child?\"`]");

    public RegistrationFirstStepPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getHowOldIsYourChildTitle() {
        return waitForElementPresent(howOldIsYourChildTitle, "Cannot find 'How old is your child?' title", 10, true);
    }
}
