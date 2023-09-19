package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormWithPageObjectsTest extends TestBase {
    @Test
    void successfulRegistrationTest() {

       registrationPage.openPage()
                       .setFirstName("Artem")
                       .setLastName("Bulaev")
                       .setUserEmail("Fooolll@test.com")
                       .setGender(/*Male*/)
 //                    .setGender("Other")
                       .setUserNumber("8964999000")
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
                        .verifyResult("Student Name", "Artem Bulaev")
                        .verifyResult("Student Email", "Fooolll@test.com")
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
