package com.example;

/**
 * author: baiiu
 * date: on 17/9/7 10:48
 * description:
 */
class Question42_LeftRotateString {

    /**
     * 字符串的左旋转操作时把字符串前面的若干个字符转移到字符串尾部。
     * <p>
     * 请实现如下一个功能:
     * 输入"abcdefg"和数字2，
     * 输出左旋转2位得到的结果"cdefgab"
     */
    static void test() {
        String s = "abcdefg";
        int number = 2;

        reverseLeft(s.toCharArray(), number);
        reverseBeautiful(s.toCharArray(), number);
    }

    /*
        abcdefg 和 2 --> cdefgab

        bagfedc --> cdefgab

        可以看出，分别对两组字符数组倒置，再对整个倒置
     */
    private static void reverseBeautiful(char[] chars, int number) {
        if (chars == null || number >= chars.length) return;

        reverseString(chars, 0, number - 1);
        reverseString(chars, number, chars.length - 1);
        reverseString(chars, 0, chars.length - 1);

        System.out.println(chars);
    }

    private static void reverseString(char[] chars, int start, int end) {
        if (chars == null || chars.length == 0 || start < 0 || end > chars.length - 1) return;

        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            ++start;
            --end;
        }
    }


    /*
        插入排序的思想

        不使用额外空间，O(n*n)
      */
    private static void reverseLeft(char[] chars, int number) {
        if (chars == null || number >= chars.length) return;

        for (int i = 0, length = chars.length; i < number; ++i) {
            char temp = chars[0];

            for (int j = 0; j < length - 1; ++j) {
                chars[j] = chars[j + 1];
            }

            chars[length - 1] = temp;
        }

        System.out.println(chars);

    }


}
