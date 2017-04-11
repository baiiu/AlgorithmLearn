package com.baiiu;

/**
 * auther: baiiu
 * time: 17/4/11 11 21:47
 * description:
 */
class QuickSort {

    static void quickSort(int[] array) {
        quick_sort_recursive(array, 0, array.length - 1);
    }

    private static void quick_sort_recursive(int[] array, int start, int end) {
        int pivot;

        if (start < end) {
            pivot = partition(array, start, end);

            quick_sort_recursive(array, start, pivot - 1);
            quick_sort_recursive(array, pivot + 1, end);
        }

    }

    private static int partition(int[] array, int start, int end) {
        int pivotKey = array[start];

        while (start < end) {
            while (start < end && array[end] >= pivotKey) {
                end--;
            }

            CommonUtil.swap(array, start, end);

            while (start < end && array[start] <= pivotKey) {
                start++;
            }

            CommonUtil.swap(array, start, end);
        }

        return start;
    }

}
