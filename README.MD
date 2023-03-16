Tasks
=================

Main goal - validation of CRUD process of board on http://trello.com
Tests implemented:
- Tests are located in src/test/java/feature path
- Manual tests marked with @NotAutomated tag
- Automated tests is located in AutomatedCRUD.feature file and marked with @Automated tag
- Browser supported: Chrome v.111, Firefox v.111.0


Prerequisites
-------------

In order to run browser tests, Selenium will need to be able to drive a browser installed to your system.
Firefox v.111.0 and/or Chrome v.111 have to be installed

Clone the repo:
-------------
git clone https://gitlab.com/fdmerle/newselenium


Run test
-------------

mvn clean test

via IDE: src/test/java/suite/PositiveScenarioTests.java

via IDE: src/test/java/suite/ErrorValidationTests.java