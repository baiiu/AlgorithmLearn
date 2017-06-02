package com.example;

/**
 * author: baiiu
 * date: on 17/6/2 10:53
 * description:
 */
class Question10_ {

    /**
     * 输入一个整数，输出该整数的二进制表示中1的个数。
     *
     * 考虑负数
     */
    static void test() {
        int number = -156;

        countsNumber(number);
        countsNumber_Stupid(number);
        System.out.println(Integer.toBinaryString(number));
    }

    // 使用位运算，进行右移判断
    private static void countsNumber(int number) {
        int count = 0;

        while (number != 0) {
            if ((number & 1) == 1) {
                ++count;
            }

            number = number >> 1;
        }

        System.out.println(count);

    }

    // 愚蠢的解法，整数本身存储的就是二进制数，可以使用位运算
    private static void countsNumber_Stupid(int number) {
        /*
            1. 将该整数转化为二进制
            2. 计算该二进制数中1的个数

            [十进制转二进制](http://zh.wikihow.com/%E4%BB%8E%E5%8D%81%E8%BF%9B%E5%88%B6%E8%BD%AC%E6%8D%A2%E4%B8%BA%E4%BA%8C%E8%BF%9B%E5%88%B6)
         */
        StringBuilder builder = new StringBuilder();

        while (number != 0) {
            int remainder = number % 2;
            number = number / 2;

            builder.append(remainder);
        }
        builder.reverse();

        String numberString = builder.toString();
        int count = 0;
        char[] array = numberString.toCharArray();
        for (char c : array) {
            if ('1' == c) {
                ++count;
            }
        }
        System.out.println(numberString + ", " + count);

    }


}
