Feature: Sample API Test

  Background:
    * url env.baseUrl
    * def commonFunctions = common

  Scenario: Get user details
    When method GET
    Then status 200
    * print response

  Scenario: Get single product details
    Given path env.entityId
    When method GET
    Then status 400

  Scenario: Get single product
    Given path '5'
    When method GET
    Then status 200
    * print response