package api;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class ApiCreate extends TrelloHelper{

    public Response createBoardWithResponse(String boardName){
        String apiBoardCreate = "/boards/";
        String name = "name";
        Map<String, String> paramMap = new HashMap<String, String>() {{
            put(name,boardName);
        }};
        return returnResponsePost(apiBoardCreate,paramMap);

    }
    public boolean createBoard(String boardName){
        return statusIsCorrect(createBoardWithResponse(boardName));
    }

    public boolean createList(String nameList, String boardName){
        String apiListCreate = "/list/";
        String boardParam = "idBoard";
        String name = "name";
        ApiRead apiRead = new ApiRead();
        Map<String, String> paramMap = new HashMap<String, String>() {{
            put(name,nameList);
            put(boardParam,apiRead.getBoardId(boardName));
        }};
        return statusIsCorrect(returnResponsePost(apiListCreate,paramMap));
    }

    public boolean createCard(String nameCard, String nameList, String nameBoard){
        String apiListCreate = "/card/";
        String listParam = "idList";
        String name = "name";
        ApiRead apiRead = new ApiRead();
        Map<String, String> paramMap = new HashMap<String, String>() {{
            put(name,nameCard);
            put(listParam,apiRead.getListIdOnBoard(nameList,nameBoard));
        }};
        return statusIsCorrect(returnResponsePost(apiListCreate,paramMap));

    }



}
