package org.keep.demo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BracketVariableMatcher {
    public static void main(String[] args) {
        String input = "This is a [variable1] and here is another [variable2].";

        // 定义正则表达式
        String regex = "\\[([^\\]]+)\\]";
        
        // 创建Pattern对象
        Pattern pattern = Pattern.compile(regex);
        
        // 创建Matcher对象
        Matcher matcher = pattern.matcher(input);
        
        // 查找匹配的变量
        while (matcher.find()) {
            System.out.println("Found variable: " + matcher.group(1));
        }
    }
}
