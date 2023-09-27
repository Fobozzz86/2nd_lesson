package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CalendarComponent {

    // SelenideElements / locator / etc
       SelenideElement monthInput = $(".react-datepicker__month-select"),
                       yearInput = $(".react-datepicker__year-select");

    // Actions
    public void setDate(String day, String month, String year) {

        monthInput.selectOption(month);
        yearInput.selectOption(year);
//        $(".react-datepicker__day--0" + day).click();
        if (day.length() < 2) {
            String dayPickerLocator = String.format(".react-datepicker__day--00%s:not(.react-datepicker__day--outside-month)", day);
            $(dayPickerLocator).click();
        } else {
            String dayPickerLocator = String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day);
            $(dayPickerLocator).click();
        }
    }

}
