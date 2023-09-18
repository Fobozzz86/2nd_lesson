package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class CalendarComponent {

    // SelenideElements / locator / etc
    // todo move code from setDate

    // Actions

    public void setDate(String day, String month, String year) {

        $(".react-datepicker__month-select").selectOption(month); // todo move
        $(".react-datepicker__year-select").selectOption(year);
//        $(".react-datepicker__day--0" + day).click();

        String dayPickerLocator = format(".react-datepicker__day--0%s", day);
        $(dayPickerLocator).click();
    }

}
