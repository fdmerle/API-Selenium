package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settingsObj.DriverTypes;
import java.time.Duration;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
public class Driver {
    private WebDriver webDriver;

    public void setWebDriver(String driverString) {
        switch (DriverTypes.valueOf(driverString)) {
            case Chrome:
                System.out.println("Chrome test starting ...");
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--remote-allow-origins=*");
                System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
                webDriver = new ChromeDriver(optionsChrome);
                break;
            case FireFox:
                FirefoxOptions opt = new FirefoxOptions();
                opt.setCapability("marionette", true);
                webDriver = new FirefoxDriver(opt);
                break;
            default:
                webDriver = null;
        }

    }

    public static String getChromeDriverPath() {
        String OS = System.getProperty("os.name");

        if (OS.contains("Window")) {
            return "libs/chromedriver_win.exe";
        } else if (OS.contains("Mac")) {
            return "libs/chromedriver_mac";
        } else {
            return "libs/chromedriver_linux";
        }
    }


    public boolean waitElementToBeVisible(String webElementXpath, int timeOut) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(timeOut));
        try {
            wait.until(ExpectedConditions.visibilityOf(getWebDriver().findElement(By.xpath(webElementXpath))));
            return true;
        } catch (Exception e) {
            System.out.println("Not present: " + webElementXpath);
            return false;
        }
    }

    public void waitToBeClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }



    public void waitElementToBeActive(String webElementXpath, int timeOut) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(webElementXpath)));
    }

    public void waitElementToBecomeInvisible(String webElementXpath, int timeOut) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(webElementXpath)));
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
