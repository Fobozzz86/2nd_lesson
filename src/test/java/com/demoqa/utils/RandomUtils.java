package com.demoqa.utils;

import java.security.SecureRandom;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    static String[] genders = {"Male", "Female", "Other"};
    public static void main(String[] args) {
        System.out.println(getRandomUuid());
        System.out.println(getRandomString(10));
        System.out.println(getRandomEmail());
        System.out.println(getRandomInt(1111111111, 999999999));
//        System.out.println(getRandomLong(11111111111, 9999999999));
        System.out.println(getRandomItemFromArray(genders));
    }

    public static String getRandomUuid() {
        String uuid = UUID.randomUUID().toString();
        return "uuid = " + uuid;
    }
    public static String getRandomString(int len) {
//        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();

        StringBuilder sb = new StringBuilder(len);
            for (int i = 0; i < len; i++)
                sb.append(AB.charAt(rnd.nextInt(AB.length())));
            return sb.toString();
    }
    public static String getRandomEmail(){
        return getRandomString(10) + "@yandex.ru";
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    public static String getRandomPhone() {
        return "79" + (getRandomInt(11, 99)) + (getRandomInt(111111, 999999));
    }
 /*   public static Long getRandomLong(long minl, long maxl) {
        return ThreadLocalRandom.current().nextLong(minl, maxl + 1);
    }
*/
   private static String getRandomItemFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);
        return values[index];
    }
    public static String getRandomGender() {
       return getRandomItemFromArray(genders);
    }
}
