package com.baiiu.sort;

import com.baiiu.CommonUtil;

/**
 * auther: baiiu
 * time: 17/4/9 09 10:58
 * description:
 * 冒泡排序：两两比较**相邻**记录的关键字，如果反序则交换，直到没有反序的记录为止
 */
@SuppressWarnings("ALL")
class BubbleSort {

    // 最简单交换排序，非冒泡排序,比较的不是相邻关键字，但便于理解
    // 比较次数n(n + 1)/2，交换次数会很多，仔细分析下，会把小的数字放到最后去，而冒泡则不会，原因就是比较的是相邻关键字
    static void simpleSwapSort(int[] array) {
        if (array == null || array.length == 1) return;

        for (int i = 0, size = array.length; i < size; ++i) {
            //for (int j = 0; j < size; j++) { //这种效率更低 n^2
            for (int j = i + 1; j < size; ++j) {
                if (array[j] < array[i]) {
                    CommonUtil.swap(array, i, j);
                }
            }
        }
    }

    // 正宗的冒泡排序，从最底下开始冒泡，两两比较,每次都将小的往上冒一点
    static void bubbleSort(int[] array) {
        if (array == null || array.length == 1) return;

        for (int i = 1, size = array.length; i < size; ++i) {
            for (int j = size - 1; j >= i; --j) {
                if (array[j] < array[j - 1]) {
                    CommonUtil.swap(array, j, j - 1);
                }
            }
            //CommonUtil.printArray(array);
        }
    }

    // 冒泡排序优化，如果经过一轮发现已经是有序的，就不再进行排序
    static void bubbleSortBetter(int[] array) {
        if (array == null || array.length == 1) return;

        boolean flag = true;
        for (int i = 1, size = array.length; i < size && flag; ++i) {
            flag = false;
            for (int j = size - 1; j >= i; --j) {//经过一轮循环，发现两两已经是有序的了，就置为false
                if (array[j] < array[j - 1]) {
                    CommonUtil.swap(array, j, j - 1);
                    flag = true;
                }
            }

            //CommonUtil.printArray(array);
        }
    }

}
