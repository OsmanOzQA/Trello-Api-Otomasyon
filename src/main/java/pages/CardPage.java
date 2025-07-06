package pages;

import config.TrelloConfig;
import io.restassured.response.Response;

import java.util.Random;

import static io.restassured.RestAssured.*;

public class CardPage {

    public String createCard(String name, String listId) {
        Response response = given()
                .queryParam("name", name)
                .queryParam("idList", listId)
                .queryParam("key", TrelloConfig.API_KEY)
                .queryParam("token", TrelloConfig.TOKEN)
                .post(TrelloConfig.BASE_URL + "/cards");

        response.then().statusCode(200);
        return response.jsonPath().getString("id");
    }

    public void updateCard(String cardId, String newName) {
        given()
            .queryParam("name", newName)
            .queryParam("key", TrelloConfig.API_KEY)
            .queryParam("token", TrelloConfig.TOKEN)
            .put(TrelloConfig.BASE_URL + "/cards/" + cardId)
            .then().statusCode(200);
    }

    public void deleteCard(String cardId) {
        given()
            .queryParam("key", TrelloConfig.API_KEY)
            .queryParam("token", TrelloConfig.TOKEN)
            .delete(TrelloConfig.BASE_URL + "/cards/" + cardId)
            .then().statusCode(200);
    }

    public int getRandomIndex(int bound) {
        return new Random().nextInt(bound);
    }
}
