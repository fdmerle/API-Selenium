package step_definitions;

import pages.BoardPage;
import pages.LoginPage;
import pages.MainPage;
import api.ApiCreate;
import api.ApiDelete;
import api.ApiRead;
import api.ApiUpdate;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import jsonObj.GetCredentials;
import org.junit.Assert;
import wrappers.Driver;
import settingsObj.ObjectType;

import java.util.HashMap;
import java.util.Map;


public class AutomatedCRUD {

    ApiRead apiRead;
    ApiCreate apiCreate;
    ApiDelete apiDelete;
    ApiUpdate apiUpdate;
    Map<ObjectType, String> history;

    private final Driver driver = new Driver();
    private MainPage mainPage;
    private BoardPage boardPage;
    Response responseBoard;

    @Before
    public void init() {
        apiRead = new ApiRead();
        apiCreate = new ApiCreate();
        apiDelete = new ApiDelete();
        apiUpdate = new ApiUpdate();
        history = new HashMap<>();
    }

    @And("I as a user create board with name {string}")
    public void iAsAUserCreateBoardWithName(String boardName) {
        Assert.assertTrue(apiCreate.createBoard(boardName));
        history.put(ObjectType.BOARD, boardName);
    }

    @When("I remove the board with name {string}")
    public void iRemoveTheBoardWithName(String boardName) {
        Assert.assertTrue(apiDelete.removeBoardWithId(boardName));
        history.remove(ObjectType.BOARD);
    }

    @And("I as a user create list with name {string} in board with name {string}")
    public void iAsAUserCreateListWithNameInBoardWithName(String listName, String boardName) {
        Assert.assertTrue(apiCreate.createList(listName, boardName));
        history.put(ObjectType.LIST, listName);
    }

    @And("I as a user create card with name {string} in list with name {string} from the board {string}")
    public void iAsAUserCreateCardWithNameInListWithNameFromTheBoard(String cardName, String listName, String boardName) {
        Assert.assertTrue(apiCreate.createCard(cardName, listName, boardName));
        history.put(ObjectType.CARD, apiRead.getCardIdInListFromBoard(cardName, listName, boardName));
    }

    @And("I remove the card with name {string} from the list {string} of board {string}")
    public void iRemoveTheCardWithNameFromTheListOfBoard(String cardName, String listName, String boardName) {
        Assert.assertTrue(apiDelete.removeCardWithId(cardName, listName, boardName));
        history.remove(ObjectType.CARD);
    }

    @Given("I as a user create {int} boards with name {string}")
    public void iAsAUserCreateBoardsWithName(int boardsAmount, String boardName) {
        for (int i = 0; i < boardsAmount; i++) {
            responseBoard = apiCreate.createBoardWithResponse(boardName);
        }
        history.put(ObjectType.BOARD, boardName);
    }

    @Then("I as a user should got respond: {string}")
    public void iAsAUserShouldGotRespond(String assertString) {
        Assert.assertTrue(responseBoard.jsonPath().get().toString().contains(assertString));
    }

    @After
    public void cleanUp() {
        if (!history.isEmpty()) {
            if (history.containsKey(ObjectType.BOARD)) {
                apiDelete.removeAllBoards(history.get(ObjectType.BOARD));
            }
            if (mainPage != null) {
                mainPage.cleanDriver(driver);

            }
        }
    }

    @Given("I as a user open navigate to url {string} using browser {string}")
    public void iAsAUserOpenNavigateToUrlUsingBrowser(String url, String browserType) {
        driver.setWebDriver(browserType);
        driver.getWebDriver().get(url);
    }

    @And("I as a user login to trello with {string} credentials")
    public void iAsAUserLoginToTrelloWithCredentials(String credType) {

        GetCredentials getCredentials = new GetCredentials();
        LoginPage loginToPage = new LoginPage();
        mainPage = loginToPage.loginToPage(driver, getCredentials.getName(credType), getCredentials.getPass(credType));
    }
    @And("I as a user open the board with name {string}")
    public void iAsAUserOpenTheBoardWithName(String boardName) {
        boardPage = new BoardPage();
        boardPage = mainPage.openBoard(driver, boardName);
        history.put(ObjectType.BOARD, boardName);
    }

    @And("I as a user modify the board name from {string} to {string}")
    public void iAsAUserModifyTheBoardNameFromTo(String oldName, String newName) {
        boardPage.modifyBoardName(driver, oldName, newName);
    }

    @Then("board name should be {string}")
    public void boardNameShouldBe(String boardName) {
        Assert.assertTrue(boardPage.boardsIsExist(driver, boardName));
        history.put(ObjectType.BOARD, boardName);

    }

    @Then("The board with name {string} should be removed")
    public void theBoardWithNameShouldBeRemoved(String boardName) {
        Assert.assertNull(apiRead.getBoardId( boardName));    }

    @And("I as a user click on Board link")
    public void iAsAUserClickOnBoardLink() {
        boardPage.clickOnBoardLink(driver);
    }

    @And("Create new board")
    public void createNewBoard() {
    }

    @When("add the name to the board {string}")
    public void addTheNameToTheBoard(String arg0) {
    }

    @Then("condition that the name {string} should be shown is {string}")
    public void conditionThatTheNameShouldBeShownIs(String arg0, String arg1) {
    }

    @When("Create new board from the template with name {string}")
    public void createNewBoardFromTheTemplateWithName(String arg0) {
    }

    @And("I close the board with name {string}")
    public void iCloseTheBoardWithName(String arg0) {
    }

    @Then("Board with name {string} should be closed")
    public void boardWithNameShouldBeClosed(String arg0) {
    }

    @And("I delete the board with name {string}")
    public void iDeleteTheBoardWithName(String arg0) {
    }

    @Then("Board with name {string} should be deleted")
    public void boardWithNameShouldBeDeleted(String arg0) {
    }

    @And("I open the board with name {string}")
    public void iOpenTheBoardWithName(String arg0) {
    }

    @Then("condition that the board with name {string} should be shown is {string}")
    public void conditionThatTheBoardWithNameShouldBeShownIs(String arg0, String arg1) {
    }

    @And("I move board with name {string} to workspace with name {string}")
    public void iMoveBoardWithNameToWorkspaceWithName(String arg0, String arg1) {
    }

    @And("I switched to workspace with name {string}")
    public void iSwitchedToWorkspaceWithName(String arg0) {
    }

    @Given("when I as a user login to http:\\/\\/Trello.com")
    public void whenIAsAUserLoginToHttpTrelloCom() {
    }

    @And("I navigate to board settings")
    public void iNavigateToBoardSettings() {
    }

    @And("I set card cover to {string}")
    public void iSetCardCoverTo(String arg0) {
    }

    @Then("card cover should be visible")
    public void cardCoverShouldBeVisible() {
    }

    @And("I change commenting permissions to {string}")
    public void iChangeCommentingPermissionsTo(String arg0) {
    }

    @And("I login to system with user that have permission {string}")
    public void iLoginToSystemWithUserThatHavePermission(String arg0) {
    }

    @And("I am have rights to add comments: {string}")
    public void iAmHaveRightsToAddComments(String arg0) {
    }



}

