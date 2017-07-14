package com.example;

import com.baiiu.CommonUtil;

/**
 * author: baiiu
 * date: on 17/7/14 11:37
 * description:
 */
public class Question31_ {
    /**
     * 连续子数组的最大和
     * <p>
     * 输入一个整型数组，数组里有正数和负数。
     * 数组中一个或连续多个数字组成一个子数组，求所有子数组的最大值。
     * <p>
     * 要求时间复杂度为O(n)
     * <p>
     * 例如：输入{1,-2,3,10,-4,7,2,-5}的最大子数组为{3,10,-4,7,2}，因此最大和为18
     */
    static void test() {
        int[] arr = new int[]{1, -2, 3, 10, -4, 7, 2, -5};

        findSum(arr);
    }

    private static void findSum(int[] arr) {
        if (CommonUtil.isEmpty(arr)) return;

        int sum = arr[0], tempSum = arr[0];

        // 1. 求出单个数字最大
        for (int i = 1, length = arr.length; i < length; ++i) {
            sum = sum > arr[i] ? sum : arr[i];
        }

        // 2. 求所有子数组最大值


    }


}
