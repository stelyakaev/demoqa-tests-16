package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {



    public static void main (String[] args){
        System.out.println(randomString(7));
        System.out.println(randomEmail(10));
        System.out.println(randomNumber(1000000L, 10000000L));
        System.out.println(randomPhone("+7", 9000000000L, 9999999999L));
    }

    public static String randomString(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String randomEmail(int len) {
        return randomString(len) + "@gmail.com";
    }

    public static Long randomNumber(Long min, Long max){
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    public static String randomPhone(String prefix, Long min, Long max){
        return prefix + randomNumber(min, max);
    }

    }

