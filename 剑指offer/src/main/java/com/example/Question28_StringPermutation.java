package com.example;

/**
 * author: baiiu
 * date: on 17/7/4 10:14
 * description:
 */
class Question28_StringPermutation {

    /**
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     * <p>
     * 例如输入abc，则打印出由a、b、c所能排列出来的所有字符串:abc,acb,bac,bca,cab,cba
     */
    static void test() {
        String s = "abc";
        permutation(s.toCharArray());
    }

    /*
        求一个位置的所有可能性，就是将它和其他位置交换。

        从头开始，固定首字母，求剩余部分字符串的全排列。
        在剩余部分，也可按照此种方法求。

        怎么求呢？就是将剩余部分的字符串的首字母和其他位置交换。

     */
    private static void permutation(char[] chars) {
        if (chars == null || chars.length == 0) return;

        permutation(chars, 0);
    }

    private static void permutation(char[] chars, int start) {
        if (chars.length - 1 == start) {
            System.out.println(chars);
        } else {
            char tmp;

            for (int i = start; i < chars.length; ++i) {
                // 下面是交换元素的位置
                tmp = chars[start];
                chars[start] = chars[i];
                chars[i] = tmp;

                // 处理下一个位置
                permutation(chars, start + 1); // 剩余部分

                // 恢复原状
                tmp = chars[start];
                chars[start] = chars[i];
                chars[i] = tmp;
            }
        }

    }

}
