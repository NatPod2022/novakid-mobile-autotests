package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import interactions.BaseActions;

import java.time.Duration;

/**
 * Kids area (WebView). Внутри WebView ID нет, поэтому проверяем только нативную часть:
 * при открытии Kids area MicPermissionGuard запрашивает доступ к микрофону (системный pop-up iOS).
 */
public class KidsAreaPage extends BaseActions {

    private static final int WAIT_FOR_ALERT_SEC = 10;

    public KidsAreaPage(AppiumDriver driver) {
        super(driver);
    }

    /** Проверяет, что показан системный pop-up с запросом доступа к микрофону. Pop-up не закрывает. */
    public void checkMicPermissionAlertIsShown() {
        Alert alert;
        try {
            alert = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ALERT_SEC))
                    .until(ExpectedConditions.alertIsPresent());
        } catch (Exception e) {
            throw new AssertionError("❌ Microphone permission pop-up is not shown after opening Kids area", e);
        }
        String text = alert.getText();
        if (text == null || !text.toLowerCase().contains("microphone")) {
            throw new AssertionError("❌ Shown pop-up is not a microphone permission request: " + text);
        }
    }
}
