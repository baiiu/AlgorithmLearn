package com.baiiu.sort;

/**
 * auther: baiiu
 * time: 17/4/9 09 12:15
 * description:
 * 直接插入排序：将一个记录插入到已经排好序的有序表中，得到一个新的、记录递增1的有序表
 */
@SuppressWarnings("ALL")
class StraightInsertionSort {

    static void straightInsertionSort(int[] array) {
        if (array == null || array.length == 1) return;

        // 默认array[0]是有序的，将剩下的插入到该有序数组中
        for (int i = 1, j, temp, size = array.length; i < size; ++i) {

            //if (array[i] < array[i - 1]) { //如果小于，将array[i]插入该有序数组中，可以不用

            //寻找合适的j
            j = i - 1;
            temp = array[i];//需要一个辅助空间，赋值操作也是移动操作

            // 边移动边查找，可以使用二分查找法
            while (j >= 0 && array[j] > temp) { //持续移动，直到找到合适的位置
                array[j + 1] = array[j];//向后移
                --j;
            }

            array[j + 1] = temp;//移动
            //}
        }

    }

    //for循环
    static void straightInsertionSort2(int[] array) {
        if (array == null || array.length == 1) return;

        for (int i = 1, j, temp, size = array.length; i < size; ++i) {
            temp = array[i];
            for (j = i - 1; j >= 0 && array[j] > temp; --j) {
                array[j + 1] = array[j];//移动而非交换
            }
            array[j + 1] = temp;
        }
    }

}
