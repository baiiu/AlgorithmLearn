package com.example;

import com.baiiu.CommonUtil;

/**
 * auther: baiiu
 * time: 17/9/6 06 06:58
 * description:
 */
@SuppressWarnings("ForLoopReplaceableByForEach")
class Question40_NumbersAppearOnce {

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
        System.out.println();
        findOnceNumber(arr);


        System.out.println("-------------------");
        int[] arrOne = new int[]{2, 4, 3, 6, 3, 2, 5, 5, 4}; //一个整型数组里除了一个数字之外
        findOnceNumberOnlyOne(arrOne);
    }

    /*
        1. 使用异或，找出两个唯一没有出现两次的数字的异或值
        2. 找到该异或值的二进制表示的为1的从左往右第一个、也可以第二个等等等
        3. 以相同位数为1或0分成两个数组，这两个数组中分别包含了一个唯一的数字

        异或：相同为0，不同为1.
           所以在进行分割时，那两个不同的数字肯定被分割到不同的数组中；
           所以相同的数字肯定被分割到同一个数组中
     */
    private static void findOnceNumber(int[] arr) {
        if (CommonUtil.isEmpty(arr)) return;

        int length = arr.length;

        // 1
        int xorResult = arr[0];
        for (int i = 1; i < length; ++i) {
            xorResult ^= arr[i];
        }

        // 2
        int firstDigit = 0;
        while ((xorResult & 1) == 0) {
            xorResult = xorResult >> 1;
            ++firstDigit;
        }

        // 3
        int number1 = 0;
        int number2 = 0;
        for (int i = 0; i < length; ++i) {
            if (isSame(arr[i], firstDigit)) {
                number1 ^= arr[i];
            } else {
                number2 ^= arr[i];
            }
        }

        System.out.println(number1 + ", " + number2);
    }

    // 该数字的第digit位是1么
    private static boolean isSame(int number, int digit) {
        return ((number >> digit) & 1) == 1;
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
                System.out.print(temp + ", ");
            }
        }
    }

    /*
        如果题意是一个整型数组里除了一个数字之外，其他数字都都出现了两次

        则可以这样求：用两个指针，一个从前往后，一个从后往前。错误。

        答案：依次异或所有元素，因为相同的元素到最后都抵消了。
        任何一个数字异或它自己都等于0.
     */
    private static void findOnceNumberOnlyOne(int[] arr) {
        if (CommonUtil.isEmpty(arr)) return;

        int target = arr[0];
        for (int i = 1, length = arr.length; i < length; ++i) {
            target ^= arr[i];
        }

        System.out.println(target);
    }


}
