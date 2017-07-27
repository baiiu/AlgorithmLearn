package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * author: baiiu
 * date: on 17/7/24 11:23
 * description:
 */
class Question32_ {

    /**
     * 从1到n整数中1出现的次数
     * <p>
     * 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。
     * <p>
     * 例如：
     * 输入12，从1到12这些整数中包含1的数字有1、10、11、12，
     * 1共出现5次。
     */
    static void test() {
        int number = 12;

        countOneNumbers(number);
        countOneNumbers2(number);

//        int[] a = new int[]{1, 2};
//        System.out.println(atoi(a, 1));
//        System.out.println(atoi2(a, 1));
    }

    /*
        2. 分析数字的规律
     */
    private static void countOneNumbers2(int targetNumber) {
        if (targetNumber <= 0) return;

        String targetNumberString = String.valueOf(targetNumber);
        int[] numbers = new int[targetNumberString.length()];

        for (int i = 0; i < targetNumberString.length(); ++i) {
            numbers[i] = targetNumberString.charAt(i) - '0';
        }

        System.out.println(numberOfOne(numbers, 0)); //从最高位开始处理
    }

    private static int numberOfOne(int[] numbers, int currentIndex) {
        if (numbers == null || numbers.length == 0 || currentIndex > numbers.length - 1 || currentIndex < 0)
            return 0;

        int first = numbers[currentIndex]; //待处理的数字，最高位
        int length = numbers.length - currentIndex; //要处理的数字的位数

        if (length == 1 && first == 0) return 0;
        if (length == 1 && first > 0) return 1;

        int numFirstDigit = 0;

        // 21345,first=2,length=5,共有10000个 10^4
        if (first > 1) {
            numFirstDigit = powerBase10(length - 1);
        } else if (first == 1) {
            // 12345,first=1,length=5,共有2345 + 1个
            numFirstDigit = atoi(numbers, currentIndex + 1);
        }

        // 在[1346, 21345]中，这20000个数中
        // 除了第一位以外的位置，即剩下的位置中1的个数为2*4*1000，全排列 2xxxx， 2*4*C10 1
        int numOtherDigits = first * (length - 1) * powerBase10(length - 2);

        // [1, 1345]，接下来index右移
        int numRecursive = numberOfOne(numbers, currentIndex + 1);


        return numFirstDigit + numOtherDigits + numRecursive;
    }

    // 最高位大于1时，共有多少个 10000~19999
    private static int powerBase10(int length) {
        int result = 1;
        for (int i = 0; i < length; ++i) {
            result *= 10;
        }

        return result;
    }

    private static int atoi(int[] numbers, int i) {
        int result = 0;
        for (int j = i; j < numbers.length; j++) {
            result = (result * 10 + numbers[j]);
        }
        return ++result;
    }

    // 12345
    private static int atoi2(int[] numbers, int start) {
        if (numbers == null || numbers.length == 0 || start < 0 || start > numbers.length - 1)
            return 0;

        int result = 0;
        for (int i = start, length = numbers.length; i < length; ++i) {
            int number = numbers[i];

            result += number * Math.pow(10, length - i - 1);
        }

        return ++result;
    }


    /*
        1. 遍历[1,n]，%10计算每个位数上是否为1

        O(nlogn) logn为n的位数，用最大的循环来表示
     */
    private static void countOneNumbers(int targetNumber) {
        if (targetNumber <= 1) return;

        HashSet<Integer> hashSet = new HashSet<>();

        int sumOne = 0;
        for (int i = 1; i <= targetNumber; ++i) {
            int number = i;

            while (number / 10 != 0) { //该循环用于计算每一位数字
                if (number % 10 == 1) {
                    hashSet.add(i);
                    ++sumOne;
                }

                number /= 10;
            } // 循环完后number只剩一个数字，为最高位

            if (number == 1) {
                hashSet.add(i);
                ++sumOne;
            }
        }

        List<Integer> list = new ArrayList<Integer>(hashSet);
        Collections.sort(list);
        System.out.println(list.toString());
        System.out.println(sumOne);
    }


}
