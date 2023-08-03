Feature: Registering for a QAJA course
  #Positive scenarios
#1
  Scenario: enter correct data without promo code
    Given url of SkillFactory: 'https://skillfactory.ru/'
    When the site is open click the tag Тестирование
    Then click Тестировщик на Java
    Then click the button Записаться на курс
#    Then set name 'Светлана'
#    And set email 'qajatest6@gmail.com'
#    And set phone number '9100000000'
    Then set name 'Марина'
    And set email 'qajatest@gmail.com'
    And set phone number '9000000000'
    Then click the button Отправить заявку
    Then assert that user got page "https://skillfactory.ru/java-qa-engineer-syllabus-thankyou"
#2
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
    Then assert that user got page "https://skillfactory.ru/java-qa-engineer-syllabus-thankyou"
#3
  Scenario: select another phone code
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
#    Then enter name 'Светлана'
#    And enter email 'qajatest6@gmail.com'
#    And enter phone number '9100000000'
    Then select kyrgyz phone code
    And set phone number '000000000'
    Then assert that the phone number is correct
#4
  Scenario: close application form
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
    Then close the application form

  # Negative scenarios
#5
  Scenario: enter no data
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
    Then click the button Отправить заявку
    Then assert that user got notification
#6
  Scenario: enter incorrect name
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
    Then set name "Марина1"
    Then click the button Отправить заявку
    Then assert that user got set name notification "Укажите, пожалуйста, имя"
#7
  Scenario: enter incorrect email
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
    Then set email 'test@gmail.com.'
    Then click the button Отправить заявку
    Then assert that user got incorrect email notification "Укажите, пожалуйста, корректный email"
#8
  Scenario: enter incorrect phone number
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
    Then set phone number '0000000000'
    Then click the button Отправить заявку
    Then assert that user got incorrect phone number notification "Укажите, пожалуйста, корректный номер телефона"
#9
  Scenario: enter too short phone number
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
    Then set phone number '900000000'
    Then click the button Отправить заявку
    Then assert that user got too short phone number notification "Слишком короткое значение"
#10
  Scenario: enter too long phone number
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
    Then set phone number '9876543210123'
    Then assert that length of phone number is correct
#11
  Scenario: untick the agreement checkbox
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Записаться на курс
    Then untick the agreement box
    Then click the button Отправить заявку
    Then assert that user got error notification

Feature: Getting information about benefits for IT specialists
  #Positive scenarios
#12
  Scenario: get information about preferential mortgage
    Given url of SkillFactory: 'https://skillfactory.ru/'
    When the site is open click the tag Тестирование
    Then click Тестировщик на Java
    Then click the link Ипотека со ставкой 5%
    Then assert that user sees page "https://digital.gov.ru/ru/events/41700/"
#13
  Scenario: get information about deferment of conscription
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the link Отсрочка от призыва до 27 лет
    Then assert that page "http://www.kremlin.ru/acts/bank/47593" opened
#14
  Scenario: get information about deferment of military service during partial mobilisation
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the link Отсрочка от частичной мобилизации
    Then assert that page "https://blog.skillfactory.ru/pravda-li-chto-ajtishnikam-polozhena-otsrochka/?_ga=2.55549931.1353646327.1690927797-486266383.1670519486" is opened

Feature: Following the link to the website for testing during internship
  #Positive scenarios
#16
  Scenario: following the link to Shopiland
    Given url of SkillFactory: 'https://skillfactory.ru/'
    When the site is open click the tag Тестирование
    Then click Тестировщик на Java
    Then click the link Shopiland
    Then assert that user gets page "https://shopiland.ru/"

Feature: Getting QAJA course detailed program
  #Positive scenarios
#17
  Scenario: enter correct data without promo code
    Given url of SkillFactory: 'https://skillfactory.ru/'
    When the site is open click the tag Тестирование
    Then click Тестировщик на Java
#    Then set name 'Светлана'
#    And set email 'qajatest6@gmail.com'
#    And set phone number '9100000000'
    Then enter name 'Марина'
    And enter email 'qajatest@gmail.com'
    And enter phone number '9000000000'
    Then click the button Получить программу
    Then assert that user got page "https://skillfactory.ru/java-qa-engineer-syllabus-thankyou"
#18
  Scenario: enter correct data with promo code
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open enter name 'Марина'
#    Then set name 'Светлана'
#    And set email 'qajatest6@gmail.com'
#    And set phone number '9100000000'
    And enter email 'qajatest@gmail.com'
    And enter phone number '9000000000'
    And enter promo code 'Test'
    Then click the button Получить программу
    Then assert that user got page "https://skillfactory.ru/java-qa-engineer-syllabus-thankyou"
#19
  Scenario: select another phone code
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open select kyrgyz phone code
#    Then enter name 'Светлана'
#    And enter email 'qajatest6@gmail.com'
#    And enter phone number '9100000000'
    And enter phone number '000000000'
    Then assert that this phone number is correct

  # Negative scenarios
#21
  Scenario: enter no data
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Получить программу
    Then assert that user sees notification
#22
  Scenario: enter incorrect name
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open enter name "Марина1"
    Then click the button Получить программу
    Then assert that user sees set name notification "Укажите, пожалуйста, имя"
#23
  Scenario: enter incorrect email
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open enter email 'test@gmail.com.'
    Then click the button Получить программу
    Then assert that user sees incorrect email notification "Укажите, пожалуйста, корректный email"
#24
  Scenario: enter incorrect phone number
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open enter phone number '0000000000'
    Then click the button Получить программу
    Then assert that user sees incorrect phone number notification "Укажите, пожалуйста, корректный номер телефона"
#25
  Scenario: enter too short phone number
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open enter phone number '900000000'
    Then click the button Получить программу
    Then assert that user sees too short phone number notification "Слишком короткое значение"
#26
  Scenario: enter too long phone number
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open enter phone number '9876543210123'
    Then assert that length of this phone number is correct
#27
  Scenario: untick the agreement checkbox
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open untick the agreement box
    Then click the button Получить программу
    Then assert that user sees error notification

Feature: Selecting tariff
  #Positive scenarios
#28
  Scenario: choose tariff Basic
    Given url of SkillFactory: 'https://skillfactory.ru/'
    When the site is open click the tag Тестирование
    Then click Тестировщик на Java
    Then click the button Выбрать тариф Базовый
    Then assert that user sees page1 "Записаться на курс по базовому тарифу"
#29
  Scenario: choose tariff Consult
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Выбрать тариф Оптимальный
    Then assert that user sees page2 "Записаться на курс по расширенному тарифу"
#30
  Scenario: choose tariff Full
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the button Выбрать тариф VIP
    Then assert that user sees page3 "Записаться на курс по индивидуальному тарифу"
