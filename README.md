
=================

- Main goal - validation of CRUD process of board and all objects that could be part of boards on http://trello.com
- Manual Tests implemented:
  - CRUD for Boards - src/test/java/features/Board.feature in gherkin format
  - CRUD for Cards - src/test/java/features/Card.feature in checklist form
  - CRUD for Lists - src/test/java/features/List.feature in checklist form
- Automation example (API and UI implementation) - src/test/java/features/AutomatedCRUD.feature
- Each automation tests includes After part that clean up any objects that was created during test run

Prerequisites
-------------

In order to run browser tests, Selenium will need to be able to drive a browser installed to your system.
- Firefox v.111.0 and/or 
- Chrome v.111, 
- bin directory of the Maven should be added to the PATH environment variable.

Clone the repo:
-------------
git clone -b master https://github.com/knabnl-incubator/dmytro-moskalenko-knab.git


Run test
-------------
mvn clean test

via IDE: src/test/java/step_definitions/MyStepdefs.java as a JUnit
         src/test/java/features/AutomatedCRUD.feature as a Cucumber (no reporting will be generated)
		 
Location and marking
=================
- Tests are located in src/test/java/feature path
- Manual tests marked with @NotAutomated tag
- Automated tests is located in AutomatedCRUD.feature file and marked with @Automated tag, tests are in gherkin format
- API implementation is marked with @API tag
- UI implementation is marked with @UI tag

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






