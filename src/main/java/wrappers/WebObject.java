package wrappers;

import org.openqa.selenium.By;

public class WebObject {
    private String objectType;
    private String objectValue;
    private By byObject;
    private String objectValueOrig;

    public WebObject(String objType, String objValue) {
        objectType = objType;
        objectValue = objValue;
        byGenerate(objValue, objType);
        objectValueOrig = objectValue;
    }

    private void byGenerate(String value, String type) {

        switch (type) {
            case "xpath":
                byObject = By.xpath(value);
                break;
            case "id":
                byObject = By.id(value);
                break;
            default:
                break;
        }

    }

    public int returnObjectAmount(Driver driver) {

        return driver.getWebDriver().findElements(byObject).size();

    }

    public WebObject addStringToXpath(String value) {
        objectValue = objectValueOrig;
        objectValue = String.format(objectValue, value);
        byGenerate(objectValue, objectType);
        return this;
    }

    public boolean objectExist(Driver driver) {
        driver.waitToBeClickable(byObject,5);
        return driver.getWebDriver().findElements(byObject).size() > 0;
    }

    public By getBy() {
        return byObject;
    }
}
