Feature: Trello API Testi

  Scenario: Trello'da board ve kart oluştur, güncelle ve sil
    Given Trello üzerinde yeni bir board oluştur
    And Board üzerindeki ilk listeyi al
    When Bu listeye iki kart oluştur
    And Bu kartlardan rastgele bir tanesini güncelle
    And Tüm kartları sil
    Then Board'u sil
