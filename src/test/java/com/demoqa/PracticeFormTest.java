package com.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest extends TestBase {

    @Test
    void vvoddataTest() {
        open("/automation-practice-form");
        $("[placeholder=First Name]").setValue("Artem");
        $("[placeholder=Last Name]").setValue("Bulaev");
        $("#userEmail").setValue("Fooolll@test.com");
     //   $("#currentAddress").setValue("Penza");
     //   $("#permanentAddress").setValue("Russia");


    }
}
