package stepdefinitions;

import io.cucumber.java.en.*;
import pages.BoardPage;
import pages.CardPage;

public class TrelloStepDef {

    BoardPage boardPage = new BoardPage();
    CardPage cardPage = new CardPage();

    String boardId;
    String listId;
    String[] cardIds = new String[2];

    @Given("Trello üzerinde yeni bir board oluştur")
    public void createBoard() {
        boardId = boardPage.createBoard("Trello api");
    }

    @And("Board üzerindeki ilk listeyi al")
    public void getListId() {
        listId = boardPage.getFirstListId(boardId);
    }

    @When("Bu listeye iki kart oluştur")
    public void createTwoCards() {
        cardIds[0] = cardPage.createCard("Cucumber Card 1", listId);
        cardIds[1] = cardPage.createCard("Cucumber Card 2", listId);
    }

    @And("Bu kartlardan rastgele bir tanesini güncelle")
    public void updateRandomCard() {
        int random = cardPage.getRandomIndex(2);
        cardPage.updateCard(cardIds[random], "Updated Card " + (random + 1));
    }

    @And("Tüm kartları sil")
    public void deleteCards() {
        for (String cardId : cardIds) {
            cardPage.deleteCard(cardId);
        }
    }

    @Then("Board'u sil")
    public void deleteBoard() {
        boardPage.deleteBoard(boardId);
    }
}
