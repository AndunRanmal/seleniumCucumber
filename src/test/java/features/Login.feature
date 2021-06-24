Feature: Login into an Application

#  Scenario Outline: Negative test login validation
#    Given Initialize the browser with chrome
#    And Navigate to "https://www.simplesite.com/pages/service-login.aspx" website
#    When User enters <username> and <password> and click on Login button
#    Then Verify that error message should display
#    And close browsers
#
#    Examples:
#      |username			    |password	|
#      |test99@gmail.com	    |123456		|
#      |test123@gmail.com	|12345      |


#Scenario: Select and Verify 'Show rows' dropdown value to 100
#  Given Initialize the browser with chrome
#  And Navigate to "https://coinmarketcap.com" website
#  When User Select 'Show rows' dropdown value to "50"
#  Then Verify that "50" rows are displayed
#  And close browsers


Scenario: Filter and Verify records by MarketCap and Price
  Given Initialize the browser with chrome
  And Navigate to "https://coinmarketcap.com" website
  When User Select filter records by MarketCap "1,000,000,000" and "10,000,000,000"
  And  set Price "101" and "1000"
  Then Check records displayed on page are correct as per the filter applied
  And close browsers


