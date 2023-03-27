package api;

public class ApiRead extends TrelloParent {


    public String getBoardId(String boardName) {
        String boardsApi = "/members/me/boards";
        return getItemByName(returnResponseGet(boardsApi), boardName);
    }

    public String getListIdOnBoard(String listName, String boardName) {
        String listonBoardApi = "/boards/%s/lists";
        return getItemByName(returnResponseGet(
                        String.format(listonBoardApi, getBoardId(boardName))),
                listName);
    }

    public String getCardIdInListFromBoard(String cardName, String listName, String boardName) {
        String cardsOnBoardApi = "/lists/%s/cards";
        return getItemByName(returnResponseGet(
                        String.format(cardsOnBoardApi, getListIdOnBoard(listName, boardName))),
                cardName);
    }



}
