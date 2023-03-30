package pages;

import settingsObj.ControlType;
import wrappers.Driver;
import wrappers.WebObject;

public class MainPage extends MasterPage{
    public MainPage() {

        pageObjects.put(ControlType.BOARD_LABEL, new WebObject(XPATH_TYPE, ".//div[@title='%s' and @class='board-tile-details-name']"));
    }
    public BoardPage openBoard(Driver driver, String boardName) {
        doClick(driver,pageObjects.
                get(ControlType.BOARD_LABEL).
                addStringToXpath(boardName));
        return new BoardPage();

    }
}
