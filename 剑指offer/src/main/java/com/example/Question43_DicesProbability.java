package com.example;

import com.baiiu.CommonUtil;

/**
 * auther: baiiu
 * time: 17/9/7 07 23:13
 * description:
 */
class Question43_DicesProbability {

    /**
     * n个骰子的点数
     * <p>
     * 把n个骰子仍在地上，所有骰子朝上一面的点数之和为s。
     * 输入n，打印出s的所有可能的值出现的概率。
     */
    static void test() {
        int n = 4;

        int[] arr = new int[n * 6 + 1];
        int[] arr2 = new int[n * 6 + 1];
        boolean isArrSource = count(n, arr, arr2);
        if (isArrSource) {
            printSum(arr, n);
        } else {
            printSum(arr2, n);
        }

        System.out.println();

        printProbability(n);
    }

    // 二维数组
    private static void printProbability(int number) {
        if (number < 1)
            return;
        int g_maxValue = 6;
        int[][] probabilities = new int[2][];
        probabilities[0] = new int[g_maxValue * number + 1];
        probabilities[1] = new int[g_maxValue * number + 1];
        int flag = 0;
        for (int i = 1; i <= g_maxValue; i++) {
            probabilities[0][i] = 1;
        }

        for (int k = 2; k <= number; ++k) {
            for (int i = 0; i < k; ++i) {
                probabilities[1 - flag][i] = 0;
            }

            for (int i = k; i <= g_maxValue * k; ++i) {
                probabilities[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= g_maxValue; ++j)
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
            }
            flag = 1 - flag;
        }

        int total = (int) Math.pow(g_maxValue, number);
        for (int i = number; i <= g_maxValue * number; i++) {
            System.out.println("和: " + i + "\t,出现次数: " + probabilities[flag][i] + "\t, 概率: " + probabilities[flag][i] + "/" + total);
        }
    }


    /*
        1. 如何求出所有的和
        2. 如何求出该和出现出现的次数，出现一次加一次，就能得出概率

        n可能是递归、循环次数，计算相加的和和出现的次数

        hashMap:
            key记录的和
            value记录的出现次数
     */
    private static boolean count(int n, int[] arr, int[] arr2) {

        // 每一次递归，都会进行一个加1

        boolean isArrSource = true;

        while (n > 0) {
            --n;

            int[] sourceArr = isArrSource ? arr : arr2;
            int[] resultArr = isArrSource ? arr2 : arr;

            if (isNull(sourceArr)) {
                isArrSource = true;

                for (int i = 1; i < 7; ++i) {
                    //1个骰子，初始情况
                    arr[i] = 1;
                }
            } else {

                // 遍历上次的所有和，对所有和 + 相应的骰子数
                int originLength = countLength(sourceArr);

                for (int i = 1; i < originLength; ++i) {
                    if (sourceArr[i] == 0) continue;

                    for (int k = 0; k < sourceArr[i]; ++k) {
                        for (int j = 1; j < 7; ++j) {
                            int key = i + j;
                            ++resultArr[key];
                        }
                    }
                }

                for (int i = 0; i < originLength; ++i) {
                    sourceArr[i] = 0;
                }

                isArrSource = !isArrSource;
            }
        }

        return isArrSource;
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

        int index = arr.length - 1;

        while (arr[index] == 0) {
            --index;
        }

        return index + 1;
    }

    // 概率就是出现次数除以所有可能性 6^n
    private static void printSum(int[] arr, int n) {
        if (CommonUtil.isEmpty(arr)) return;

        int sum = (int) Math.pow(6, n);

        for (int i = 1, length = arr.length; i < length; i++) {
            System.out.println("和: " + i + "\t,出现次数: " + arr[i] + "\t, 概率: " + arr[i] + "/" + sum);
        }

    }


}
