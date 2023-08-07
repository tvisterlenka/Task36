Feature: Get information about promotion
  #Positive scenarios
  Scenario: get promotion rules
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the link 'правилах акции'
    Then assert that user got page 'https://skillfactory.ru/refund-money'