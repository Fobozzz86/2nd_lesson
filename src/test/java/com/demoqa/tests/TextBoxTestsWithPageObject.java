package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTestsWithPageObject extends TestBase {

    @Test
    void successFillTest() {
        registrationPage.openPage();

        $("#userName").setValue("Artem");

        registrationPage.setUserEmail("Fooolll@test.com")
                        .setCurrentAddress("Penza");
        $("#permanentAddress").setValue("Russia");
        registrationPage.pushSubmitButton();;

        $("#output").shouldHave(text("Artem"), text("Fooolll@test.com"),
                text("Pnz"), text("Russia"));

      //  $("#output #name").shouldHave(text("Artem"));
    }
}
