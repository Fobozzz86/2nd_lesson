package com.demoqa.tests;

import org.junit.jupiter.api.Test;

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
                       .setUserNumber("89649990000")
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


       $(".table-hover").shouldHave(text("Artem Bulaev"), text("Fooolll@test.com"),
               text("Male"), text("8964999000"));
//       $("#closeLargeModal").scrollIntoView(true).click(); // прокрутка для видимости кнопки

    }
}
