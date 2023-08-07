Feature: See success stories
  #Positive scenarios
  Scenario: click success stories button
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Все истории успеха в блоге
    Then assert that user sees blog page 'https://blog.skillfactory.ru/lichnyj-opyt/'