Feature: Following the link to the website for testing during internship
  #Positive scenarios
  Scenario: following the link to Shopiland
    Given url of SkillFactory: 'https://skillfactory.ru/'
    When the site is open click the tag Тестирование
    Then click Тестировщик на Java
    Then click the link Shopiland
    Then assert that user gets page "https://shopiland.ru/"