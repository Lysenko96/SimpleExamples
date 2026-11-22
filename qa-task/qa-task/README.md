
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

data-test - check data because unique id

span.title - check title if title then this page Products

span.active_option - check sort by value because when request with value can check sort method 

div.inventory_item_name - check product add to cart by product name

● How you handle synchronization

.click(ClickOptions.withTimeout(Duration.ofSeconds(2))) - for click

.shouldHave(size(1), Duration.ofSeconds(5)) - for check size or text or something else

● How you structure UI/API code

different classes

try to avoid duplicating code

● Any assumptions or limitations

text("Products") - check title Products page

size(6) - check quantity product items
