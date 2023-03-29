@Automated
Feature: Automated CRUD

  @API
  Scenario Outline: Create/Delete objects UI
    Given I as a user create board with name "<BoardName>"
    And I as a user create list with name "<ListName>" in board with name "<BoardName>"
    And I as a user create card with name "<CardName>" in list with name "<ListName>" from the board "<BoardName>"
    And I remove the card with name "<CardName>" from the list "<ListName>" of board "<BoardName>"
    When I remove the board with name "<BoardName>"
    Then The board with name "<BoardName>" should be removed
    Examples:
      | BoardName | ListName | CardName |
      | MyBoard   | MyList   | MyCard   |

  @API
  Scenario: set maximum boards API
    Given I as a user create 11 boards with name "BoardName"
    Then I as a user should got respond: "Board must be in a team"

  @UI
  Scenario: modify existing board API
    Given I as a user open navigate to url "http://trello.com" using browser "FIRE_FOX"
    And I as a user login to trello with "admin" credentials
    When I as a user create board with name "BoardName"
    And I as a user open the board with name "BoardName"
    And I as a user modify the board name from "BoardName" to "#$%*^(%R"
    And I as a user click on Board link
    Then board name should be "#$%*^(%R"