# Hãy sử dụng Cucumber viết script automation cho việc tìm kiếm sản phẩm phẩm
# và mua một sản phẩm bất kỳ trên danh sách tìm được của Tiki.vn
Feature: User search and buy an item successfully on the TIKI page
  Scenario: User search and buy an item successfully on the TIKI page
    Given The Tiki Homepage is displayed on browser
    When User attempt to search keyword "TV SAMSUNG"
    And User select a desired item in the search result list
    And User attempt buy this item with quantity = 1
    And User go to the cart page to check the added item
    Then The system displayed the added item in the cart with correct name and price, quantity