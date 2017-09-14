package com.example;

import com.baiiu.CommonUtil;

/**
 * author: baiiu
 * date: on 17/9/12 16:52
 * description:
 */
class Question44_ContinuousCards {


    /**
     * 从扑克牌中随机抽取5张牌，判断是不是一个顺子(连续的)。
     * <p>
     * A为1，2~10为数字本身，J为11，Q为12，K为13； 大小王可以看成任意数字
     */
    static void test() {
        int[] arr = new int[]{1, 0, 5, 3, 6};

        isContinuous(arr);
    }

    /*
        有相同的数字即不是连续的。

        大小王当做0，然后排序。

        只要 非0数字的间隔数 < 0的个数，就是连续的。
     */
    private static void isContinuous(int arr[]) {
        if (CommonUtil.isEmpty(arr)) return;

        // 排序
        sort(arr);

        // 统计0的个数 和 间隔总数
        int countZero = 0;
        int countGap = 0;
        for (int i = 0, length = arr.length; i < length - 1; ++i) {
            if (arr[i] == 0) {
                ++countZero;
                continue;
            }

            int diff = arr[i + 1] - arr[i];

            if (diff == 0) {
                System.out.println("不连续，有连续数字");
                return;
            }

            if (diff > 1) {
                countGap += diff - 1;
            }
        }

        CommonUtil.printArray(arr);
        System.out.println(countZero + ", " + countGap);
        if (countGap > countZero) {
            System.out.println("不是连续的");
        } else {
            System.out.println("连续的");
        }

    }

    private static void sort(int arr[]) {
        if (CommonUtil.isEmpty(arr)) return;

        for (int i = 0, length = arr.length; i < length; ++i) {
            int minIndex = i;

            for (int j = i + 1; j < length; ++j) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                CommonUtil.swap(arr, minIndex, i);
            }
        }

    }


}
