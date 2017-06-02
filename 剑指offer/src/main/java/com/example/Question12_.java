package com.example;

/**
 * author: baiiu
 * date: on 17/6/2 18:22
 * description:
 */
class Question12_ {

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

        printNumber_smallerThan(n);
//        printNumber_Stupid(n);

    }

    private static void printNumber_smallerThan(int n) {
        // 求出(n + 1)位的最小值
        int maxValue = 1;
        for (int i = 0; i < n; i++) {
            maxValue *= 10;
        }

        for (int i = 1; i < maxValue; ++i) {
            System.out.println(i);
        }
    }

    private static void printNumber_Stupid(int n) {
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
