package com.example;

import com.baiiu.CommonUtil;

/**
 * auther: baiiu
 * time: 17/8/10 10 07:22
 * description:
 */
class Question36_ {

    /**
     * 数组中的逆序对
     * <p>
     * 在数组中两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     * 输入这个数组中的逆序对的总数。
     * <p>
     * 例如{7,5,6,4}中，共存在5对逆序对。分别是{7,5}、{7,6}、{7,4}、{5，4}、{6，4}
     */
    static void test() {
        int[] arr = new int[]{7, 5, 6, 4};

        countNumberOfReverseCouple(arr);
    }

    /*
        1. 暴力法
            两次循环

            O(n*n)
                需要比较 (n-1) + (n-2) + ... + 1 次
     */
    private static void countNumberOfReverseCouple(int[] arr) {
        if (CommonUtil.isEmpty(arr)) return;

        int count = 0;

        for (int i = 0, length = arr.length; i < length; ++i) {
            int temp = arr[i];

            for (int j = i + 1; j < length; ++j) {
                if (temp > arr[j]) {
                    ++count;
                }
            }
        }

        System.out.println(count);

    }

}
