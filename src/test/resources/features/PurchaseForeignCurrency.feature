Feature:    Purchase Foreign Currency


  Scenario:    Available	currencies
    Given the user is logged in
    Then select "pay_bills_link"
    Then go to "Purchase Foreign Currency" link in current page
    Then    following	currencies should	be	available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Singapore (dollar)    |


  Scenario:	Error	message for	not	selecting	currency
    Given the user is logged in
    Then select "pay_bills_link"
    Then go to "Purchase Foreign Currency" link in current page
    When user tries to calculate cost without selecting a currency
    Then error message should be displayed
  @wip
  Scenario:	Error	message for	not	entering	value
    Given the user is logged in
    Then select "pay_bills_link"
    Then go to "Purchase Foreign Currency" link in current page
    When user tries to calculate cost without entering a value
    Then error message should be displayed

