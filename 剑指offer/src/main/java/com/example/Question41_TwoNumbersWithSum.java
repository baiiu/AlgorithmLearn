package com.example;

import com.baiiu.CommonUtil;

/**
 * author: baiiu
 * date: on 17/9/6 10:11
 * description:
 */
class Question41_TwoNumbersWithSum {

    /**
     * 和为s的两个数字
     * <p>
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
     * 如果有多对数字的和等于s，输出任意一对即可。
     * <p>
     * 例如：
     * {1, 2, 3, 4, 5, 6, 7, 8, 9}
     * 和为10的一对数，即可随便输出{1,9}、{2,8}、{3,7}、{4,6}中的任意一对
     */
    static void test() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = 10;

        findCoupleNumber(arr, sum);
        System.out.println();
        findCoupleNumber2(arr, sum);
    }

    /*
        该数组最大的特点是有序，可以使用两个指针，模仿二分查找思想。

        一个从前往后frontIndex，一个从后往前endIndex。

            相加的和如果大于targetSum，则前移endIndex
            相加的和如果小于targetSum，则后移frontIndex

        O(n)
     */
    private static void findCoupleNumber2(int[] arr, int targetSum) {
        if (CommonUtil.isEmpty(arr)) return;

        int frontIndex = 0, length = arr.length, endIndex = length - 1;

        while (frontIndex < endIndex) {
            int tempSum = arr[frontIndex] + arr[endIndex];

            if (tempSum < targetSum) {
                ++frontIndex;
            } else if (tempSum > targetSum) {
                --endIndex;
            } else {
                System.out.print("{" + arr[frontIndex] + ", " + arr[endIndex] + "}  ");
                ++frontIndex;
//                break;
            }
        }

    }


    /*
        双重循环 O(n*n)
     */
    private static void findCoupleNumber(int[] arr, int targetSum) {
        if (CommonUtil.isEmpty(arr)) return;

        for (int i = 0, length = arr.length; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {
                if (arr[i] + arr[j] == targetSum) {
                    System.out.print("{" + arr[i] + ", " + arr[j] + "}  ");
                }
            }
        }
    }

}
