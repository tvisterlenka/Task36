Feature: Get the regulation on the protection of personal data
  #Positive scenarios
  Scenario: get the personal data protection regulation
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the personal data protection regulation link
    Then assert that user goes to the regulation page "https://skillfactory.ru/position_of_user_personal_data"