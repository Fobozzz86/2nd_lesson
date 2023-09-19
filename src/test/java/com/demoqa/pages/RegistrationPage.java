package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModal;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class RegistrationPage {
    // SelenideElements / locators / etc

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsModal resultsModal = new ResultsModal();

    SelenideElement formHeaderText = $(".practice-form-wrapper"),
                    firstNameInput = $("#firstName"),
                    lastNameInput = $("#lastName"),
                    userEmailInput = $("#userEmail"),
                    genderInput = $("[for=gender-radio-1]"),
//                  genderInput = $("#genterWrapper");
                    userNumberInput = $("#userNumber"),
                    dateOfBirthInput = $("#dateOfBirthInput"),
                    subjectInput = $("#subjectsInput"),
                    hobbiesInput = $("#hobbiesWrapper"),
                    uploadPictureInput = $("#uploadPicture"),
                    currentAddressInput = $("#currentAddress"),
                    stateInput = $("#state"),
                    cityInput = $("#city"),
                    stateCityInput = $("#stateCity-wrapper"),
                    pushSubmit = $("#submit"),
                    buttonClose = $("#closeLargeModal");


//    ElementsCollection genderInputs = $$(".class"); // обращение к списку элементов

    // Actions
    public RegistrationPage openPage() {
        open("automation-practice-form");

        formHeaderText.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
        public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }
    public RegistrationPage setGender() {
        genderInput.click();
//  public RegistrationPage setGender(String value) {
//      genderInput.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUploadPicture() {
        uploadPictureInput.uploadFromClasspath("img/Test.jpg");
        return this;
    }
    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    public RegistrationPage setStateInput(String value) {
        stateInput.click();
        stateCityInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setCityInput(String value) {
        cityInput.click();
        stateCityInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage pushSubmitButton() {
        pushSubmit.click();
        return this;
    }
    public RegistrationPage verifyRegistrationResultsModalAppears() {
        resultsModal.verifyModalAppears();
        return this;
    }
    public RegistrationPage verifyResult(String key, String value) {
        resultsModal.verifyResult(key, value);
        return this;
    }
    public RegistrationPage closeModal() {
        buttonClose.scrollIntoView(true).click();
        return this;
    }

}
