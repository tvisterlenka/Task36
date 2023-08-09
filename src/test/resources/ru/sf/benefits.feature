Feature: Getting information about benefits for IT specialists
  #Positive scenarios
  Scenario: get information about preferential mortgage
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the link Ипотека со ставкой 5%
    Then assert that user sees page "https://digital.gov.ru/ru/events/41700/"
  Scenario: get information about deferment of conscription
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the link Отсрочка от призыва до 27 лет
    Then assert that page "http://www.kremlin.ru/acts/bank/47593" opened
  Scenario: get information about deferment of military service during partial mobilisation
    Given url of QAJA course page: 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'
    When the site is open click the link Отсрочка от частичной мобилизации
    Then assert that page "https://blog.skillfactory.ru/pravda-li-chto-ajtishnikam-polozhena-otsrochka/?_ga=2.55549931.1353646327.1690927797-486266383.1670519486" is opened

