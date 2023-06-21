package com.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase {

    @Test
    void successfullFillTest() {
        open("/text-box");
 //     $("[id=userName]").setValue("Artem");
        $("#userName").setValue("Artem"); // - # это сокращение для id
        $("#userEmail").setValue("Fooolll@test.com");
        $("#currentAddress").setValue("Penza");
        $("#permanentAddress").setValue("Russia");
        $("#submit").click();

        $("#output").shouldHave(text("Artem"), text("Fooolll@test.com"),
                text("Penza"), text("Russia"));

      //  $("#output #name").shouldHave(text("Artem"));
    }
}
