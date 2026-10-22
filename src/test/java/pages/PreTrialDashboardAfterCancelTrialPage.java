package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import interactions.BaseActions;

/** Dashboard after cancel trial (logo, tabs, schedule). iOS + Android via accessibility id. */
public class PreTrialDashboardAfterCancelTrialPage extends BaseActions {

    public final By labelNovakid = AppiumBy.accessibilityId("Novakid");
    /** Кнопка меню родителя: ID из DashboardAppBar (NPA-8057), не зависит от инициалов. */
    public final By logoParent = AppiumBy.accessibilityId("navigation.profile_menu_button");
    public final By title = AppiumBy.accessibilityId("Claim your free lesson!");
    /** Подзаголовок-извинение — целиком: «We're sorry you had to cancel your trial lesson. But you can rebook it. Do it now!». Берём по BEGINSWITH, не точный id. */
    public final By textWeAreSorry = AppiumBy.iOSNsPredicateString(
            "type == 'XCUIElementTypeStaticText' AND (name BEGINSWITH \"We're sorry\" OR label BEGINSWITH \"We're sorry\" OR value BEGINSWITH \"We're sorry\")");
    public final By bookButton = AppiumBy.accessibilityId("home.book_trial_button");
    /** Нижняя вкладка Dashboard: semantic ID из ParentContentPage. */
    public final By dashboardTab = AppiumBy.accessibilityId("navigation.home_tab");
    public final By scheduleTab = AppiumBy.accessibilityId("navigation.schedule_tab");
    /** Нижняя вкладка Kids Area / Classroom: semantic ID из ParentContentPage. */
    public final By kaTab = AppiumBy.accessibilityId("navigation.kids_area_tab");
    public final By achievementTab = AppiumBy.accessibilityId("navigation.achievements_tab");
    public final By supportTab = AppiumBy.accessibilityId("navigation.support_tab");

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
