package api;

import io.restassured.response.Response;

public class ApiDelete extends TrelloHelper {
    private final String boardsApi = "/boards/";
    String allBoardsApi = "/members/me/boards";

    public boolean removeBoardWithId(String name) {
        ApiRead apiRead = new ApiRead();
        return statusIsCorrect(returnResponseDelete(boardsApi, apiRead.getBoardId(name)));
    }

    public boolean removeCardWithId(String cardName, String listName, String boardName) {
        ApiRead apiRead = new ApiRead();
        String cardApi = "/cards/";
        return statusIsCorrect(returnResponseDelete(cardApi, apiRead.getCardIdInListFromBoard(cardName, listName, boardName)));
    }
   public void removeAllBoards(String itemName) {
        Response response = returnResponseGet(allBoardsApi);
        ApiRead apiRead = new ApiRead();
        if(response.jsonPath().getString("name").contains(itemName)){
            int i = 0;
            while (response.jsonPath().getString("name[" + String.valueOf(i) + "]").equals(itemName)) {
                removeBoardWithId(itemName);
                i++;
            }
        }
    }
}
