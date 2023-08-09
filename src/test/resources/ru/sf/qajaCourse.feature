Feature: Get QAJA course detailed program
  #Positive scenarios
  Scenario: enter correct data without promo code
    Given url of SkillFactory: 'https://skillfactory.ru/'
    When the site is open click the tag Тестирование
    Then click Тестировщик на Java
    Then assert that user got QAJA course page