package com.demoqa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;

public class PracticeFormWithTestDataTest extends TestBase {

/* static String firstName,
        lastName,
        userEmail;

    @BeforeEach
    void prepareTestData(){
                firstName = "Artem";
                lastName = "Bulaev";
                userEmail = "Fooolll@test.com";
*/
    @Test
    void successfulRegistrationTest() {
/*        String firstName = "Artem",
               lastName = "Bulaev",
               userEmail = "Fooolll@test.com";
 */

       registrationPage.openPage()
                       .setFirstName(firstName)
                       .setLastName(lastName)
                       .setUserEmail(userEmail)
//                       .setGender()
 //                    .setGender("Other")
                       .setUserNumber("8964999000")
                       .setBirthDate("30", "April", "1988")
                       .setSubject("math")
                       .setSubject("bio")
                       .setSubject("ch")
                       .setHobbies("Sports")
                       .setHobbies("Music")
                       .setUploadPicture("img/Test.jpg")
                       .setCurrentAddress("Penza")
                       .setStateInput("NCR")
                       .setCityInput("Delhi")
                       .pushSubmitButton();

       // verifyModalAppears

        registrationPage.verifyRegistrationResultsModalAppears()
                        .verifyResult("Student Name", firstName + " " + lastName)
                        .verifyResult("Student Email", userEmail)
                        .verifyResult("Mobile", "8964999000")
                        .verifyResult("Date of Birth", "30 March,1988")
                        .verifyResult("Subjects", "Maths, Biology, Chemistry")
                        .verifyResult("Hobbies", "Sports, Music")
                        .verifyResult("Picture", "Test.jpg")
                        .verifyResult("Address", "Penza")
                        .verifyResult("State and City", "NCR Delhi")
                        .closeModal();

    }
}
