package Pages;

import wrappers.Driver;
import wrappers.WebObject;

public class MasterPage {
private int waitingTimeSec=5;
    public void doClick(Driver driver, WebObject webObject) {
        driver.waitToBeClickable(webObject.getBy(),waitingTimeSec);
        driver.getWebDriver().findElement(webObject.getBy()).click();
    }


    public void enterText(Driver driver, WebObject webObject, String textToEnter) {
        driver.waitToBeClickable(webObject.getBy(),waitingTimeSec);
        driver.getWebDriver().findElement(webObject.getBy()).sendKeys(textToEnter);
    }

    public void simulateTextEnter(Driver driver, WebObject webObject, String textToEnter) {
        driver.waitToBeClickable(webObject.getBy(),waitingTimeSec);
        driver.getWebDriver().findElement(webObject.getBy()).sendKeys(textToEnter);
    }

    public void cleanDriver(Driver driver){
        driver.getWebDriver().quit();
    }

}
