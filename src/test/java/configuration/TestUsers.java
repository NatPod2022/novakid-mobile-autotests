package configuration;

import java.util.Optional;

/**
 * Centralized test users used in e2e tests.
 * Values can be overridden via system properties or environment variables,
 * with the same precedence as {@link CapabilitiesProvider}:
 *   1. -Dproperty.name=...
 *   2. environment variable
 *   3. default value
 */
public final class TestUsers {

    public record TestUser(String email, String password) {
    }

    private TestUsers() {
    }

    private static String value(String prop, String env, String defaultValue) {
        return Optional.ofNullable(System.getProperty(prop))
                .or(() -> Optional.ofNullable(System.getenv(env)))
                .orElse(defaultValue);
    }

    /** User who has previously cancelled a trial; used for post-cancel-trial flows. */
    public static TestUser afterCancelTrial() {
        return new TestUser(
                value("test.user.afterCancelTrial.email", "TEST_USER_AFTER_CANCEL_TRIAL_EMAIL", "np_test@mail.nv"),
                value("test.user.afterCancelTrial.password", "TEST_USER_AFTER_CANCEL_TRIAL_PASSWORD", "12345678")
        );
    }

    /**
     * User with lessons on balance (i.e. has a populated schedule).
     * Used for teacher / schedule related tests.
     */
    public static TestUser schedule() {
        return new TestUser(
                value("test.user.schedule.email", "TEST_USER_SCHEDULE_EMAIL", "Auto_Test_schedule@mail.ru"),
                value("test.user.schedule.password", "TEST_USER_SCHEDULE_PASSWORD", "12345678")
        );
    }
}
