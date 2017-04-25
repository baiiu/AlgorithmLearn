package com.baiiu.sort;

/**
 * auther: baiiu
 * time: 17/4/9 09 18:17
 * description:
 * 希尔排序：不断缩小步长，在每步一步中使用快速排序，不断将一个大数组变成基本有序的数组，
 * 在最后使用步长为1进行快速排序，能达到比较快的排序速度。
 */
@SuppressWarnings("ALL")
class ShellSort {

    static void shellSort(int[] array) {
        if (array == null || array.length == 1) return;

        //计算步长
        int gap = 1, size = array.length;
        while (gap < size / 3) {
            gap = gap * 3 + 1; // O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
        }


        while (gap > 0) {

            for (int i = gap, j, temp; i < size; ++i) {
                temp = array[i];
                for (j = i - gap; j >= 0 && array[j] > temp; j -= gap) {
                    array[j + gap] = array[j];
                }
                array[j + gap] = temp;
            }

            gap /= 3;
        }
    }

}
