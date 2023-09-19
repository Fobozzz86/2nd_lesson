package examples;

import com.codeborne.selenide.ElementsCollection;
import com.demoqa.tests.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class DraftTests extends TestBase {

    @Test
    void someTest1() {

        /*
        Добрый день!
        Подскажите пожалуйста по поводу загрузки картинок в форму авторизации,
        Я загрузила изображение в директорию resources, обратилась к ней через  uploudfromclasspath(...\image.jpg),
        а как надо было бы обратиться, чтобы задать в скобках полный путь? C:\\Users\\...image.jpg
         */
        open("/automation-practice-form");

        String filPath = "image.jpg";
        $("#uploadPicture").uploadFromClasspath(filPath);

        File file = new File("src/test/resources/image.jpg");
//        File file = new File("/Users/stanislav/IdeaProjects/demoqa-tests-19/src/test/resources/image.jpg"); // BAD PRACTICE
        $("#uploadPicture").uploadFile(file);
    }

    @Test
    void someTest2() {
        /*
        А как лучше кликнуть по чекбоксу? Через .click или булеановский метод .set...
         */
        open("/automation-practice-form");

        $("#hobbies-checkbox-1").setSelected(true);
        // Invalid element state [#hobbies-checkbox-1]: Cannot change invisible element

        $("#hobbies-checkbox-1").click();
        // Invalid element state [#hobbies-checkbox-1]: element click intercepted:
        // Element <input type="checkbox" id="hobbies-checkbox-1" class="custom-control-input" value="1">
        // is not clickable at point (747, 628). Other element would receive the click: <label title=""
        // for="hobbies-checkbox-1" class="custom-control-label">...</label>

        $("#hobbies-checkbox-1").parent().click(); // BEST

        $(byText("Sports")).click();
    }

    @Test
    void someTest3() {
        /*
        привет, не справился с радио батоном Gender
         */
        open("/automation-practice-form");

        $("#hobbies-checkbox-1").click(); // bad
        $("#hobbies-checkbox-1").parent().click(); // good
        $("[for=gender-radio-3]").click(); // good
    }

    @Test
    void someTest4() {
        /*
        Привет! Пытался сделать кликание на форму с автозаполнением так: $("#subjectsInput").setValue(subject1.substring(0,1));
        $(".subjects-auto-complete__control").find(byText(subject1)).click();
        Т.е. вводится первый символ, а затем выбирается значение из выпадающего списка. Но не получается, не находит нужный селектор.
        Как найти этот селектор (ответственный за выпадающий список в форме автозаполнения)? Вроде все перепробовал.
         */
        open("/automation-practice-form");

        $("#subjectsInput").setValue("Math").pressEnter();
    }

    @Test
    void someTest5() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        $("#subjectsInput").setValue("Math").pressEnter();


        $("#name").sendKeys("B", Keys.ENTER);
    }

    @Test
    void someTest6() {
        /*
        Почему, когда мы выбираем год из списка метод selectOption работает: $(".react-datepicker__year-select").selectOption("1988");
        а когда выбираем штат из списка, то он не работает:
        $("#state").selectOption("Uttar Pradesh");
         */
        open("/automation-practice-form");
        $(".react-datepicker__year-select").selectOption("1988");
        $("#state").selectOption("Uttar Pradesh");
    }

    @Test
    void someTest7() {
        $("[name=q]").click();
        $$("[name=q]").get(0).click();
        $("[name=q]", 0).click();
    }


    @Test
    void someTest8() {
//        Вопрос по этой записи:
//        SelenideElement formHeaderText = $(".practice-form-wrapper"),
//                firstNameInput = $("#firstName"),
//                lastNameInput = $("#lastName"),
//                userEmailInput = $("#userEmail"),
//                gender = $("#genterWrapper");
//        А если где-то мы находим коллекцию, то будет аналогичный список, но с SelenideElementS?

        ElementsCollection genderInputs = $$(".asdfa");

    }

    @Test
    void someTes9() {
//        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();

//        String dayPickerLocator = format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day);
//        $(dayPickerLocator).click();
        // todo google it String.format
        // %s - это как плавающее значание (переменная)

        String a = "aaaa";
        String b = "bbbb" + a + "bbbb";
        /// bbbbaaaabbbb

//        String c = String.format("bbbb%sbbbb", a);
        String c = format("bbbb%sbbbb", a);
        /// bbbbaaaabbbb

//////////////////////

        String d = "dddd";
        String e = "eeee";
        String f = "ffff" + d + "ffff" + e + "ffff";

        String i = format("ffff%sffff%sffff", d, e);
        /// ffffddddffffeeeeffff

    }
}
