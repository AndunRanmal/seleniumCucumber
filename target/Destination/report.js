$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "Login into an Application",
  "description": "",
  "id": "login-into-an-application",
  "keyword": "Feature"
});
formatter.scenario({
  "comments": [
    {
      "line": 3,
      "value": "#  Scenario Outline: Negative test login validation"
    },
    {
      "line": 4,
      "value": "#    Given Initialize the browser with chrome"
    },
    {
      "line": 5,
      "value": "#    And Navigate to \"https://www.simplesite.com/pages/service-login.aspx\" website"
    },
    {
      "line": 6,
      "value": "#    When User enters \u003cusername\u003e and \u003cpassword\u003e and click on Login button"
    },
    {
      "line": 7,
      "value": "#    Then Verify that error message should display"
    },
    {
      "line": 8,
      "value": "#    And close browsers"
    },
    {
      "line": 9,
      "value": "#"
    },
    {
      "line": 10,
      "value": "#    Examples:"
    },
    {
      "line": 11,
      "value": "#      |username\t\t\t    |password\t|"
    },
    {
      "line": 12,
      "value": "#      |test99@gmail.com\t    |123456\t\t|"
    },
    {
      "line": 13,
      "value": "#      |test123@gmail.com\t|12345      |"
    }
  ],
  "line": 16,
  "name": "Select and Verify \u0027Show rows\u0027 dropdown value to 100",
  "description": "",
  "id": "login-into-an-application;select-and-verify-\u0027show-rows\u0027-dropdown-value-to-100",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 17,
  "name": "Initialize the browser with chrome",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "Navigate to \"https://coinmarketcap.com\" website",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "User Select \u0027Show rows\u0027 dropdown value to \"100\"",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "Verify that \"100\" rows are displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "close browsers",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.initializeTheBrowserChrome()"
});
formatter.result({
  "duration": 2044795800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://coinmarketcap.com",
      "offset": 13
    }
  ],
  "location": "StepDefinition.navigateToWebSite(String)"
});
formatter.result({
  "duration": 6622242900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "100",
      "offset": 43
    }
  ],
  "location": "StepDefinition.userSelectRowCountsToBeDisplayed(String)"
});
formatter.result({
  "duration": 538240800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "100",
      "offset": 13
    }
  ],
  "location": "StepDefinition.userVerifyCorrectRowCountIsDisplayed(int)"
});
formatter.result({
  "duration": 46999200,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.close_browsers()"
});
formatter.result({
  "duration": 740866200,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Filter and Verify records by MarketCap and Price",
  "description": "",
  "id": "login-into-an-application;filter-and-verify-records-by-marketcap-and-price",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 25,
  "name": "Initialize the browser with chrome",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "Navigate to \"https://coinmarketcap.com\" website",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "User select Add filters",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "User Select filter records by MarketCap \"1,000,000,000\" and \"10,000,000,000\"",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "set Price \"101\" and \"1000\"",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "Check records displayed on page are correct as per the filter applied",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "close browsers",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.initializeTheBrowserChrome()"
});
formatter.result({
  "duration": 1898957000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://coinmarketcap.com",
      "offset": 13
    }
  ],
  "location": "StepDefinition.navigateToWebSite(String)"
});
formatter.result({
  "duration": 6271322000,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.userSelectAddFilers()"
});
formatter.result({
  "duration": 3541018400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1,000,000,000",
      "offset": 41
    },
    {
      "val": "10,000,000,000",
      "offset": 61
    }
  ],
  "location": "StepDefinition.userSelectFilterMarketCap(String,String)"
});
formatter.result({
  "duration": 516451600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "101",
      "offset": 11
    },
    {
      "val": "1000",
      "offset": 21
    }
  ],
  "location": "StepDefinition.userSelectFilterPrice(String,String)"
});
formatter.result({
  "duration": 331061900,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.check_records_displayed_on_page_are_correct_as_per_the_filter_applied()"
});
formatter.result({
  "duration": 114500,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.close_browsers()"
});
formatter.result({
  "duration": 733298400,
  "status": "passed"
});
formatter.uri("MarketCapAPI.feature");
formatter.feature({
  "line": 1,
  "name": "Market Cap API",
  "description": "",
  "id": "market-cap-api",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Retrieve the ID of bitcoin (BTC), usd tether (USDT), and Ethereum (ETH)",
  "description": "",
  "id": "market-cap-api;retrieve-the-id-of-bitcoin-(btc),-usd-tether-(usdt),-and-ethereum-(eth)",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "Request send to /cryptocurrency/map",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "The status code is 200",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Get the ids of \"\u003cCoinType\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "Convert the currency for a amount of \"50\"",
  "keyword": "And "
});
formatter.examples({
  "line": 8,
  "name": "",
  "description": "",
  "id": "market-cap-api;retrieve-the-id-of-bitcoin-(btc),-usd-tether-(usdt),-and-ethereum-(eth);",
  "rows": [
    {
      "cells": [
        "CoinType"
      ],
      "line": 9,
      "id": "market-cap-api;retrieve-the-id-of-bitcoin-(btc),-usd-tether-(usdt),-and-ethereum-(eth);;1"
    },
    {
      "cells": [
        "Bitcoin"
      ],
      "line": 10,
      "id": "market-cap-api;retrieve-the-id-of-bitcoin-(btc),-usd-tether-(usdt),-and-ethereum-(eth);;2"
    },
    {
      "cells": [
        "Tether"
      ],
      "line": 11,
      "id": "market-cap-api;retrieve-the-id-of-bitcoin-(btc),-usd-tether-(usdt),-and-ethereum-(eth);;3"
    },
    {
      "cells": [
        "Ethereum"
      ],
      "line": 12,
      "id": "market-cap-api;retrieve-the-id-of-bitcoin-(btc),-usd-tether-(usdt),-and-ethereum-(eth);;4"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 10,
  "name": "Retrieve the ID of bitcoin (BTC), usd tether (USDT), and Ethereum (ETH)",
  "description": "",
  "id": "market-cap-api;retrieve-the-id-of-bitcoin-(btc),-usd-tether-(usdt),-and-ethereum-(eth);;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "Request send to /cryptocurrency/map",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "The status code is 200",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Get the ids of \"Bitcoin\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "Convert the currency for a amount of \"50\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitionApis.create_the_request()"
});
formatter.result({
  "duration": 3229039000,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitionApis.request_send_to_cryptocurrency_map()"
});
formatter.result({
  "duration": 2952000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Bitcoin",
      "offset": 16
    }
  ],
  "location": "StepDefinitionApis.all_IDs_should_be_retrieved(String)"
});
formatter.result({
  "duration": 737342500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "50",
      "offset": 38
    }
  ],
  "location": "StepDefinitionApis.convert_the_currency_for_a_amount_of(int)"
});
formatter.result({
  "duration": 619005500,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Retrieve the ID of bitcoin (BTC), usd tether (USDT), and Ethereum (ETH)",
  "description": "",
  "id": "market-cap-api;retrieve-the-id-of-bitcoin-(btc),-usd-tether-(usdt),-and-ethereum-(eth);;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "Request send to /cryptocurrency/map",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "The status code is 200",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Get the ids of \"Tether\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "Convert the currency for a amount of \"50\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitionApis.create_the_request()"
});
formatter.result({
  "duration": 836138600,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitionApis.request_send_to_cryptocurrency_map()"
});
formatter.result({
  "duration": 22400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Tether",
      "offset": 16
    }
  ],
  "location": "StepDefinitionApis.all_IDs_should_be_retrieved(String)"
});
formatter.result({
  "duration": 46796500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "50",
      "offset": 38
    }
  ],
  "location": "StepDefinitionApis.convert_the_currency_for_a_amount_of(int)"
});
formatter.result({
  "duration": 515729500,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Retrieve the ID of bitcoin (BTC), usd tether (USDT), and Ethereum (ETH)",
  "description": "",
  "id": "market-cap-api;retrieve-the-id-of-bitcoin-(btc),-usd-tether-(usdt),-and-ethereum-(eth);;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "Request send to /cryptocurrency/map",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "The status code is 200",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Get the ids of \"Ethereum\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "Convert the currency for a amount of \"50\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitionApis.create_the_request()"
});
formatter.result({
  "duration": 2364964300,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitionApis.request_send_to_cryptocurrency_map()"
});
formatter.result({
  "duration": 21200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ethereum",
      "offset": 16
    }
  ],
  "location": "StepDefinitionApis.all_IDs_should_be_retrieved(String)"
});
formatter.result({
  "duration": 45383800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "50",
      "offset": 38
    }
  ],
  "location": "StepDefinitionApis.convert_the_currency_for_a_amount_of(int)"
});
formatter.result({
  "duration": 1261431800,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Retrieve the information of Ethereum",
  "description": "",
  "id": "market-cap-api;retrieve-the-information-of-ethereum",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "Request send to /cryptocurrency/info with id \"1027\"",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "The status code is 200",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "Check logo url",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "Check technical doc url",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "Check the symbol",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "Check the date added",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "check  for the mineable tag",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "1027",
      "offset": 46
    }
  ],
  "location": "StepDefinitionApis.request_send_to_cryptocurrency_info_with_id(int)"
});
formatter.result({
  "duration": 536767300,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitionApis.request_send_to_cryptocurrency_map()"
});
formatter.result({
  "duration": 108900,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitionApis.check_logo_url()"
});
formatter.result({
  "duration": 165300,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitionApis.check_technical_doc_url()"
});
formatter.result({
  "duration": 1196000,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitionApis.check_the_symbol()"
});
formatter.result({
  "duration": 58800,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitionApis.check_the_date_added()"
});
formatter.result({
  "duration": 76600,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitionApis.check_for_the_mineable_tag()"
});
formatter.result({
  "duration": 145000,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Retrieve the first 10 currencies from the cryptocurrency/info call (ID 1, 2, 3 … 10).",
  "description": "",
  "id": "market-cap-api;retrieve-the-first-10-currencies-from-the-cryptocurrency/info-call-(id-1,-2,-3-…-10).",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 24,
  "name": "Request send to /cryptocurrency/info for first 10 ids",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "The status code is 200",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "Check  for the mineable tag in response cryptocurrencies",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "Print mineable currency names",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitionApis.request_send_to_cryptocurrency_info_for_first_ids()"
});
formatter.result({
  "duration": 529352400,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitionApis.request_send_to_cryptocurrency_map()"
});
formatter.result({
  "duration": 17600,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitionApis.check_for_the_mineable_tag_in_response_cryptocurrencies()"
});
formatter.result({
  "duration": 1208800,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitionApis.print_mineable_currency_names()"
});
formatter.result({
  "duration": 70500,
  "status": "passed"
});
});