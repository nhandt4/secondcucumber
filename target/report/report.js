$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/secondcucumber/muahangtiki.feature");
formatter.feature({
  "name": "User search and buy an item successfully on the TIKI page",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "User search and buy an item successfully on the TIKI page",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "The Tiki Homepage is displayed on browser",
  "keyword": "Given "
});
formatter.match({
  "location": "secondcucumber.MuaHangTiKi.theTikiHomepageIsDisplayedOnBrowser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User attempt to search keyword \"TV SAMSUNG\"",
  "keyword": "When "
});
formatter.match({
  "location": "secondcucumber.MuaHangTiKi.userAttemptToSearchKeyword(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User select a desired item in the search result list",
  "keyword": "And "
});
formatter.match({
  "location": "secondcucumber.MuaHangTiKi.userSelectADesiredItemInTheSearchResultList()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User attempt buy this item with quantity \u003d 1",
  "keyword": "And "
});
formatter.match({
  "location": "secondcucumber.MuaHangTiKi.userAttemptBuyThisItemWithQuantity(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User go to the cart page to check the added item",
  "keyword": "And "
});
formatter.match({
  "location": "secondcucumber.MuaHangTiKi.userGoToTheCartPageToCheckTheAddedItem()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The system displayed the added item in the cart with correct name and price, quantity",
  "keyword": "Then "
});
formatter.match({
  "location": "secondcucumber.MuaHangTiKi.theSystemDisplayedTheAddedItemInTheCartWithCorrectNameAndPriceQuantity()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});