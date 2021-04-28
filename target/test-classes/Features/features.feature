Feature: Upsill SignUp
  User Signs Up to Upsill page and sends a Mail
  
  Scenario: Upskill SignUp Page
    Given User is at the Upsill SignUp page
    When User enters FirstName with <FirstName>
    And User enters LastName with <LastName>
    And User enters Email with <Email>
    And User enters Username
    And User enters Password with <Password>
    And User confirms Password with <Password>
    And User enters Phone with <Phone>
    And User clicks Register button
    And User Validates Message with Dear <FirstName>,<LastName>
    And User Validates Email with <Email>
    Then User is at mail page
    Then User clicks Compose Mail
    And User enters Send to field with <SendTo>
    And User enters Subject with <Subject>
     And User enters Message Body with <Message>
    And User send the mail
     And User Validates the sent message
    
    Examples: 
      | FirstName  | LastName | Email  | Password | Phone | SendTo  | Subject | Message  |
      | Shravya  | Rai | shravya@mail.com  | Shravya | 9876543211 | virat |  Mail To Test | Hi, Mail To Test  |
     	| Alphonsa  | Lincy | Lincy3@mail.com  | Lincy3 | 9876543212 | virat |  Mail To Test | Hi, Mail To Test  |
 