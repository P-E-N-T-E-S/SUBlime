package br.com.code.spring.sublime.utils;

public class StringUtils {
    public static boolean isVazioOuNulo(String str) {
        return str == null || str.trim().isEmpty();
    }
}
