package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.Map;

public class Driver {
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<WebDriver>();
    private Driver() {
    }
    /**
     * Synchronized makes method thread safe.
     * It ensures that only 1 thread can use it at the time.
     * Thread safety reduces performance but it makes everything safe.
     * @return WebDriver
     */
    public synchronized static WebDriver getDriver() {
        if (driverPool.get() == null) {
            System.out.println("getDriver *******************");
            System.out.println("getDriver *******************");

            /*
             * We specified the type of browser in the configuration.properties file.
             * And then, we load these information into a Properties class object
             * by initiating a FileInputStream class  object.
             * This is where we will get type of browser by using ConfigurationReader.java class object.
             */
            String browser = ConfigReader.getProperty("browser").toLowerCase();

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driverPool.set(new ChromeDriver(chromeOptions));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                case "safari":
                    driverPool.set(new SafariDriver());
                    driverPool.get().manage().window().maximize();
                    break;
                default:
                    throw new RuntimeException("Wrong browser name !");
            }
        }
        return driverPool.get();
    }
    /**
     * Creates and returns a WebDriver instance for a specified mobile device emulation.
     * This method is synchronized to ensure thread safety when accessing the driverPool.
     * @param deviceName The name of the mobile device to emulate.
     * This should be a valid device name recognized by ChromeDriver for emulation.
     * @return A WebDriver instance configured for the specified mobile device emulation.
     */
    public synchronized static WebDriver getDriver(String deviceName) {
        System.out.println("getDriver with parameter *******************");
        System.out.println("getDriver with parameter *******************");
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", deviceName);
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        chromeOptions.addArguments("--start-maximized");
        driverPool.set(new ChromeDriver(chromeOptions));

        return driverPool.get();
    }
    public static void closeDriver() {
        if (driverPool != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}

