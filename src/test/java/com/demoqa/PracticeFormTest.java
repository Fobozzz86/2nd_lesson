package com.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest extends TestBase {

    @Test
    void vvoddataTest() {
        open("https://demoqa.com/automation-practice-form");
     //  $("[placeholder=First Name]").setValue("Artem");
     //   $(".form-control").shouldHave(text("First Name")).setValue("Artem");
     //   $("[placeholder=Last Name]").setValue("Bulaev");
        $("#userEmail").setValue("Fooolll@test.com");
    //    $("[name=gender] [value=other]").click();
        $("#userNumber").setValue("89649990000");
        $("#currentAddress").setValue("Penza");
        $("#subjectsWrapper").$("#subjectsContainer").setValue("Russia");


    }
}
