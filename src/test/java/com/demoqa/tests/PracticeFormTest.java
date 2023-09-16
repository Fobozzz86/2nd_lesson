package com.demoqa.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest extends TestBase {

    @Test
    void PractFormTest() {
       open("https://demoqa.com/automation-practice-form");
       executeJavaScript("$('#fixedban').remove()");
       executeJavaScript("$('footer').remove()");

       $("#firstName").setValue("Artem");
       $("#lastName").setValue("Bulaev");
       $("#userEmail").setValue("Fooolll@test.com");
       $("[for=gender-radio-1]").click();
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
