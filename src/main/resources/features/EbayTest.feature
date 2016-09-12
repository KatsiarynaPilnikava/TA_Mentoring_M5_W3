Feature: Ebay Add to Card test


@Test 
Scenario: Add two products to card and check if it was added successfully
  Given 'google_chrome' browser is created successfully and 'http://ebay.com' is open
  And add '231887216155' product to card
  And product is added successfully
  And add '261036840898' product to card
  When product is added successfully
  Then check that price was calculated successfully
  And basket is cleared

@Test
Scenario Outline: Add single product to card and check if it was added successfully
  Given 'google_chrome' browser is created successfully and 'http://ebay.com' is open
  And add '<productId>' product to card
  When product is added successfully
  Then check that price was calculated successfully
  And basket is cleared

   Examples:
  | productId     |
  | 231887216155  |
  | 261036840898  |

@Test
Scenario Outline: Add two products to card and check if price will be calculated successfully after deleting
  Given 'google_chrome' browser is created successfully and 'http://ebay.com' is open
  And add '<firstProductId>' product to card
  And product is added successfully
  And basket is cleared
  And add '<secondProductId>' product to card
  When product is added successfully
  Then check that price was calculated successfully
  And basket is cleared

  Examples:
  | firstProductId  | secondProductId |
  | 231887216155    | 261036840898    |
  | 261036840898    | 231887216155    |

  @Test
Scenario Outline: Add two products to card and check if price will be calculated successfully after deleting the first one
  Given 'google_chrome' browser is created successfully and 'http://ebay.com' is open
  And add '<firstProductId>' product to card
  And product is added successfully
  And add '<secondProductId>' product to card
  When product is added successfully
  And '<firstProductId>' product is deleted
  Then check that price was calculated successfully
  And basket is cleared

  Examples:
    | firstProductId  | secondProductId |
    | 231887216155    | 261036840898    |
    | 261036840898    | 231887216155    |

  @Test
  Scenario Outline: Add two products to card and check if price will be calculated successfully after deleting the second one
    Given 'google_chrome' browser is created successfully and 'http://ebay.com' is open
    And add '<firstProductId>' product to card
    And product is added successfully
    And add '<secondProductId>' product to card
    When product is added successfully
    And '<firstProductId>' product is deleted
    Then check that price was calculated successfully
    And basket is cleared

    Examples:
      | firstProductId  | secondProductId |
      | 231887216155    | 261036840898    |
      | 261036840898    | 231887216155    |