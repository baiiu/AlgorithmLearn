package com.baiiu.combinationPermutation;

/**
 * auther: baiiu
 * time: 17/8/13 13 11:17
 * description: 去重的全排列
 */
public class Permutation {

    public static void main(String[] args) {
        String s = "abc";
        permutation(s.toCharArray(), 0);
    }


    /*
        从第一个字符起，挨个与后面每个字符交换。
     */
    private static void permutation(char[] chars, int start) {
        if (chars == null || chars.length == 0) return;

        if (start == chars.length - 1) {
            System.out.println(chars);
        } else {
            for (int i = start, length = chars.length; i < length; ++i) {
                if (isSwap(chars, start, i)) {

                    swap(chars, i, start);
                    permutation(chars, start + 1);
                    swap(chars, i, start);

                }
            }
        }
    }

    // 与它后面非重复出现的数字交换
    private static boolean isSwap(char[] chars, int start, int end) {
        for (int i = start; i < end; ++i) {
            if (chars[i] == chars[end]) {
                return false;
            }
        }

        return true;
    }

    private static void swap(char[] array, int i, int j) {
        // @formatter:off
        if (array == null
                || i > array.length - 1 || j > array.length - 1
                || i < 0 || j < 0
                || i == j
                ) {
            return;
        }
        // @formatter:on

        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
