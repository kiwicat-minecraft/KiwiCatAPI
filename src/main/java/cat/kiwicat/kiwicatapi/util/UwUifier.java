package cat.kiwicat.kiwicatapi.util;

import java.util.Random;

public class UwUifier {

    private static final Random RANDOM = new Random();

    private static String transform(String text) {
        return text.toLowerCase()
                .replaceAll("[rl]", "w")
                .replaceAll("n([aeiou])", "ny$1")
                .replaceAll("ove", "uve")
                .replaceAll("uck", "uwq")
                .replaceFirst("i", "i-i")
                .replaceFirst("(?s)(.*)i-i-i", "$1i-i");
    }

    public static String uwuify(String text) {
        if (text == null) {
            return null;
        }

        String result = transform(text);

        if (RANDOM.nextInt(10) <= 2) {
            result += " >_<";
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(uwuify("hello you cutie <3"));
    }
}
