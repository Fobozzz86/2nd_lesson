package com.demoqa;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest extends TestBase {

    @Test
    void vvoddataTest() {
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
   //    $("#uploadPicture").click();
    //   $(".form-control-file").click();
     //  setValue("d:\Lanit\Test.jpg").sendKeys(Keys.ENTER);

       $("#currentAddress").setValue("Penza");

       // d:\Lanit\Test.jpg

    }
}
