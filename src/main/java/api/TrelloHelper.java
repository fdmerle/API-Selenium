package api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class TrelloHelper {

    String basedUrl = "https://api.trello.com/1";
    String key = "5055ed8ee14c50d97b804730cf275f60";
    String token = "ATTA1383fb88b343de2a5b57a926fa07a7403004880f1f1d241041dbce5cb6cf2d05F880B75D";

    int expectedStatus = 200;


    private final RequestSpecification requestSpecification;

    public TrelloHelper() {
        requestSpecification= requestSpecificationGet();
    }

    public String getBasedUrl() {
        return basedUrl;
    }

    RequestSpecification requestSpecificationGet() {
        return given()
                .baseUri(basedUrl)
                .queryParam("token", token)
                .queryParam("key", key);
    }

    String getItemByName(Response response, String itemName) {
        if (response.jsonPath().getString("name").contains(itemName)) {
            int i = 0;
            while (!response.jsonPath().getString("name[" + i + "]").equals(itemName)) {
                i++;
            }
            return response.jsonPath().getString("id[" + i + "]");
        }
        return null;
    }

    Response returnResponseGet(String call) {
        return given().spec(requestSpecification).when().get(call);
    }

    Response returnResponsePost(String call, Map<String, String> params) {
        RequestSpecification reqApi = given().spec(requestSpecification).contentType("application/json");
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





