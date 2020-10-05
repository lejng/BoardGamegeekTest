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
      And I save game id by key "GameId" from Boardgame Details Page
      And I save most voted language dependence by key "MostVotedUi" from Boardgame Details Page
      And I open open language dependence vote result on Boardgame Details Page
      And I save language dependence vote result by key "VoteResultUi" from Boardgame Details Page