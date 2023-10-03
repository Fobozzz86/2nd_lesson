package com.demoqa.utils;

import com.github.javafaker.Faker;

public class RandomUtilsFakerTest {
    static Faker faker = new Faker();

    static String[]
            genders = {"Male", "Female", "Other"},
            month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November"},
            subjects = {"English", "Maths", "Chemistry", "Physics", "Computer Science", "Arts", "Biology"},
            hobbies = {"Sports", "Reading", "Music"},
            picture = {"img/test_0.jpg", "img/test_1.jpg"},
            state = {"Uttar Pradesh", "Haryana"},
            cityUttarPradesh = {"Agra", "Lucknow", "Merrut"},
            cityHaryana = {"Karnal", "Panipat"};

    public static String generateFirstName() {
        return faker.name().firstName();
    }
    public static String generateLastName() {
        return faker.name().firstName();
    }
    public static String generateEmail() {
        return faker.internet().emailAddress();
    }
    public static String generateGender() {
        return faker.options().option(genders);
    }
    public static String generatePhoneNumber() {
        return faker.number().digits(10);
    }
    public static String generateRandomDay() {
        return String.valueOf (faker.number().numberBetween(1,31));
    }
    public static String generateRandomMonth() {
        return faker.options().option(month);
    }
    public static String generateRandomYear() {
        return String.valueOf(faker.number().numberBetween(1900,2100));
    }
     public static String generateSubjects() {
         return faker.options().option(subjects);
 }
     public static String generateHobbies() {
         return faker.options().option(hobbies);
 }
    public static String generatePicture() {
         return faker.options().option(picture);
 }
    public static String generateAddress() {
         return faker.address().city();
 }
    public static String generateState() {
         return faker.options().option(state);
 }
    public static String generateCity(String state) {

        if (state.equals("Uttar Pradesh")){
            return faker.options().option(cityUttarPradesh);
        } else if (state.equals("Haryana")){
            return faker.options().option(cityHaryana);
        }
        else return null;

 /*   switch (state) {
        case ("Uttar Pradesh"):
        return faker.options().option(cityUttarPradesh);

        case ("Haryana"):
        return faker.options().option(cityHaryana);
}
        return null;*/
 }

}
