package pages;


import io.restassured.http.ContentType;
import config.TrelloConfig;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class BoardPage {

  public String createBoard(String boardName) {
    String boardId = given()
         .accept(ContentType.JSON)
         .contentType(ContentType.URLENC) // Bu satır CRITICAL!
         .queryParam("name", boardName)
         .queryParam("key", TrelloConfig.API_KEY)
         .queryParam("token", TrelloConfig.TOKEN)
         .when()
         .post(TrelloConfig.BASE_URL + "/boards")
         .then()
         .statusCode(200)
         .extract()
         .path("id");

     return boardId;
}

    public void deleteBoard(String boardId) {
        given()
            .queryParam("key", TrelloConfig.API_KEY)
            .queryParam("token", TrelloConfig.TOKEN)
            .delete(TrelloConfig.BASE_URL + "/boards/" + boardId)
            .then().statusCode(200);
    }

    public String getFirstListId(String boardId) {
        Response response = given()
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.TOKEN)
                .get(TrelloConfig.BASE_URL + "/boards/" + boardId + "/lists");

        response.then().statusCode(200);
        return response.jsonPath().getString("id[0]");
    }
}
