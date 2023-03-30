package pages;

import settingsObj.ControlType;
import wrappers.Driver;
import wrappers.WebObject;

import java.util.EnumMap;

public class MasterPage {
    static final  String XPATH_TYPE = "xpath";
    static final  String ID_TYPE = "id";
    EnumMap<ControlType, WebObject> pageObjects = new EnumMap<>(ControlType.class);

    private static final int WAITING_TIME_SEC =5;
    public void doClick(Driver driver, WebObject webObject) {
        driver.waitToBeClickable(webObject.getBy(), WAITING_TIME_SEC);
        driver.getWebDriver().findElement(webObject.getBy()).click();
    }


    public void enterText(Driver driver, WebObject webObject, String textToEnter) {
        driver.waitToBeClickable(webObject.getBy(), WAITING_TIME_SEC);
        driver.getWebDriver().findElement(webObject.getBy()).sendKeys(textToEnter);
    }

    public void cleanDriver(Driver driver){
        driver.getWebDriver().quit();
    }

}
