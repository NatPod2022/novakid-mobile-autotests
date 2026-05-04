package configuration;

import io.appium.java_client.ios.options.XCUITestOptions;

import java.io.File;
import java.time.Duration;
import java.util.Optional;

/**
 * Provides iOS capabilities for Appium XCUITest.
 * For real device: connect device, set UDID if needed (system property "device.udid" or env DEVICE_UDID).
 * App is installed from folder "app/" in project root if app.path/APP_PATH not set.
 */
public final class CapabilitiesProvider {

    private static final String DEFAULT_APPIUM_URL = "http://127.0.0.1:4723";
    private static final String BUNDLE_ID = "com.novakid.students";

    /** Folder in project root from which to install the app (.app or .ipa). */
    public static final String APP_FOLDER = "app";

    private CapabilitiesProvider() {
    }

    public static String getAppiumServerUrl() {
        return Optional.ofNullable(System.getProperty("appium.url"))
                .or(() -> Optional.ofNullable(System.getenv("APPIUM_URL")))
                .orElse(DEFAULT_APPIUM_URL);
    }

    /**
     * Resolve path to app binary. Uses app.path/APP_PATH, or looks in project's app/ folder
     * for Novakid.app / Novakid.ipa or any .app/.ipa.
     */
    public static String resolveAppPath() {
        String explicit = Optional.ofNullable(System.getProperty("app.path"))
                .or(() -> Optional.ofNullable(System.getenv("APP_PATH")))
                .orElse(null);

        if (explicit != null && !explicit.isBlank()) {
            File file = new File(explicit);
            if (file.isAbsolute() && file.exists()) {
                return file.getAbsolutePath();
            }

            File fromCwd = new File(System.getProperty("user.dir", ""), explicit);
            if (fromCwd.exists()) {
                return fromCwd.getAbsolutePath();
            }

            return explicit;
        }

        File appDir = new File(System.getProperty("user.dir", ""), APP_FOLDER);
        if (!appDir.isDirectory()) {
            return null;
        }

        for (String name : new String[]{"Novakid.app", "Novakid.ipa"}) {
            File candidate = new File(appDir, name);
            if (candidate.exists()) {
                return candidate.getAbsolutePath();
            }
        }

        File[] files = appDir.listFiles((dir, name) ->
                name.endsWith(".app") || name.endsWith(".ipa"));

        if (files != null && files.length == 1) {
            return files[0].getAbsolutePath();
        }

        if (files != null && files.length > 1) {
            for (File file : files) {
                if (file.getName().endsWith(".app")) {
                    return file.getAbsolutePath();
                }
            }
            return files[0].getAbsolutePath();
        }

        return null;
    }

    /**
     * iOS capabilities for real device or simulator.
     * App is installed from app.path / APP_PATH or from project folder "app/".
     */
    public static XCUITestOptions getIOSCapabilities() {
        XCUITestOptions options = new XCUITestOptions()
                .setNewCommandTimeout(Duration.ofSeconds(400));

        String udid = Optional.ofNullable(System.getProperty("device.udid"))
                .or(() -> Optional.ofNullable(System.getenv("DEVICE_UDID")))
                .orElse("auto");
        options.setUdid(udid);

        String appPath = resolveAppPath();
        if (appPath != null && !appPath.isBlank()) {
            options.setApp(appPath);
        } else {
            options.setBundleId(BUNDLE_ID);
        }

        // Stability-related capabilities for real iOS device
        //options.setCapability("appium:useNewWDA", false);
        options.setCapability("appium:wdaLaunchTimeout", 120000);
        options.setCapability("appium:wdaConnectionTimeout", 240000);
        options.setCapability("appium:wdaStartupRetries", 2);
        options.setCapability("appium:wdaStartupRetryInterval", 20000);
        options.setCapability("appium:iosInstallPause", 10000);
        //options.setCapability("appium:autoAcceptAlerts", true);

        return options;
    }
}