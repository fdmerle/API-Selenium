package api;



import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TrelloParent {

    String basedUrl = "https://api.trello.com/1";
    String key = "5055ed8ee14c50d97b804730cf275f60";
    String token = "ATTA1383fb88b343de2a5b57a926fa07a7403004880f1f1d241041dbce5cb6cf2d05F880B75D";

    int expectedStatus = 200;


    private final RequestSpecification requestSpecification;

    public TrelloParent() {
        requestSpecification= requestSpecificationGet();
    }

    public String getBasedUrl() {
        return basedUrl;
    }

    RequestSpecification requestSpecificationGet() {
        String tknLbl = "token";
        String keyLbl = "key";
        return given()
                .baseUri(basedUrl)
                .queryParam(tknLbl, token)
                .queryParam(keyLbl, key);
    }

    String getItemByName(Response response, String itemName) {
        String strToGet = "name";
        String nameInc = "name[%s]";
        String idInc =  "id[%s]";
        if (response.jsonPath().getString(strToGet).contains(itemName)) {
            int i = 0;
            while (!response.jsonPath().getString(String.format(nameInc,i)).equals(itemName)) {
                i++;
            }
            return response.jsonPath().getString(String.format(idInc,i));
        }
        return null;
    }

    Response returnResponseGet(String call) {
        return given().spec(requestSpecification).when().get(call);
    }

    Response returnResponsePost(String call, Map<String, String> params) {
        String contentType = "application/json";
        RequestSpecification reqApi = given().spec(requestSpecification).contentType(contentType);
        params.forEach(reqApi::queryParam);
        return reqApi.when().post(call);
    }

    Response returnResponseDelete(String call, String iD){
        return given().spec(requestSpecification).when().delete(call+iD);
    }



    boolean statusIsCorrect(Response response){
        return response.getStatusCode()==expectedStatus;
    }
}





