package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Restore password page (opens from "I forgot password"). iOS via accessibility id. */
public class RestorePasswordPage extends BaseActions {

    /** Кнопка отправки: SemanticsId 'password_reset.submit_button' (restore_password_page_content.dart). */
    public final By submitButton = AppiumBy.accessibilityId("password_reset.submit_button");
    /** Поле Email: отдельного semantic ID нет, на экране одно текстовое поле. */
    public final By emailInputField = AppiumBy.className("XCUIElementTypeTextField");

    public RestorePasswordPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getSubmitButton() {
        return waitForElementPresent(submitButton, "Cannot find 'Reset password' submit button", 5, true);
    }

    public WebElement getEmailInputField() {
        return waitForElementPresent(emailInputField, "Cannot find Email input field on Reset password page", 5, true);
    }
}
