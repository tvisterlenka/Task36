Feature: Apply for a QAJA course
  #Positive scenarios
  Scenario: enter correct data without promo code
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
    Then set name 'Марина'
    And set email 'qajatest@gmail.com'
    And set phone number '9000000000'
    Then click the button Отправить заявку
    Then assert that user goes to page "https://skillfactory.ru/java-qa-engineer-syllabus-thankyou"
  Scenario: enter correct data with promo code
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
    Then set name 'Марина'
    And set email 'qajatest@gmail.com'
    And set phone number '9000000000'
    And set promo code 'Test'
    Then click the button Отправить заявку
    Then assert that user goes to page "https://skillfactory.ru/java-qa-engineer-syllabus-thankyou"
  Scenario: select another phone code
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
    Then select kyrgyz phone code
    Then assert that the phone code is correct
  Scenario: get the personal data protection regulation
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
    Then click the personal data protection regulation link
    Then assert that user goes to the regulation page "https://skillfactory.ru/position_of_user_personal_data"
  Scenario: close application form
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
    Then close the application form
    Then assert that the application form is closed

    # Negative scenarios
  Scenario: enter no data
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
    Then click the button Отправить заявку
    Then assert that user got notification
  Scenario: enter incorrect name
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
    Then set name "Марина1"
    Then click the button Отправить заявку
    Then assert that user got set name notification "Укажите, пожалуйста, имя"
  Scenario: enter incorrect email
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
    Then set email 'test@gmail.com.'
    Then click the button Отправить заявку
    Then assert that user got incorrect email notification "Укажите, пожалуйста, корректный email"
  Scenario: enter incorrect phone number
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
    Then set phone number '0000000000'
    Then click the button Отправить заявку
    Then assert that user got incorrect phone number notification "Укажите, пожалуйста, корректный номер телефона"
  Scenario: enter too short phone number
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
    Then set phone number '900000000'
    Then click the button Отправить заявку
    Then assert that user got too short phone number notification "Слишком короткое значение"
  Scenario: enter too long phone number
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
    Then set phone number '987654321012345'
    Then assert that length of phone number is correct
  Scenario: enter letters into the phone number box
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
    Then enter 'letters' into the phone box
    Then assert that length of the phone number is 0
  Scenario: untick the agreement checkbox
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
    Then untick the agreement box
    Then click the button Отправить заявку
    Then assert that user got error notification
