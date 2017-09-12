package com.example;

import com.baiiu.CommonUtil;

/**
 * author: baiiu
 * date: on 17/9/12 16:52
 * description:
 */
class Question44_ {


    /**
     * 从扑克牌中随机抽取5张牌，判断是不是一个顺子(连续的)。
     * <p>
     * A为1，2~10为数字本身，J为11，Q为12，K为13； 大小王可以看成任意数字
     */
    static void test() {

        int[] arr = new int[]{3, 2, 1, 5, 1};
        sort(arr);

        CommonUtil.printArray(arr);
    }


    /*
        输入数字除大小王之后进行排序，大小王用0表示。

        11112算不算？？？重复的怎么算？？？
        先定：把非0重复的去掉，然后也可以连续

        例子：
        1 3 5 加 两个王
        1 345 加1一个王

        分三种情况：
            1) 没有王：直接判断数组 --> OK
            2) 一个王：
                4个数字是连续的 --> OK
                3个数字是连续的，剩下那个数字是不是最大数字+2或最小数字-2 --> OK
            3) 两个王
                3个数字是连续的 --> OK
                2个数字是连续的，剩下那个数字是不是最大数字+3或最小数字-3 --> OK
                没有数字连续,判断三个数字的极差是不是在4 --> OK

        极差这个概念挺好的。
     */

    /*
        1. ~~除0以外 去重(也可以不用去重)~~ 按从小到大排序
        2.
     */
    private static void isConinuious(int[] arr) {

    }

    private static int[] sort(int[] arr) {
        if (CommonUtil.isEmpty(arr)) return arr;

        int minIndex;
        boolean duplicate = false;
        for (int i = 0, length = arr.length; i < length; ++i) {
            for (int j = length - 1; j > i; --j) {
                if (arr[j] < arr[j - 1]) {
                    CommonUtil.swap(arr, j, j - 1);
                }
            }
        }

        System.out.println(duplicate);

        return arr;
    }

}
