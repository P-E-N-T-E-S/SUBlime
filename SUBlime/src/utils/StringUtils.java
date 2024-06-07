package utils;

public class StringUtils {
    public static boolean isVazioOuNulo(String string) {
        return string == null || string.trim().isEmpty();
    }
}