package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Dashboard after cancel trial (logo, tabs, schedule). iOS + Android via accessibility id. */
public class PreTrialDashboardAfterCancelTrialPage extends BaseActions {

    public final By labelNovakid = AppiumBy.accessibilityId("Novakid");
    /**
     * Открывалка правого меню — аватар с инициалами «PP» в шапке (Inspector: {@code XCUIElementTypeStaticText}, name == "PP").
     * Класс-чейн надёжнее, чем CONTAINS[cd] 'PP' — последнее цепляет любые строки с подстрокой "pp" и попадает не в тот элемент.
     */
    public final By logoParent = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"PP\"`]");
    public final By title = AppiumBy.accessibilityId("Claim your free lesson!");
    /** Подзаголовок-извинение — целиком: «We're sorry you had to cancel your trial lesson. But you can rebook it. Do it now!». Берём по BEGINSWITH, не точный id. */
    public final By textWeAreSorry = AppiumBy.iOSNsPredicateString(
            "type == 'XCUIElementTypeStaticText' AND (name BEGINSWITH \"We're sorry\" OR label BEGINSWITH \"We're sorry\" OR value BEGINSWITH \"We're sorry\")");
    public final By bookButton = AppiumBy.accessibilityId("Book my trial lesson");
    /** Таб «Dashboard» — полный name «Dashboard\nTab 1 of 5» (Inspector). По чистому id «Dashboard» не находится — берём BEGINSWITH. */
    public final By dashboardTab = AppiumBy.iOSNsPredicateString(
            "type == 'XCUIElementTypeButton' AND (name BEGINSWITH 'Dashboard' OR label BEGINSWITH 'Dashboard')");
    public final By scheduleTab = AppiumBy.iOSNsPredicateString("name BEGINSWITH 'Schedule'");
    /** Таб «Classroom» — полный name «Classroom, homework\nTab 3 of 5» (Inspector). По чистому id «Classroom» не находится — берём BEGINSWITH. */
    public final By kaTab = AppiumBy.iOSNsPredicateString(
            "type == 'XCUIElementTypeButton' AND (name BEGINSWITH 'Classroom' OR label BEGINSWITH 'Classroom')");
    public final By achievementTab = AppiumBy.iOSNsPredicateString("name CONTAINS 'Achievements'");
    public final By supportTab = AppiumBy.iOSNsPredicateString("name BEGINSWITH 'Support'");

    public PreTrialDashboardAfterCancelTrialPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getLogoParent() {
        return waitForElementPresent(logoParent, "Cannot find parent logo", 5, true);
    }

    public WebElement getScheduleTab() {
        return waitForElementPresent(scheduleTab, "Cannot find Schedule tab", 5, true);
    }

    public WebElement getLabelNovakid() {
        return waitForElementPresent(labelNovakid, "Cannot find Novakid label", 5, true);
    }

    public WebElement getTitle() {
        return waitForElementPresent(title, "Cannot find 'Claim your free lesson!' title", 5, true);
    }

    public WebElement getTextWeAreSorry() {
        return waitForElementPresent(textWeAreSorry, "Cannot find apology text", 5, true);
    }

    public WebElement getBookButton() {
        return waitForElementPresent(bookButton, "Cannot find 'Book my trial lesson' button", 5, true);
    }

    public WebElement getDashboardTab() {
        return waitForElementPresent(dashboardTab, "Cannot find Dashboard tab", 5, true);
    }

    public WebElement getKaTab() {
        return waitForElementPresent(kaTab, "Cannot find KA tab", 5, true);
    }

    public WebElement getAchievementTab() {
        return waitForElementPresent(achievementTab, "Cannot find Achievements tab", 20, true);
    }

    public WebElement getSupportTab() {
        return waitForElementPresent(supportTab, "Cannot find Support tab", 5, true);
    }
}
