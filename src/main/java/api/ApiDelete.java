package api;

import io.restassured.response.Response;

public class ApiDelete extends TrelloParent {
    String allBoardsApi = "/members/me/boards";

    public boolean removeBoardWithId(String name) {
        ApiRead apiRead = new ApiRead();
        String boardsApi = "/boards/";
        return statusIsCorrect(returnResponseDelete(boardsApi, apiRead.getBoardId(name)));
    }

    public boolean removeCardWithId(String cardName, String listName, String boardName) {
        ApiRead apiRead = new ApiRead();
        String cardApi = "/cards/";
        return statusIsCorrect(returnResponseDelete(cardApi, apiRead.getCardIdInListFromBoard(cardName, listName, boardName)));
    }
   public void removeAllBoards(String itemName) {
        String getStringVal = "name";
        String jsnStr = "name[%s]";
        Response response = returnResponseGet(allBoardsApi);
        if(response.jsonPath().getString(getStringVal).contains(itemName)){
            int i = 0;
            while (response.jsonPath().getString(String.format(jsnStr,i)).equals(itemName)) {
                removeBoardWithId(itemName);
                i++;
            }
        }
    }
}
