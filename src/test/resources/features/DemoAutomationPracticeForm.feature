@DemoAutomationPracticeForm
Feature: Demo Automation Practice Form

  @Scenario01
  Scenario: Fill Demo Automation Practice Form
    Given the user is on the Demo Automation Practice Form page
    When the user fills the Automation Practice Form
      | First name | Last name | Gender | Years of Experience | Date | Profession        | Automation Tools        | Continent | Selenium Commands   |
      | Rafael     | Matoso    | Male   | 6                   |      | Automation Tester | UTF, Selenium Webdriver | Europe     | Navigation Commands |
    And submits the data
    Then the user will be registered