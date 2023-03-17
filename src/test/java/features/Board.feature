@NotAutomated
Feature: Board CRUD

  Scenario Outline: Add the Board name
#    API implementation
    Given I as a user open navigate to url "http://trello.com" using browser "Chrome"
    #    API implementation
    And Create new board
    #    API implementation
    When add the name to the board "<Name>"
#    UI validation is implemented
    Then condition that the name "<Name>" should be shown is "<Result>"
    Examples:
      | Name                                     | Result |
      | afdasfddwefwdewfew#$%WEWRWERF123123      | True   |
      | #$%##$%                                  | True   |
      |                                          | False  |
      | 1231                                     | True   |
      | function randomScript(){alert("Test!");} | False  |


  Scenario: Create board from the template
  #    API implementation
    Given I as a user open navigate to url "http://trello.com" using browser "Chrome"
    #    API implementation
    When Create new board from the template with name "name"
    #    UI validation is implemented
    Then condition that the name "name" should be shown is "True"


  Scenario: Close the board
    #    API implementation
    Given I as a user open navigate to url "http://trello.com" using browser "Chrome"
    #    API implementation
    When Create new board from the template with name "name"
        #    API implementation
    And I close the board with name "name"
    #    API validation should be used
    Then Board with name "name" should be closed
#
  Scenario: Delete the board
      #    API implementation
    Given I as a user open navigate to url "http://trello.com" using browser "Chrome"
    #    API implementation
    When Create new board from the template with name "name"
        #    API implementation
    And I delete the board with name "name"
    #    API validation should be used
    Then Board with name "name" should be deleted
#
  Scenario: Reopen the board after been closed
    Given I as a user open navigate to url "http://trello.com" using browser "Chrome"
    #    API implementation
    When Create new board from the template with name "name"
        #    API implementation
    And I close the board with name "name"
    #    API validation should be used
    And I open the board with name "name"
            #    UI step is implemented
    Then condition that the board with name "name" should be shown is "True"

#
##
  Scenario: Move the bord from one workspace to another
    Given I as a user open navigate to url "http://trello.com" using browser "Chrome"
    #    UI step is implemented
    When Create new board from the template with name "name"
        #    UI step is implemented
    And I move board with name "name" to workspace with name "WorkspaceName"
        #    UI step is implemented
    And I switched to workspace with name "WorkspaceName"
            #    UI step is implemented
    Then condition that the board with name "name" should be shown is "True"

  Scenario: Card cover enablement
    Given I as a user open navigate to url "http://trello.com" using browser "Chrome"
    #    API step is implemented
    When Create new board from the template with name "name"
        #    UI step is implemented
    And I navigate to board settings
    And I set card cover to "True"
    Then card cover should be visible

    Scenario Outline: Commenting permissions
      Given I as a user open navigate to url "http://trello.com" using browser "Chrome"
          #    API step is implemented
      When Create new board from the template with name "name"
      And I navigate to board settings
      And I change commenting permissions to "<Permission value>"
      And I login to system with user that have permission "<UserPermission>"
      And I am have rights to add comments: "<Rights>"
      Examples:
        | Permission value | UserPermission | Rights |
      |Disabled          |Admin           |False   |
      |Disabled          |Member          |False   |
      |Members           |Member          |True    |
      |Workspace member  |Workspace member|True    |
      |Workspace member  |Member          |False   |



