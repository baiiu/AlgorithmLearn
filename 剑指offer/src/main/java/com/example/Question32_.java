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

        countOneNumbers(123);

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
