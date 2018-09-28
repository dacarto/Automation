$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("dataFile/Feature/SearchEbay.feature");
formatter.feature({
  "line": 1,
  "name": "Search on Ebay",
  "description": "Enter to Ebay\r\nSearch for shoes\r\nSelect brand Adidas\r\nSelect size 10\r\nPrint the number of results\r\nOrder by price ascendant\r\nAssert the order taking the first 5 results\r\nTake the first 5 products with their prices and print them in console.\r\nOrder and print the products by name (ascendant)\r\nOrder and print the products by price in descendant mode",
  "id": "search-on-ebay",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 14,
  "name": "Search Puma Shoes",
  "description": "",
  "id": "search-on-ebay;search-puma-shoes",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 13,
      "name": "@TEST"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "Navigate to Ebay Web Site",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "I enter \u003csearch_data\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "I click the search",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "I select the brand Puma",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I select the size 10",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "Print Results of the search",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "I input price \u003cpricemin\u003e to \u003cpricemax\u003e asc",
  "keyword": "Then "
});
formatter.step({
  "line": 22,
  "name": "I click order for price",
  "keyword": "And "
});
formatter.examples({
  "line": 25,
  "name": "",
  "description": "",
  "id": "search-on-ebay;search-puma-shoes;",
  "rows": [
    {
      "cells": [
        "search_data",
        "pricemin",
        "pricemax"
      ],
      "line": 26,
      "id": "search-on-ebay;search-puma-shoes;;1"
    },
    {
      "cells": [
        "zapatillas",
        "0.00",
        "2000.00"
      ],
      "line": 27,
      "id": "search-on-ebay;search-puma-shoes;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 27,
  "name": "Search Puma Shoes",
  "description": "",
  "id": "search-on-ebay;search-puma-shoes;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 13,
      "name": "@TEST"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "Navigate to Ebay Web Site",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "I enter zapatillas",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "I click the search",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "I select the brand Puma",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I select the size 10",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "Print Results of the search",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "I input price 0.00 to 2000.00 asc",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 22,
  "name": "I click order for price",
  "keyword": "And "
});
formatter.match({
  "location": "EbaySteps.navigate_to_Ebay_Web_Site()"
});
formatter.result({
  "duration": 50241255607,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": " zapatillas",
      "offset": 7
    }
  ],
  "location": "EbaySteps.i_enter(String)"
});
formatter.result({
  "duration": 3064118347,
  "status": "passed"
});
formatter.match({
  "location": "EbaySteps.i_click_the_search()"
});
formatter.result({
  "duration": 2210359242,
  "status": "passed"
});
formatter.match({
  "location": "EbaySteps.i_selec_the_brand_puma()"
});
formatter.result({
  "duration": 38702230955,
  "status": "passed"
});
formatter.match({
  "location": "EbaySteps.i_select_the_size_10()"
});
formatter.result({
  "duration": 18686163253,
  "status": "passed"
});
formatter.match({
  "location": "EbaySteps.print_Results_of_the_search()"
});
formatter.result({
  "duration": 47084968131,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0.00",
      "offset": 14
    },
    {
      "val": "2000.00",
      "offset": 22
    }
  ],
  "location": "EbaySteps.i_enter_price_to_asc(String,String)"
});
formatter.result({
  "duration": 4978342962,
  "status": "passed"
});
formatter.match({
  "location": "EbaySteps.i_click_order_for_price()"
});
formatter.result({
  "duration": 8452847062,
  "status": "passed"
});
formatter.after({
  "duration": 1427825046,
  "status": "passed"
});
});