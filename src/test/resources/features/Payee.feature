Feature:    Add	new	payee	under	pay	bills


  Scenario:    Add	a	new	payee
    Given the user is logged in
    Then select "pay_bills_link"
    Then go to "Add New Payee" link in current page
    Given Add New Payee tab
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |
    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed


