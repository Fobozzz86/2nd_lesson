package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.demoqa.utils.RandomUtils.*;

public class PracticeFormWithRandomUtilsTest extends TestBase {
    @Test
    void successfulRegistrationTest() {
       String firstName = getRandomString(10),
              lastName = getRandomString(10),
              userEmail = getRandomEmail(),
//            userNumber = "+7" + getRandomInt(111111111, 999999999);
              userNumber = getRandomPhone(),
//            userNumber = "7" + (getRandomInt(111, 999)) + (getRandomInt(1111111, 9999999));
              userGender = getRandomGender();

       registrationPage.openPage()
                       .setFirstName(firstName)
                       .setLastName(lastName)
                       .setUserEmail(userEmail)
                       .setGender(userGender)
 //                    .setGender("Other")
                       .setUserNumber(userNumber)
                       .setBirthDate("30", "April", "1988")
                       .setSubject("math")
                       .setSubject("bio")
                       .setSubject("ch")
                       .setHobbies("Sports")
                       .setHobbies("Music")
                       .setUploadPicture()
                       .setCurrentAddress("Penza")
                       .setStateInput("NCR")
                       .setCityInput("Delhi")
                       .pushSubmitButton();

       // verifyModalAppears

        registrationPage.verifyRegistrationResultsModalAppears()
                        .verifyResult("Student Name", firstName + " " + lastName)
                        .verifyResult("Student Email", userEmail)
                        .verifyResult("Mobile", userNumber)
                        .verifyResult("Date of Birth", "30 March,1988")
                        .verifyResult("Subjects", "Maths, Biology, Chemistry")
                        .verifyResult("Hobbies", "Sports, Music")
                        .verifyResult("Picture", "Test.jpg")
                        .verifyResult("Address", "Penza")
                        .verifyResult("State and City", "NCR Delhi")
                        .closeModal();

    }
}
