package com.example;

import com.baiiu.CommonUtil;

/**
 * auther: baiiu
 * time: 17/9/6 06 06:58
 * description:
 */
@SuppressWarnings("ForLoopReplaceableByForEach")
class Question40_ {

    /**
     * 数组中只出现一次的数字
     * <p>
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
     * 请找出这两个只出现一次的数字。
     * <p>
     * 要求时间复杂度是O(n)，空间复杂度是O(1)
     * <p>
     * 例如：在{2,4,3,6,3,2,5,5}数列中要输出4、6
     */
    static void test() {
        int[] arr = new int[]{2, 4, 3, 6, 3, 2, 5, 5};
        printOnceNumber(arr);


        System.out.println("-------------------");
        int[] arrOne = new int[]{2, 4, 3, 6, 3, 2, 5, 5, 4}; //一个整型数组里除了一个数字之外
        findOnceNumberOnlyOne(arrOne);
    }

    private static void findOnceNumber() {

    }

    /*
        只出现一次：
            1. 使用HashMap存储，空间O(n)，时间O(n)
            2. 双重循环，O(n*n)，未使用空间
     */
    private static void printOnceNumber(int[] arr) {
        if (CommonUtil.isEmpty(arr)) return;

        for (int i = 0, length = arr.length; i < length; ++i) {
            int temp = arr[i];
            boolean once = true;

            for (int j = 0; j < length; ++j) {
                if (i == j) continue;

                if (arr[j] == temp) {
                    once = false;
                    break;
                }
            }

            if (once) {
                System.out.println(temp);
            }
        }
    }

    /*
        如果题意是一个整型数组里除了一个数字之外，其他数字都都出现了两次

        则可以这样求：用两个指针，一个从前往后，一个从后往前。错误。

        答案：依次异或所有元素，因为相同的元素到最后都抵消了。
        任何一个数字异或它自己都等于0。
     */
    private static void findOnceNumberOnlyOne(int[] arr) {
        if (CommonUtil.isEmpty(arr)) return;

        int target = arr[0];
        for (int i = 1, length = arr.length; i < length; ++i) {
            target = target ^ arr[i];
        }

        System.out.println(target);
    }


}
