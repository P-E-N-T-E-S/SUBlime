package utils;

public class StringUtils {
    public static boolean isVazioOuNulo(String str) {
        return str == null || str.trim().isEmpty();
    }
}
