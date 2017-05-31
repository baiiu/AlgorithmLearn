package com.example;

/**
 * auther: baiiu
 * time: 17/6/1 01 07:23
 * description:
 */
class Question08_MinNumberInRotatedArray {

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，称之为 旋转数组。
     *
     * Question:
     * 输入一个递增排序的数组的一个旋转，输出该旋转数组的最小值。
     */
    static void test() {
        int[] rotatedArray = new int[] { 3, 4, 5, 6, 7, 1, 2 };

        minValue(rotatedArray);
    }

    private static void minValue(int[] rotatedArray) {
        if (rotatedArray == null || rotatedArray.length == 1) return;

        /*
            遍历：O(n),第一个变小的值就是最小值

            从后往前遍历：O(n)，就是递减序列的最小值
         */
        int minIndex = -1;
        for (int i = 0, length = rotatedArray.length; i < length - 1; ++i) {
            if (rotatedArray[i + 1] < rotatedArray[i]) {
                minIndex = i + 1;
                break;
            }
        }

        if (minIndex == -1) {
            System.out.println("输入有误");
            return;
        }

        System.out.println(rotatedArray[minIndex]);

    }

}
