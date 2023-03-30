package pages;

import settingsObj.ControlType;
import wrappers.Driver;
import wrappers.WebObject;

public class BoardPage extends MasterPage {
    public BoardPage() {
        pageObjects.put(ControlType.BOARD_LABEL, new WebObject(XPATH_TYPE, ".//div[@title='%s' and @class='board-tile-details-name']"));
        pageObjects.put(ControlType.BOARD_NAME_TEXT, new WebObject(XPATH_TYPE, ".//*[local-name()='h1' and text()='%s']"));
        pageObjects.put(ControlType.EDIT_BOARD_NAME_TEXT, new WebObject(XPATH_TYPE, ".//input[@class='board-name-input js-board-name-input']"));
        pageObjects.put(ControlType.BOARD_LINK, new WebObject(XPATH_TYPE, ".//p[@class and text()='Boards']"));
        pageObjects.put(ControlType.BOARD_IN_LIST, new WebObject(XPATH_TYPE, ".//div[contains(@style,'overflow') and text()='%s']"));
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
