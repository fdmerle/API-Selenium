Tasks
=================

Main goal - validation of CRUD process of board and all objects that could be part of boards on http://trello.com
Tests implemented:
CRUD for Boards - src/test/java/features/Board.feature
CRUD for Cards - src/test/java/features/Card.feature
CRUD for Lists - src/test/java/features/List.feature

Location and marking
=================
- Tests are located in src/test/java/feature path
- Manual tests marked with @NotAutomated tag
- Automated tests is located in AutomatedCRUD.feature file and marked with @Automated tag

Environment details
=================
- Browser supported: Chrome v.111, Firefox v.111.0
- UI tests implemented with Selenium 4.8.1
- API tests are implemented with Rest Assured 5.3.0
- API documentation is taken https://developer.atlassian.com/cloud/trello/rest/api-group-actions/
- Test plan could be found in Test_Plan/TestPlan.pdf



Reporting
=================
- Report is generated with "pretty", "html:target/Destination.html"
- Test run report could be found in target/Destination.html




Prerequisites
-------------

In order to run browser tests, Selenium will need to be able to drive a browser installed to your system.
Firefox v.111.0 and/or Chrome v.111 have to be installed

Clone the repo:
-------------
git clone https://github.com/fdmerle/API-Selenium.git


Run test
-------------

mvn clean test

via IDE: src/test/java/step_definitions/MyStepdefs.java as a JUnit
         src/test/java/features/AutomatedCRUD.feature as a Cucumber (no reporting will be generated)

