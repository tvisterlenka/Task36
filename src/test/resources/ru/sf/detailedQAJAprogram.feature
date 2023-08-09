Feature: Get QAJA course detailed program
  #Positive scenarios
  Scenario: enter correct data without promo code
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open enter name 'Марина'
    And enter email 'qajatest@gmail.com'
    And enter phone number '9000000000'
    Then click the button Получить программу
    Then assert that user goes to page "https://skillfactory.ru/java-qa-engineer-syllabus-thankyou"
  Scenario: enter correct data with promo code
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open enter name 'Марина'
    And enter email 'qajatest@gmail.com'
    And enter phone number '9000000000'
    And enter promo code 'Test'
    Then click the button Получить программу
    Then assert that user goes to page "https://skillfactory.ru/java-qa-engineer-syllabus-thankyou"
  Scenario: select another phone code
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open select kyrgyz phone code
    Then assert that this phone code is correct

  # Negative scenarios
  Scenario: enter no data
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Получить программу
    Then assert that user sees notification
  Scenario: enter incorrect name
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open enter name "Марина1"
    Then click button Получить программу
    Then assert that user sees set name notification "Укажите, пожалуйста, имя"
  Scenario: enter incorrect email
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open enter email 'test@gmail.com.'
    Then click button Получить программу
    Then assert that user sees incorrect email notification "Укажите, пожалуйста, корректный email"
  Scenario: enter incorrect phone number
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open enter phone number '0000000000'
    Then click button Получить программу
    Then assert that user sees incorrect phone number notification "Укажите, пожалуйста, корректный номер телефона"
  Scenario: enter too short phone number
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open enter phone number '900000000'
    Then click button Получить программу
    Then assert that user sees too short phone number notification "Слишком короткое значение"
  Scenario: enter too long phone number
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open enter phone number '9876543210123'
    Then assert that length of this phone number is correct
  Scenario: enter letters into phone number box
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open enter 'letters' into phone number box
    Then assert that length of this phone number is 0
  Scenario: untick the agreement checkbox
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open untick the agreement box
    Then click button Получить программу
    Then assert that user sees error notification
