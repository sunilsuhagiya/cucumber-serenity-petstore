Feature: Pet store io user functionality
  As a user I want to test pet store functionality

  Scenario Outline: CRUD Test
    When I create user with id "<id>" username "<username>" firstname"<firstname>" lastname"<lastname>" email"<email>" password"<password>" phone"<phone>" userstatus"<userstatus>"
    And I verify user created
    And I update user with id "<id>" username "<username>" firstname"<firstname>" lastname"<lastname>" email"<email>" password"<password>" phone"<phone>" userstatus"<userstatus>"
    And I check user is updated successfully
    And I delete user
    Then I verify that user is deleted successfully
    Examples:
      | id | username | firstname | lastname | email           | password  | phone     | userstatus |
      | 55 | Ben45    | stokes    | root     | ben12@yahoo.com | stokes654 | 987654231 | 1          |