Feature: MercadoLibre Product Search

  Scenario: Search for a product and verify details
    Given I am on the MercadoLibre home page
    When I search for "notebook gamer"
    Then I should see the product "Notebook Acer Aspire 3 15.6 Amd Ryzen 7 5700u 16gb De Ram 512gb Ssd Windows 11 Home"
    And I select the product
    And I scroll down the page
    Then I should see the price "1.075.999"
    And I add the product to the cart