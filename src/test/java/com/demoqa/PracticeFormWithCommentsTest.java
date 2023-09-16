package com.demoqa;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormWithCommentsTest extends TestBase {

    @Test
    void PractFormTest() {
        open("https://demoqa.com/automation-practice-form");
        //    Тест может упасть из-за всплывающих баннеров (ошибка element click intercepted), можно добавить
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Artem");
        $("#lastName").setValue("Bulaev");
        $("#userEmail").setValue("Fooolll@test.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("89649990000");
        $("#dateOfBirthInput").sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a")); // ввод даты в календарь
        $("#dateOfBirthInput").sendKeys("1986 Apr 07");
        $("#dateOfBirthInput").sendKeys(Keys.ENTER);

 /*      // второй вариант выбора даты
       $("[id=dateOfBirthInput]").click();
       $(".react-datepicker__month-select").selectOption("March");
 //      $(".react-datepicker__month-select").selectOptionByValue("5"); //выбор по Value
       $(".react-datepicker__year-select").selectOption("1990");
       $(".react-datepicker__day--010").click();
*/
        $("#subjectsInput").setValue("Maths").sendKeys(Keys.ENTER);
        $("#subjectsInput").setValue("bio").sendKeys(Keys.ENTER);
        $("#subjectsInput").setValue("ch").sendKeys(Keys.ENTER);
        //    $("[for=hobbies-checkbox-1]").click();
        $("#hobbies-checkbox-1").parent().click(); // поднятие на элемент вверх от input'a и клик по нему
        $("[for=hobbies-checkbox-2]").click();
        $("[for=hobbies-checkbox-3]").click();

        //   $("#uploadPicture").sendKeys("d:/Lanit/Test.jpg"); // загрузить файл_0
        //   $("#uploadPicture").uploadFromClasspath("Test.jpg"); // загрузить файл_1 *оптимальный код*

        //   String filePath = "Test.jpg";
        //   $("#uploadPicture").uploadFromClasspath(filePath); // загрузить файл_2 *оптимальный код*

        //    File file = new File("C:\\Users\\foboz\\IdeaProjects\\2nd_lesson\\src\\test\\resources\\Test.jpg"); // загрузить файл_3
        //    при  таком написании Тест запустится только на машине где он создан

        File file = new File("src/test/resources/Test.jpg");
        $("#uploadPicture").uploadFile(file); // загрузить файл_4 *оптимальный код*

        $("#currentAddress").setValue("Penza");
        $("#react-select-3-input").setValue("NCR").sendKeys(Keys.ENTER);
        $("#react-select-4-input").setValue("Delhi").sendKeys(Keys.ENTER);
        $("#submit").click();

        $(".table-hover").shouldHave(text("Artem Bulaev"), text("Fooolll@test.com"),
                text("Male"), text("8964999000"));
        $("#closeLargeModal").scrollIntoView(true).click(); // прокрутка для видимости кнопки

    }
}
