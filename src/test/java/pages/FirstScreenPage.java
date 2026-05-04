package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import interactions.BaseActions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

/**
 * Первый экран — нативный iOS-алёрт «Novakid Would Like to Send You Notifications».
 * <p>
 * Inspector часто не подсвечивает кнопки внутри системного алёрта. Поэтому работаем по двум каналам:
 * <ol>
 *     <li>class-chain под {@code XCUIElementTypeAlert} — если иерархия алёрта попала в page source;</li>
 *     <li>fallback через {@code mobile: alert} (action=getButtons) — это XCUITest-скрипт,
 *         который читает кнопки текущего системного алёрта напрямую через WDA, минуя page source.</li>
 * </ol>
 */
public class FirstScreenPage extends BaseActions {

    /** Сам контейнер системного алёрта. */
    public final By alertContainer = AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeAlert'");
    /** Кнопка «Allow» внутри алёрта (точный match — иначе CONTAINS 'Allow' цепляет и «Don't Allow»). */
    public final By allow = AppiumBy.iOSClassChain(
            "**/XCUIElementTypeAlert/**/XCUIElementTypeButton[`name == \"Allow\"`]");
    /** Кнопка «Don't Allow» внутри алёрта (учёт «прямого» и «фигурного» апострофа). */
    public final By denyButton = AppiumBy.iOSClassChain(
            "**/XCUIElementTypeAlert/**/XCUIElementTypeButton[`name == \"Don\u2019t Allow\" OR name == \"Don't Allow\"`]");

    private static final long ALERT_WAIT_SEC = 20;

    public FirstScreenPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getAlertContainer() {
        WebElement el = waitForAlertElement();
        if (el != null) {
            return el;
        }
        if (!alertButtons().isEmpty()) {
            return null;
        }
        throw new AssertionError("❌ Cannot find iOS system alert (XCUIElementTypeAlert)");
    }

    public WebElement getAllow() {
        WebElement el = waitForElementPresent(allow, "Cannot find 'Allow' button", ALERT_WAIT_SEC, false);
        if (el != null) {
            return el;
        }
        // fallback: проверяем через скрипт WDA
        if (alertButtons().stream().anyMatch(name -> name != null && name.equalsIgnoreCase("Allow"))) {
            return null;
        }
        throw new AssertionError("❌ Cannot find 'Allow' button (нет ни в дереве, ни в mobile: alert)");
    }

    public WebElement getDenyButton() {
        WebElement el = waitForElementPresent(denyButton, "Cannot find 'Don't Allow' button", ALERT_WAIT_SEC, false);
        if (el != null) {
            return el;
        }
        if (alertButtons().stream().anyMatch(this::isDenyName)) {
            return null;
        }
        throw new AssertionError("❌ Cannot find 'Don't Allow' button (нет ни в дереве, ни в mobile: alert)");
    }

    /** Дождаться появления системного алёрта в дереве (если он туда попадает). */
    private WebElement waitForAlertElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ALERT_WAIT_SEC));
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(alertContainer));
        } catch (Exception e) {
            return null;
        }
    }

    /** Список кнопок текущего системного алёрта через {@code mobile: alert} (XCUITest-скрипт). */
    private List<String> alertButtons() {
        try {
            Object result = ((JavascriptExecutor) driver).executeScript(
                    "mobile: alert", Map.of("action", "getButtons"));
            if (result instanceof List<?>) {
                return ((List<?>) result).stream()
                        .map(o -> o == null ? null : o.toString())
                        .toList();
            }
        } catch (Exception ignored) {
            // alert не виден или WDA ещё не готов
        }
        return List.of();
    }

    private boolean isDenyName(String name) {
        if (name == null) {
            return false;
        }
        // iOS подставляет «прямой» или «фигурный» апостроф — нормализуем
        String normalized = name.replace('\u2019', '\'');
        return normalized.equalsIgnoreCase("Don't Allow");
    }
}
