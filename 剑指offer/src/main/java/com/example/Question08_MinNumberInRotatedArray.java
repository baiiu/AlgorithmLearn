package com.example;

/**
 * auther: baiiu
 * time: 17/6/1 01 07:23
 * description:
 */
class Question08_MinNumberInRotatedArray {

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，称之为 旋转数组。
     * <p>
     * Question:
     * 输入一个递增排序的数组的一个旋转，输出该旋转数组的最小值。
     */
    static void test() {
//        int[] rotatedArray = new int[]{3, 4, 5, 6, 7, 0, 1, 3};
        int[] rotatedArray = new int[]{1, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1};

        foreachToSearchMinValue(rotatedArray);
        middleSearchMinValue_Recursive(rotatedArray, 0, rotatedArray.length - 1);
        middleSearchMinValueWhile(rotatedArray);
    }

    private static void middleSearchMinValueWhile(int[] rotatedArray) {
        int point1 = 0, point2 = rotatedArray.length - 1, middle = 0;

//        while (rotatedArray[point1] >= rotatedArray[point2]) {
        while (true) {
            if (point2 - point1 == 1) {
                middle = point2;
                break;
            }

            middle = (point1 + point2) / 2;

            if (rotatedArray[point1] == rotatedArray[point2] && rotatedArray[point1] == rotatedArray[middle]) {
                foreachToSearchMinValue(rotatedArray);
                return;
            }

            if (rotatedArray[middle] >= rotatedArray[point1]) {
                point1 = middle;
            } else if (rotatedArray[middle] <= rotatedArray[point2]) {
                point2 = middle;
            }
        }

        System.out.println(middle + ", " + rotatedArray[middle]);
    }

    private static void middleSearchMinValue_Recursive(int[] rotatedArray, int point1, int point2) {
        if (rotatedArray == null || rotatedArray.length == 0) return;
        /*
            二分查找

            旋转数组，头部一定大于或等于尾部

            point1指向开头，point2指向末尾，middle就是中间

            如果 *point1 == *point2 == *middle，则无法区分，只能遍历

            如果*middle大于等于*piont1，最小值在middle后面，或这个值就是最小值
            如果*middle小于等于*point2，最小值在middle前面，或这个值就是最小值
         */

        if ((point2 - point1 == 1)) {
            System.out.println(point2 + ", " + rotatedArray[point2]);
            return;
        }

        int middle = (point1 + point2) / 2;

        if (rotatedArray[point1] == rotatedArray[point2] && rotatedArray[point1] == rotatedArray[middle]) {
            foreachToSearchMinValue(rotatedArray);
            return;
        }

        if (rotatedArray[middle] >= rotatedArray[point1]) {
            middleSearchMinValue_Recursive(rotatedArray, middle, point2);
        } else if (rotatedArray[middle] <= rotatedArray[point2]) {
            middleSearchMinValue_Recursive(rotatedArray, point1, middle);
        }
    }

    private static void foreachToSearchMinValue(int[] rotatedArray) {
        if (rotatedArray == null || rotatedArray.length == 0) return;

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
