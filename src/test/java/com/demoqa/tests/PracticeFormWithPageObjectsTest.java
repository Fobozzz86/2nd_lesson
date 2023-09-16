package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormWithPageObjectsTest extends TestBase {
    @Test
    void successfulRegistrationTest() {

       registrationPage.openPage()
                       .setFirstName("Artem")
                       .setLastName("Bulaev")
                       .setUserEmail("Fooolll@test.com")
                       .setGender(/*Male*/);
 //                    .setGender("Other")



       $("#userNumber").setValue("89649990000");
       $("[id=dateOfBirthInput]").click();
       $(".react-datepicker__month-select").selectOption("March");
       $(".react-datepicker__year-select").selectOption("1990");
       $(".react-datepicker__day--010").click();
       $("#subjectsInput").setValue("Maths").sendKeys(Keys.ENTER);
       $("#subjectsInput").setValue("bio").sendKeys(Keys.ENTER);
       $("#subjectsInput").setValue("ch").sendKeys(Keys.ENTER);
       $("#hobbiesWrapper").$(byText("Sports")).click();
       $("#hobbiesWrapper").$(byText("Music")).click();
       $("#uploadPicture").uploadFromClasspath("img/Test.jpg");
       $("#currentAddress").setValue("Penza");
       $("#state").click();
       $("#stateCity-wrapper").$(byText("NCR")).click();
       $("#city").click();
       $("#stateCity-wrapper").$(byText("Delhi")).click();
       $("#submit").click();

       $(".table-hover").shouldHave(text("Artem Bulaev"), text("Fooolll@test.com"),
               text("Male"), text("8964999000"));
       $("#closeLargeModal").scrollIntoView(true).click(); // прокрутка для видимости кнопки

    }
}
