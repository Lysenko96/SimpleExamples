
# Prerequisites

Docker

Maven

# Local execution
How to run:

docker build -t qa-automation-tests .

UI tests - mvn clean test -Dtest=SauceDemoUITest

API tests - mvn clean test -Dtest=SauceDemoAPITest

All tests - mvn clean test -Dtest=SauceDemoTest

# Docker execution

How to build and execute the tests inside Docker.

docker build -t qa-automation-tests .

UI tests - docker run qa-automation-tests mvn clean test -Dtest=SauceDemoUITest

API tests - docker run qa-automation-tests mvn clean test -Dtest=SauceDemoAPITest

All tests - docker run qa-automation-tests mvn clean test -Dtest=SauceDemoTest

# Test approach
Briefly explain:

● Why you chose your locators

● How you handle synchronization

● How you structure UI/API code

● Any assumptions or limitations