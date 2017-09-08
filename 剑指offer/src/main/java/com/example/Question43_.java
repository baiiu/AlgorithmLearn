package com.example;

import com.baiiu.CommonUtil;

/**
 * auther: baiiu
 * time: 17/9/7 07 23:13
 * description:
 */
class Question43_ {

    /**
     * n个骰子的点数
     * <p>
     * 把n个骰子仍在地上，所有骰子朝上一面的点数之和为s。
     * 输入n，打印出s的所有可能的值出现的概率。
     */
    static void test() {
        int n = 2;

        int[] arr = new int[n * 6 + 1];
        count(n, arr);


        printSum(arr);
    }

    /*
        1. 如何求出所有的和
        2. 如何求出该和出现出现的次数，出现一次加一次，就能得出概率

        n可能是递归、循环次数，计算相加的和和出现的次数

        hashMap:
            key记录的和
            value记录的出现次数
     */
    private static void count(int n, int[] arr) {

        // 每一次递归，都会进行一个加1
        while (n > 0) {
            --n;


            if (isNull(arr)) {
                for (int i = 1; i < 7; ++i) {
                    //1个骰子，初始情况
                    arr[i] = 1;
                }
            } else {

                // 遍历上次的所有和，对所有和 + 相应的骰子数
                for (int i = 1, length = countLength(arr); i < length; ++i) {
                    if (arr[i] == 0) continue;

                    for (int j = 1; j < 7; ++j) {
                        // 遍历上一次存入的值，开始对每个值加sum
                        int key = arr[i] + j;

                        if (arr[key] == 0) {
                            arr[key] = 1;
                        } else {
                            ++arr[key];
                        }

                    }

                }

            }
        }
    }

    private static boolean isNull(int[] arr) {
        if (CommonUtil.isEmpty(arr)) return true;

        for (int i : arr) {
            if (i != 0) return false;
        }

        return true;
    }

    // 第一个为0的位置
    private static int countLength(int[] arr) {
        if (CommonUtil.isEmpty(arr)) return 0;

        int index = 1;

        while (arr[index] != 0) {
            ++index;
        }

        return index;
    }

    private static void printSum(int[] arr) {
        if (CommonUtil.isEmpty(arr)) return;

        for (int i = 1, length = arr.length; i < length; i++) {
            System.out.println("点数: " + i + "， 出现次数: " + arr[i]);
        }

    }


}
