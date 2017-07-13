package com.example;

import com.baiiu.CommonUtil;

/**
 * auther: baiiu
 * time: 17/7/11 11 23:16
 * description:
 */
class Question29_MoreThanHalfNumber {

    /**
     * 数组中出现次数超过一半的数字
     * <p>
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * <p>
     * 例如：输入长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中
     * 出现5次，超过数组长度一半，所以输出2.
     */
    static void test() {
        int[] arr = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};

        findNumberOverHalf_Times(arr); // O(n)，最简单最好理解
        findNumberOverHalf(arr); // 遍历 O(n * n)
        findNumberOverHalf_CountSort(arr); // 使用多余空间 O(n)
        findNumberOverHalf_QuickSort(arr); // 改变原始数组 O(n)
    }

    /*
        6.  出现一半的数字，意味着它的出现次数比其他所有数字出现次数之和都要多
     */
    private static void findNumberOverHalf_Times(int[] array) {
        if (CommonUtil.isEmpty(array)) return;

        int targetNumber = array[0], count = 1; //第一个数字出现一次

        for (int i = 1, length = array.length; i < length; ++i) {

            if (array[i] == targetNumber) {
                ++count;
            } else {
                --count;
            }

            if (count == 0) {
                targetNumber = array[i];
                count = 1;
            }
        }

        System.out.println(targetNumber + ", " + count);
    }

    /*
        5. 使用快速排序，因为快排是随机选取的，有很大概率第一次就选中
        排序后的位置和n/2位置比较。
     */
    private static void findNumberOverHalf_QuickSort(int[] array) {
        if (CommonUtil.isEmpty(array)) return;

        int length = array.length, middle = length >> 1, start = 0, end = length - 1;

        int index = partition(array, start, end);

        while (index != middle) {
            if (index > middle) {
                end = index - 1;
            } else {
                start = index + 1;
            }

            index = partition(array, start, end);
        }

        System.out.println(array[middle]);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivotKey = arr[end];
        int left = start, right = end - 1;

        while (left < right) {

            while (arr[left] <= pivotKey && left < right) left++;
            while (arr[right] >= pivotKey && left < right) right--;

            if (left < right) {
                CommonUtil.swap(arr, left, right);
            }
        }

        if (arr[left] >= pivotKey) {
            CommonUtil.swap(arr, left, end);
        } else {
            left++;
        }

        return left;
    }


    /*
        4. 使用计数排序，统计每个数字出现的次数 O(n)
     */
    private static void findNumberOverHalf_CountSort(int[] array) {
        if (CommonUtil.isEmpty(array)) return;

        int max = array[0], min = array[0];
        int length = array.length, half = length >> 1;
        for (int i = 1; i < length; ++i) {
            max = array[i] > max ? array[i] : max;
            min = array[i] > min ? min : array[i];
        }

        int[] countNumberArr = new int[max - min + 1];

        for (int i = 0; i < length; ++i) {
            int index = array[i] - min;
            countNumberArr[index] += 1;

            if (countNumberArr[index] >= half) {
                System.out.println(array[i]);
                break;
            }
        }
    }


    /*
        这种数字有且仅有一个。

        1. 最基础的解法，遍历每个数字。 O(n*n)。
        借助空间记录遍历过的数字，可以提高效率。

        2. 排序，然后找中位数就可以了 O(nLogn)

        3. 边遍历边把相同的数字放到一块 O(n*n)
     */
    private static void findNumberOverHalf(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) return;

        int length = array.length, half = length >> 1;

        int temp, count;
//        Integer[] alreadyBeen = new Integer[half];

        for (int i = 0; i < half; ++i) { // i从一半开始
            temp = array[i];
            count = 1;

//            if (i == 0) {
//                alreadyBeen[i] = temp;
//            } else {
//                if (CommonUtil.arrayContains(alreadyBeen, temp)) {
//                    continue;
//                }
//            }


            for (int j = i + 1; j < length; ++j) {
                if (array[j] == temp) {
                    ++count;
                }
            }

            if (count >= half) {
                System.out.println(temp);
                break;
            }
        }

    }

}
