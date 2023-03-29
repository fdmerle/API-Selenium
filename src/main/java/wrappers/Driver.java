package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settingsObj.DriverTypes;
import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
public class Driver {
    private WebDriver webDriver;
    Logger logger = Logger.getLogger(Driver.class.getName());

    public void setWebDriver(String driverString) {
        String chromeOpt = "--remote-allow-origins=*";
        String propName = "webdriver.chrome.driver";
        String capabName = "marionette";
        switch (DriverTypes.valueOf(driverString)) {
            case CHROME -> {
                logger.info("Chrome test starting ...");
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments(chromeOpt);
                System.setProperty(propName, getChromeDriverPath());
                webDriver = new ChromeDriver(optionsChrome);
            }
            case FIRE_FOX -> {
                FirefoxOptions opt = new FirefoxOptions();
                opt.setCapability(capabName, true);
                webDriver = new FirefoxDriver(opt);
            }
            default -> webDriver = null;
        }

    }

    public static String getChromeDriverPath() {
        String strProp = "os.name";
        String strWindowType="Windows";
        String strMacType= "Mac";
        String pathToChromeWin = "libs/chromedriver_win.exe";
        String pathToChromeMac = "libs/chromedriver_mac";
        String pathToChromeLin = "libs/chromedriver_linux";
        String propertyOS = System.getProperty(strProp);

        if (propertyOS.contains(strWindowType)) {
            return pathToChromeWin;
        } else if (propertyOS.contains(strMacType)) {
            return pathToChromeMac;
        } else {
            return pathToChromeLin;
        }
    }


    public boolean waitElementToBeVisible(String webElementXpath, int timeOut) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(timeOut));
        String errorMsg = "Not present: %";
        try {
            wait.until(ExpectedConditions.visibilityOf(getWebDriver().findElement(By.xpath(webElementXpath))));
            return true;
        } catch (Exception e) {
            logger.info(String.format(errorMsg, webElementXpath));
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
