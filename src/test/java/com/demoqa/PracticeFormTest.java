package com.demoqa;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest extends TestBase {

    @Test
    void PractFormTest() {
       open("https://demoqa.com/automation-practice-form");
       $("#firstName").setValue("Artem");
       $("#lastName").setValue("Bulaev");
       $("#userEmail").setValue("Fooolll@test.com");
       $("[for=gender-radio-1]").click();
       $("#userNumber").setValue("89649990000");
       $("#dateOfBirthInput").sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a")); // ввод даты в календарь
       $("#dateOfBirthInput").sendKeys("1986 Apr 07");
       $("#dateOfBirthInput").sendKeys(Keys.ENTER);
       $("#subjectsInput").setValue("Maths").sendKeys(Keys.ENTER);
       $("#subjectsInput").setValue("bio").sendKeys(Keys.ENTER);
       $("#subjectsInput").setValue("ch").sendKeys(Keys.ENTER);
       $("[for=hobbies-checkbox-1]").click();
       $("[for=hobbies-checkbox-2]").click();
       $("[for=hobbies-checkbox-3]").click();
  //   $(".form-file .form-file-label").click();  // открытие на загрузку файла
       $("#uploadPicture").sendKeys("d:/Lanit/Test.jpg"); // загрузить файл
       $("#currentAddress").setValue("Penza");
       $("#react-select-3-input").setValue("NCR").sendKeys(Keys.ENTER);
  //     $(".indicatorContainer").setValue("NCR").sendKeys(Keys.ENTER);
       $("#react-select-4-input").setValue("Delhi").sendKeys(Keys.ENTER);
       $("#submit").click();
       $(".table-hover").shouldHave(text("Artem Bulaev"), text("Fooolll@test.com"),
               text("Male"), text("8964999000"));
       $("[type=button]").sendKeys(Keys.ENTER);

    }
}
