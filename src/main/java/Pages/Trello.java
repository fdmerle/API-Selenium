package Pages;

import wrappers.ControlType;
import wrappers.Driver;
import wrappers.WebObject;

import java.util.HashMap;

public class Trello extends MasterPage {


    private final HashMap<ControlType, WebObject> pageObjects = new HashMap<>();
    private static final  String XPATH_TYPE = "xpath";
    private static final  String ID_TYPE = "id";
    public Trello() {

        pageObjects.put(ControlType.OPEN_LOGIN, new WebObject(XPATH_TYPE, ".//a[text()='Log in' and not(@tabindex)]"));
        pageObjects.put(ControlType.LOGIN, new WebObject(ID_TYPE, "user"));
        pageObjects.put(ControlType.CONTINUE_BTN, new WebObject(ID_TYPE, "login"));
        pageObjects.put(ControlType.PASSWORD, new WebObject(ID_TYPE, "password"));
        pageObjects.put(ControlType.SUBMIT, new WebObject(ID_TYPE, "login-submit"));
        pageObjects.put(ControlType.BOARD_LABEL, new WebObject(XPATH_TYPE, ".//div[@title='%s' and @class='board-tile-details-name']"));
        pageObjects.put(ControlType.BOARD_NAME_TEXT, new WebObject(XPATH_TYPE, ".//*[local-name()='h1' and text()='%s']"));
        pageObjects.put(ControlType.EDIT_BOARD_NAME_TEXT, new WebObject(XPATH_TYPE, ".//input[@class='board-name-input js-board-name-input']"));
        pageObjects.put(ControlType.BOARD_LINK, new WebObject(XPATH_TYPE, ".//p[@class and text()='Boards']"));
        pageObjects.put(ControlType.BOARD_IN_LIST, new WebObject(XPATH_TYPE, ".//div[contains(@style,'overflow') and text()='%s']"));

    }
    public void loginToPage(Driver driver, String login, String password) {
        doClick(driver,pageObjects.get(ControlType.OPEN_LOGIN));
        enterText(driver, pageObjects.get(ControlType.LOGIN), login);
        doClick(driver,pageObjects.get(ControlType.CONTINUE_BTN));
        enterText(driver, pageObjects.get(ControlType.PASSWORD), password);
        doClick(driver,pageObjects.get(ControlType.SUBMIT));
    }
    public void openBoard(Driver driver, String boardName) {
        doClick(driver,pageObjects.
                get(ControlType.BOARD_LABEL).
                addStringToXpath(boardName));

    }
    public void modifyBoardName(Driver driver, String oldName, String newName) {
        doClick(driver,
                pageObjects.
                        get(ControlType.BOARD_NAME_TEXT).
                        addStringToXpath(oldName));
        enterText(driver,pageObjects.get(ControlType.EDIT_BOARD_NAME_TEXT),newName);

    }
    public void clickOnBoardLink(Driver driver) {
        doClick(driver,pageObjects.get(ControlType.BOARD_LINK));
    }

    public boolean boardsIsExist(Driver driver, String boardName) {
        return pageObjects.
                get(ControlType.BOARD_IN_LIST).
                addStringToXpath(boardName).
                objectExist(driver);
    }

}


