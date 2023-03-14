package Pages;

import wrappers.Driver;
import wrappers.WebObject;
import java.util.HashMap;

public class Trello extends MasterPage {


    private enum objectName {
        openLogin,
        continueBtn,
        login,
        password,
        submit,
        boardLabel,
        boardNameText,
        editBoardNameText,
        boardLink,
        boardInList

    }
    private final HashMap<objectName, WebObject> pageObjects;
    public Trello(Driver driver) {
        pageObjects = new HashMap<objectName, WebObject>() {
            {
                put(objectName.openLogin, new WebObject("xpath", ".//a[text()='Log in' and not(@tabindex)]"));
                put(objectName.login, new WebObject("id", "user"));
                put(objectName.continueBtn, new WebObject("id", "login"));
                put(objectName.password, new WebObject("id", "password"));
                put(objectName.submit, new WebObject("id", "login-submit"));
                put(objectName.boardLabel, new WebObject("xpath", ".//div[@title='%s' and @class='board-tile-details-name']"));
                put(objectName.boardNameText, new WebObject("xpath", ".//*[local-name()='h1' and text()='%s']"));
                put(objectName.editBoardNameText, new WebObject("xpath", ".//input[@class='board-name-input js-board-name-input']"));
                put(objectName.boardLink, new WebObject("xpath", ".//p[@class and text()='Boards']"));
                put(objectName.boardInList, new WebObject("xpath", ".//div[contains(@style,'overflow') and text()='%s']"));

            }
        };
    }
    public void loginToPage(Driver driver, String login, String password) {
        doClick(driver,pageObjects.get(objectName.openLogin));
        enterText(driver, pageObjects.get(objectName.login), login);
        doClick(driver,pageObjects.get(objectName.continueBtn));
        enterText(driver, pageObjects.get(objectName.password), password);
        doClick(driver,pageObjects.get(objectName.submit));
    }
    public void openBoard(Driver driver, String boardName) {
        doClick(driver,pageObjects.
                get(objectName.boardLabel).
                addStringToXpath(boardName));

    }
    public void modifyBoardName(Driver driver, String oldName, String newName) {
        doClick(driver,
                pageObjects.
                        get(objectName.boardNameText).
                        addStringToXpath(oldName));
        enterText(driver,pageObjects.get(objectName.editBoardNameText),newName);

    }
    public void clickOnBoardLink(Driver driver) {
        doClick(driver,pageObjects.get(objectName.boardLink));
    }

    public boolean boardsIsExist(Driver driver, String boardName) {
        return pageObjects.
                get(objectName.boardInList).
                addStringToXpath(boardName).
                objectExist(driver);
    }

}


