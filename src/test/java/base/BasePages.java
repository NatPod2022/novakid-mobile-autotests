package base;

import io.appium.java_client.AppiumDriver;
import pages.*;

/**
 * Central init for all page objects (based on ui_test BasePages).
 * Tests get driver from AppiumBaseTest and call initPages(driver).
 */
public class BasePages {

    public AllowPermissionPage allowPermission;
    public FirstScreenPage firstScreen;
    public PreLoginPage preLogin;
    public LogInPageFirstStepPage logInPageFirstStep;
    public LoginStepByEmailPage loginStepByEmail;
    public LoginStepByPhonePage loginStepByPhone;
    public LoginWithPasswordEmailPage loginWithPasswordEmail;
    public LoginWithPasswordPhonePage loginWithPasswordPhone;
    public PreTrialDashboardAfterCancelTrialPage preTrialDashboard;
    public OpenScheduleTabPage openScheduleTabPage;
    public RightMenuListPage rightMenuListPage;
    public AccountPage accountPage;
    public LibraryPage libraryPage;
    public LogOutPopupPage logOutPopupPage;
    public PrivacyPolicyPage privacyPolicyPage;
    public TermsAndConditionsPage termsAndConditionsPage;
    public BalanceHistoryPage balanceHistoryPage;
    public ChooseTeacherPage chooseTeacherPage;
    public FavouriteTeachersPage favouriteTeachersPage;
    public HelpPage helpPage;
    public NewStudentPage newStudentPage;
    public PasswordPage passwordPage;
    public PersonalInformationPage personalInformationPage;
    public OpenAchievementTabPage openAchievementTabPage;
    public OpenProgramPage openProgramPage;
    public RegistrationFirstStepPage registrationFirstStepPage;
    public SpeakingPracticePage speakingPracticePage;
    public SubscriptionTrialPage subscriptionTrialPage;
    public BuySubscriptionTrialPage buySubscriptionTrialPage;
    public OpenIntercomPage openIntercomPage;
    public OldBonusPage oldBonusPage;
    public NewScheduleUIPage newScheduleUIPage;
    public CalendarSyncAccountPage calendarSyncAccountPage;

    public void initPages(AppiumDriver driver) {
        allowPermission = new AllowPermissionPage(driver);
        firstScreen = new FirstScreenPage(driver);
        preLogin = new PreLoginPage(driver);
        logInPageFirstStep = new LogInPageFirstStepPage(driver);
        loginStepByEmail = new LoginStepByEmailPage(driver);
        loginStepByPhone = new LoginStepByPhonePage(driver);
        loginWithPasswordEmail = new LoginWithPasswordEmailPage(driver);
        loginWithPasswordPhone = new LoginWithPasswordPhonePage(driver);
        preTrialDashboard = new PreTrialDashboardAfterCancelTrialPage(driver);
        openScheduleTabPage = new OpenScheduleTabPage(driver);
        rightMenuListPage = new RightMenuListPage(driver);
        accountPage = new AccountPage(driver);
        libraryPage = new LibraryPage(driver);
        logOutPopupPage = new LogOutPopupPage(driver);
        privacyPolicyPage = new PrivacyPolicyPage(driver);
        termsAndConditionsPage = new TermsAndConditionsPage(driver);
        balanceHistoryPage = new BalanceHistoryPage(driver);
        chooseTeacherPage = new ChooseTeacherPage(driver);
        favouriteTeachersPage = new FavouriteTeachersPage(driver);
        helpPage = new HelpPage(driver);
        newStudentPage = new NewStudentPage(driver);
        passwordPage = new PasswordPage(driver);
        personalInformationPage = new PersonalInformationPage(driver);
        openAchievementTabPage = new OpenAchievementTabPage(driver);
        openProgramPage = new OpenProgramPage(driver);
        registrationFirstStepPage = new RegistrationFirstStepPage(driver);
        speakingPracticePage = new SpeakingPracticePage(driver);
        subscriptionTrialPage = new SubscriptionTrialPage(driver);
        buySubscriptionTrialPage = new BuySubscriptionTrialPage(driver);
        openIntercomPage = new OpenIntercomPage(driver);
        oldBonusPage = new OldBonusPage(driver);
        newScheduleUIPage = new NewScheduleUIPage(driver);
        calendarSyncAccountPage = new CalendarSyncAccountPage(driver);
    }
}
