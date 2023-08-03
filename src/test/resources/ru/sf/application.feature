Feature: Registering for a QAJA course
  #Positive scenarios
  Scenario: enter correct data without promo code
    Given url of SkillFactory: 'https://skillfactory.ru/'
    When the site is open click the tag Тестирование
    Then click Тестировщик на Java
    Then click the button Записаться на курс
    Then set name 'Светлана'
    And set email 'qajatest6@gmail.com'
    And set phone number '9100000000'
#    Then set name 'Марина'
#    And set email 'qajatest@gmail.com'
#    And set phone number '9000000000'
    Then click the button Отправить заявку
#    Then assert that user got page "https://skillfactory.ru/java-qa-engineer-syllabus-thankyou"
  Scenario: enter correct data with promo code
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
#    Then set name 'Светлана'
#    And set email 'qajatest6@gmail.com'
#    And set phone number '9100000000'
    Then set name 'Марина'
    And set email 'qajatest@gmail.com'
    And set phone number '9000000000'
    And set promo code 'Test'
    Then click the button Отправить заявку
#    Then assert that user got page "https://skillfactory.ru/java-qa-engineer-syllabus-thankyou"
  Scenario: select another phone code
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
#    Then enter name 'Светлана'
#    And enter email 'qajatest6@gmail.com'
#    And enter phone number '9100000000'
    Then select kyrgyz phone code
    And set phone number '000000000'
    Then assert that the phone number is correct
  Scenario: close application form
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
    Then close the application form
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
  Scenario: untick the agreement checkbox
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
    Then untick the agreement box
    Then click the button Отправить заявку
    Then assert that user got error notification