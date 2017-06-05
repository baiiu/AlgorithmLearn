package com.example;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * author: baiiu
 * date: on 17/6/5 11:35
 * description:
 */
class Question12_BigIntegerPlus {

    /**
     * 两个整数相加
     * <p>
     * 暂不考虑加一个负数
     */
    static void test() {
        int[] numberA = new int[]{9, 9, 9, 9};
        int[] numberB = new int[]{9, 9};
        plus(numberA, numberB);

        BigDecimal bigDecimalA = new BigDecimal(9999);
        BigDecimal bigDecimalB = new BigDecimal(99);
        System.out.println(bigDecimalA.add(bigDecimalB));
    }


    private static void plus(int[] numberA, int[] numberB) {
        int aLength = numberA.length;
        int bLength = numberB.length;

        int max = aLength > bLength ? aLength : bLength;

        int[] result = new int[max + 1];


        int aNumber, bNumber;
        for (int i = 0; i < max + 1; ++i) {
            // 从最大数的个位相加
            aNumber = aLength - 1 - i >= 0 ? numberA[aLength - 1 - i] : 0;
            bNumber = bLength - 1 - i >= 0 ? numberB[bLength - 1 - i] : 0;

            result[max - i] = aNumber + bNumber;
        }

        int i = max;
        while (i >= 0) {
            while (result[i] >= 10) {
                result[i] -= 10;
                result[i - 1]++;
            }

            --i;
        }

        printNumber(result);
    }

    private static void printNumber(int[] number) {
        System.out.println(Arrays.toString(number));
//        boolean flag = true;
//        for (int i = 0, length = number.length; i < length; ++i) {
//            if (flag && number[i] == 0) continue;
//
//            flag = false;
//            System.out.print(number[i]);
//        }
//        System.out.println();
    }

}
