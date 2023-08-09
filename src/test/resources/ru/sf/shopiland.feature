Feature: Following the link to the website for testing during internship
  #Positive scenarios
  Scenario: following the link to Shopiland
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the link Shopiland
    Then assert that user gets page "https://shopiland.ru/"