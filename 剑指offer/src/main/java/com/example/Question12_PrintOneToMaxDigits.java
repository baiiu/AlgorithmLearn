package com.example;

import java.util.Arrays;

/**
 * author: baiiu
 * date: on 17/6/2 18:22
 * description:
 */
class Question12_PrintOneToMaxDigits {

    /**
     * 输入数字n，依次打印出从1到n位最大的十进制数。
     * <p>
     * 例如：
     * 输入3，打印1,2,....999
     * <p>
     * 需要考虑溢出
     */
    static void test() {
        int n = 3;

        //noinspection ConstantConditions
        if (n <= 0) {
            return;
        }
//        printOneToMaxDigits_Recursively(n);
        printOneToMaxDigits(n);
//        printOneToMaxDigits_Wrong(n); //未考虑溢出
//        printOneToMaxDigits_Wrong_Stupid(n); // 未考虑溢出

    }

    /*
        使用全排列，n个位置，每个位置放0~9个数

        从高位0开始递归，从个位开始排列
      */
    private static void printOneToMaxDigits_Recursively(int n) {
        int[] number = new int[n];

        for (int i = 0; i < 10; ++i) {
            number[0] = i;
            printNumberRecursively(number, n, 0);
        }
    }

    private static void printNumberRecursively(int[] number, int length, int index) {
        if (index == length - 1) {
            printNumber(number);
            return;
        }

        for (int i = 0; i < 10; ++i) {
            number[index + 1] = i;
            System.out.println(Arrays.toString(number));
            printNumberRecursively(number, length, index + 1);
        }
    }

    /*
        使用字符串表示大数，自己实现进制

        大数表示：字符串、数组(字符数组char[]、数字数组int[])
     */
    private static void printOneToMaxDigits(int n) {
        /*
            n位的数字最大值: new int[n], new char[n],用来存储每一位
         */
        int[] number = new int[n];

        while (numberIncrement(number)) {
            printNumber(number);
        }
    }

    // 自增1，计算进制；并判断是否超过最大值
    private static boolean numberIncrement(int[] number) {
        int i = number.length - 1;
        while (i >= 0) {
            ++number[i];

            if (number[i] == 10) {
                number[i] = 0;

                --i;

                if (i == -1) {
                    return false;
                }

            } else {
                break;
            }
        }

        return true;
    }

    private static void printNumber(int[] number) {
//        System.out.println(Arrays.toString(number));
        boolean flag = true;
        for (int i = 0, length = number.length; i < length; ++i) {
            if (flag && number[i] == 0) continue;

            flag = false;
            System.out.print(number[i]);
        }
        System.out.println();
    }


    ////////////////////////////////////////////////////////////////////////////////////////////

    private static void printOneToMaxDigits_Wrong(int n) {
        // 求出(n + 1)位的最小值
        int maxValue = 1;
        for (int i = 0; i < n; i++) {
            maxValue *= 10;
        }

        for (int i = 1; i < maxValue; ++i) {
            System.out.println(i);
        }
    }

    private static void printOneToMaxDigits_Wrong_Stupid(int n) {
        int number = 1;

        // 计算位数
        while (count(number) <= n) {
            System.out.println(number);
            ++number;
        }
    }

    private static int count(int number) {
        int bitsCount = 0;

        while (number != 0) {
            number /= 10;
            ++bitsCount;
        }

        return bitsCount;
    }


}
