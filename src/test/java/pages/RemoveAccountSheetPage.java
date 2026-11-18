package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Шторка удаления аккаунта (remove_account_bottom_sheet.dart). Открывается по "Delete account" на Personal information. */
public class RemoveAccountSheetPage extends BaseActions {

    /** Заголовок: LocaleKeys.remove_account_warning_title. Отдельного semantic ID нет. */
    public final By title = AppiumBy.iOSNsPredicateString(
            "label CONTAINS[c] 'delete your account' OR name CONTAINS[c] 'delete your account'");
    /** «Delete forever» — только проверяем наличие, НЕ нажимаем. */
    public final By deleteForeverButton = AppiumBy.accessibilityId("remove_account.dialog.confirm_button");
    public final By cancelButton = AppiumBy.accessibilityId("remove_account.dialog.cancel_button");

    public RemoveAccountSheetPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getTitle() {
        return waitForElementPresent(title, "Cannot find 'Are you sure you want to delete your account?' title", 5, true);
    }

    public WebElement getDeleteForeverButton() {
        return waitForElementPresent(deleteForeverButton, "Cannot find 'Delete forever' button", 5, true);
    }

    public WebElement getCancelButton() {
        return waitForElementPresent(cancelButton, "Cannot find 'Cancel' button", 5, true);
    }

    /** Проверяет, что шторка закрылась (кнопки «Delete forever» больше нет на экране). */
    public void checkSheetIsClosed() {
        long end = System.currentTimeMillis() + 5_000;
        while (System.currentTimeMillis() < end) {
            if (driver.findElements(deleteForeverButton).isEmpty()) {
                return;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        throw new AssertionError("❌ Delete account sheet is still shown after clicking 'Cancel'");
    }
}
