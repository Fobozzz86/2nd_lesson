package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.demoqa.utils.RandomUtilsFakerTest.*;

public class PracticeFormWithRandomFakerTest extends TestBase {

    String firstName = generateFirstName(),
           lastName = generateLastName(),
           userEmail = generateEmail(),
           userGender = generateGender(),
           userNumber = generatePhoneNumber(),
           userDay = generateRandomDay(),
           userMonth = generateRandomMonth(),
           userYear = generateRandomYear(),
           userSubjects = generateSubjects(),
           userHobbies = generateHobbies(),
           userPicture = generatePicture(),
           userAddress = generateAddress(),
           userState = generateState(),
           userCity = generateCity(userState);
    @Test
    void successfulRegistrationTest() {

       registrationPage.openPage()
                       .setFirstName(firstName)
                       .setLastName(lastName)
                       .setUserEmail(userEmail)
                       .setGender(userGender)
                       .setUserNumber(userNumber)
                       .setBirthDate(userDay, userMonth, userYear)
                       .setSubject(userSubjects)
                       .setHobbies(userHobbies)
                       .setUploadPicture(userPicture)
                       .setCurrentAddress(userAddress)
                       .setStateInput(userState)
                       .setCityInput(userCity)
                       .pushSubmitButton();

       // verifyModalAppears

        registrationPage.verifyRegistrationResultsModalAppears()
                        .verifyResult("Student Name", firstName + " " + lastName)
                        .verifyResult("Student Email", userEmail)
                        .verifyResult("Gender", userGender)
                        .verifyResult("Mobile", userNumber)
                        .verifyResult("Date of Birth", userDay + " " + userMonth + "," + userYear)
                        .verifyResult("Subjects", userSubjects)
                        .verifyResult("Hobbies", userHobbies)
                        .verifyResult("Picture", userPicture.substring(4))
                        .verifyResult("Address", userAddress)
                        .verifyResult("State and City", userState + " " + userCity)
                        .closeModal();

    }
}
