Feature: To check the Apollo Pharmacy  website

  Background: 
    Given User is on homepage

  @Sorting
  Scenario: Sort doctors by years of experience
    When user navigate Covid Consultation option
    And user click on the sorting option
    And select the Years of Experience option from dropdown
    Then the list of doctors should be displayed according to the Years of Experience

  @SearchingDoctors
  Scenario: Search doctors by name to find the right medical professional for my needs
    When user navigates Covid Consultation option
    And user clicks on doctor
    Then it  should show the detailed information about the selected doctor

  @FilterDoctors
  Scenario: Filter doctors by availability
    When user navigate Covid Consultation page
    And user click on Filter option
    And user select the Availability section
    And user click the apply filters
    Then user should see the list of doctors matching the search criteria

  @BookingDigitalConsult
  Scenario Outline: Booking a digital consultation of doctors
    When user on the COVID consultation page
    And scroll down to digital cosultaion
    And click on book digital consultation
    And select a date for the appointment
    And choose a slot for the appointment
    Then proceed to payment
    

  @SearchSpecialists
  Scenario: Search doctors by specialists to find the right medical professional for my needs
    When user navigates Covid Consultation button
    And user clicks on doctors
    And user enter the name of the specialists "Dr. Ekta Pandey"
    Then it should displays the detailed information about the selected doctor
    
   @ApolloDoctors
   #@invalid
   Scenario: Access Apollo Doctors and View Only Apollo Doctor Details
   	When the user clicks on Covid Consultation
    And the user clicks on Apollo Doctors
    #And the user clicks on the Apollo Doctors badge
    Then the user should be able to view detailed information for only the apollo doctors
