package com.example;

import com.baiiu.CommonUtil;

/**
 * author: baiiu
 * date: on 17/9/7 09:52
 * description:
 */
class Question42_ReverseWordsInSentence {

    /**
     * 翻转单词顺序
     * <p>
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
     * 为简单起见，标点符号和普通字母一样处理。
     * <p>
     * 例如：
     * 输入字符串 "I am a student."
     * 输出 "student. a am I"
     */
    static void test() {
        String s = "Im am a student.";

        reverseBeautiful(s);

        reverseSplit(s);
        reverse(s);

    }

    /*
        1. 翻转所有字符，包括单词
        2. 再根据空格翻转所有单词

        很精妙，O(n)的时间，未使用额外空间
     */
    private static void reverseBeautiful(String s) {
        if (CommonUtil.isEmpty(s)) return;

        char[] chars = s.toCharArray();

        reverseString(chars, 0, chars.length - 1);

        for (int i = 0, length = chars.length, lastStart = 0; i < length; ++i) {
            if (' ' == chars[i]) {
                reverseString(chars, lastStart, i - 1);
                lastStart = i + 1;
            }

            if (i == length - 1) {
                reverseString(chars, lastStart, i);
            }
        }


        System.out.println(chars);
    }

    private static void reverseString(char[] chars, int start, int end) {
        if (chars == null || chars.length == 0 || start < 0 || end > chars.length - 1) return;


        while (start < end) {
            char temp = chars[end];
            chars[end] = chars[start];
            chars[start] = temp;

            ++start;
            --end;
        }

    }

    /*
        从后往前遍历数组，记录emptyIndex，获取下一个空格到emptyIndex的字符串即可

        申请额外空间了
        O(n)的时间，O(n)的空间
     */
    private static void reverse(String s) {
        if (CommonUtil.isEmpty(s)) return;

        char[] chars = s.toCharArray();

        StringBuilder builder = new StringBuilder();
        for (int length = chars.length, i = length - 1, lastEmptyIndex = length; i >= 0; --i) {
            char aChar = chars[i];

            if (' ' == aChar) {
                builder.append(s.substring(i + 1, lastEmptyIndex));
                lastEmptyIndex = i;
                builder.append(" ");
            }

            if (i == 0) {
                builder.append(s.substring(0, lastEmptyIndex));
            }
        }

        System.out.println(builder.toString());

    }

    /*
        使用字符串分割
        O(n)的时间，O(n)的空间
      */
    private static void reverseSplit(String s) {
        if (CommonUtil.isEmpty(s)) return;

        String[] split = s.split(" ");

        StringBuilder builder = new StringBuilder();
        for (int length = split.length, i = length - 1; i >= 0; --i) {
            builder.append(split[i]);

            if (i == 0) {
                break;
            }
            builder.append(" ");
        }

        System.out.println(builder.toString());
    }

}
