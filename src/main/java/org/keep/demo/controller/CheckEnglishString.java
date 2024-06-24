package org.keep.demo.controller;

import software.amazon.awssdk.utils.StringUtils;

import java.util.regex.Pattern;

public class CheckEnglishString {
    
    private static final String JIN_REGEX = "#.+#.+#";
    public static boolean isEnglishString(String input) {
        // 定义正则表达式，表示只包含英文字符
//        String regex = "^[a-zA-Z]+$";
        String regex = "^[a-zA-Z\\s]+$";

        // 使用 Pattern 类编译正则表达式
        Pattern pattern = Pattern.compile(regex);

        // 使用 Matcher 类进行匹配
        return pattern.matcher(input).matches();
    }

    private static String textHandle(String text) {

        String jinChar = "#";
        if (StringUtils.isEmpty(text) || StringUtils.isBlank(text)) {
            return jinChar;
        }
        text = text.replaceAll(jinChar, "");
        if (StringUtils.isEmpty(text) || StringUtils.isBlank(text)) {
            return jinChar;
        }

        text = text.trim();
        String regex = "^[a-zA-Z\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        if (pattern.matcher(text).matches()) {
            return jinChar.concat(" ").concat(text).concat(" ").concat(jinChar);
        }

        return jinChar.concat(text).concat(jinChar);
    }

    private static boolean startsWithAlphabets(String input) {
        // 使用正则表达式判断字符串是否以英文字母开头
        String regex = "^[a-zA-Z].*";
        return Pattern.matches(regex, input);
    }

    private static boolean endsWithAlphabets(String input) {
        // 使用正则表达式判断字符串是否以英文字母结尾
        String regex = ".*[a-zA-Z]$";
        return Pattern.matches(regex, input);
    }

    public static void main(String[] args) {
        String testString1 = "# 证实 # check #";
        boolean matches = Pattern.matches(JIN_REGEX, testString1);
        System.out.println(matches);
    }
}
