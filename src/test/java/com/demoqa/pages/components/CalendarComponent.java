package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class CalendarComponent {

    // SelenideElements / locator / etc
       SelenideElement monthInput = $(".react-datepicker__month-select"),
                       yearInput = $(".react-datepicker__year-select");

    // Actions
    public void setDate(String day, String month, String year) {

        monthInput.selectOption(month);
        yearInput.selectOption(year);
//        $(".react-datepicker__day--0" + day).click();

        String dayPickerLocator = format(".react-datepicker__day--0%s", day);
        $(dayPickerLocator).click();
    }

}
