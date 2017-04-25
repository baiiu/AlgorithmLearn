package com.baiiu.sort;

/**
 * auther: baiiu
 * time: 17/4/9 09 11:52
 * description:
 * 简单选择排序：每一次遍历时选取关键字最小的记录作为有序序列的第i个记录。
 */
@SuppressWarnings("ALL")
class SimpleSelectionSort {
    static void simpleSelectionSort(int[] array) {
        if (array == null || array.length == 1) return;

        for (int i = 0, size = array.length; i < size; ++i) {
            int minIndex = i;

            for (int j = i + 1; j < size; ++j) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                CommonUtil.swap(array, i, minIndex);
            }
        }

    }

}
