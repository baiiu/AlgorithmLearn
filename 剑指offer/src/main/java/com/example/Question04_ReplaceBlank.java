package com.example;

/**
 * author: baiiu
 * date: on 17/5/24 20:42
 * description:
 */
class Question04_ReplaceBlank {

    /**
     * 把字符串中每个空格换成%20
     * <p>
     * 例如：
     * 输入   "We are happy."
     * 则输出 "We20%are20%happy."
     */
    static void test() {
        String s = "We are happy";
        replace2(s);

        char[] chars = new char[100];

        char[] array = s.toCharArray();
        System.arraycopy(array, 0, chars, 0, array.length);

        replace(chars);
    }

    /*
        在同一个数组内进行排序(包含指定字符串、并且有多余空间),节约空间

        获取有多少个空格

        从后往前开始移动到指定位置

     */
    private static void replace(char[] chars) {
        int spaceCount = 0;
        int originalLength = 0;
        for (char aChar : chars) {
            if (aChar == '\0') {
                break;
            }

            ++originalLength;
            if (' ' == aChar) {
                ++spaceCount;
            }
        }

        int j = originalLength + spaceCount * 2 - 1;

        for (int i = originalLength - 1; i >= 0; --i) {
            if (' ' == chars[i]) {
                chars[j] = '0';
                chars[--j] = '2';
                chars[--j] = '%';
            } else {
                chars[j] = chars[i];
            }

            --j;
        }

        System.out.println(chars);
    }

    // 使用多余空间，时间复杂度O(n)
    private static void replace2(String s) {
        if (s == null || s.length() == 0) return;

        char[] chars = s.toCharArray();

        int spaceCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (' ' == chars[i]) {
                ++spaceCount;
            }
        }

        char[] newString = new char[chars.length + spaceCount * 2];

        for (int i = 0, j = 0; i < chars.length; i++) {
            if (' ' == chars[i]) {
                newString[j] = '%';
                newString[++j] = '2';
                newString[++j] = '0';
            } else {
                newString[j] = chars[i];
            }

            ++j;
        }

        System.out.println(newString);

    }

}
