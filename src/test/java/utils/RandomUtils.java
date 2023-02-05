package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println("");
    }

    public static Integer randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);

    }


    public static String randomString(int len) {

        String AB = "erwetrweyhrehedg";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);

        for (int i = 0; 1 < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();

    }

    public static String randomeEmail() {
        return randomString(10) + "@qa.guru";
    }

    public static String randomItem() {
        return "";
    }
}
