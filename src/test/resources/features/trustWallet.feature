 @TrustSmoke @ui
 Feature: User Interaction with TrustWallet Chat

  Background:
    Given the user is on the TrustWallet chat interface and the user clicks on the <Something Else> button
    When the user asks a question and receives a response with a link

  Scenario: User Asks a Question and Receives a Valid Article Link
    Then the link provided should not be blank

 @ThumbsUp&Down @ui
 Scenario: User Rates the Response
  When the user clicks the thumbs-up icon
  Then the thumbs-up icon should change color to green
  And the thumbs-down icon should remain unchanged

  When the user clicks the thumbs-down icon
  Then the thumbs-down icon should change color to red
  And the thumbs-up icon should remain unchanged

 @CheckResponseTime @ui
  Scenario: User Checks Response Time
    When the user records the time the question was sent
    And records the time the response was received
    Then the time difference between sending and receiving should be calculated
    And the calculated time difference should be within an acceptable threshold

 @RefreshButton @ui
  Scenario: User Refreshes the Chat
    When the user clicks the refresh button
    Then the chat interface should reload and clear the previous response
    Then check for the presence of the default message

 @EmojiButton @ui
  Scenario: User adds an emoji
    When the user clicks the emoji button
    Then an emoji selection dialog should appear

 @talkAgentNeg @ui
  Scenario: user is trying to interact with the chatbot's agent
    When the user ask to talk with agent and use wrong email
    Then the chatbot will ask for correct email

 @talkAgentPos @ui
  Scenario: user is trying to interact with the chatbot's agent
    When the user ask to talk with agent and use correct email
    And the chatbot will ask to select the issue and provide More, Other option buttons
    And user clicks Other option
    And user selects sub-category issue and provide more detail
    Then user select yes or no and the conversation will end



