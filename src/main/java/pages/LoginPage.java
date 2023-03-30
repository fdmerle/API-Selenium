package pages;

import settingsObj.ControlType;
import wrappers.Driver;
import wrappers.WebObject;

public class LoginPage  extends MasterPage {


    public LoginPage() {

        pageObjects.put(ControlType.OPEN_LOGIN, new WebObject(XPATH_TYPE, ".//a[text()='Log in' and not(@tabindex)]"));
        pageObjects.put(ControlType.LOGIN, new WebObject(ID_TYPE, "user"));
        pageObjects.put(ControlType.CONTINUE_BTN, new WebObject(ID_TYPE, "login"));
        pageObjects.put(ControlType.PASSWORD, new WebObject(ID_TYPE, "password"));
        pageObjects.put(ControlType.SUBMIT, new WebObject(ID_TYPE, "login-submit"));
    }

    public MainPage loginToPage(Driver driver, String login, String password) {
        doClick(driver,pageObjects.get(ControlType.OPEN_LOGIN));
        enterText(driver, pageObjects.get(ControlType.LOGIN), login);
        doClick(driver,pageObjects.get(ControlType.CONTINUE_BTN));
        enterText(driver, pageObjects.get(ControlType.PASSWORD), password);
        doClick(driver,pageObjects.get(ControlType.SUBMIT));
        return new MainPage();
    }
}
