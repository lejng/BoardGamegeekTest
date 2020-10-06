Feature: Mix Board Gamegeek Tests Feature

  Scenario: Check poll results about Language Dependence
    When I login to portal with following credentials:
      |UserName  |testUser10042020|
      |Password  |testpassword    |
    Then The user is logged to portal
    When I select "Collection" from user menu on Header Component
    Then The User Collection Page opened
    When I open random game from User Collection Page
    Then The Boardgame Details Page opened
      And I save most voted language dependence by key "MostVotedUi" from Boardgame Details Page
      And I open language dependence vote result from Boardgame Details Page
    Then The language dependence vote result from dialog on Boardgame Details Page must be equals with vote result from API
      And The most voted language question from dialog on Boardgame Details Page must be equals question saved by key "MostVotedUi"
