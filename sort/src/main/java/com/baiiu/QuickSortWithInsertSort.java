package com.baiiu;

/**
 * auther: baiiu
 * time: 17/4/12 12 08:03
 * description:
 */
class QuickSortWithInsertSort {

    static void quickSortWithInsertSort(int[] arr) {
        quick_sort_recursive(arr, 0, arr.length - 1);
    }

    private static void quick_sort_recursive(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(arr, start, end);

        quick_sort_recursive(arr, 0, pivot - 1);
        quick_sort_recursive(arr, pivot + 1, end);
    }

    // 以一关键值对数组进行调整，使得该关键值之前的值比它小，使得该关键值之后的值比它大
    private static int partition(int[] arr, int start, int end) {
        int left = start, right = end - 1, pivotKey = arr[end];

        while (left < right) {
            while (arr[left] <= pivotKey && left < right) ++left;
            while (arr[right] >= pivotKey && left < right) --right;

            if (left < right) {
                CommonUtil.swap(arr, left, right);
            }
        }

        if (arr[left] > arr[end]) {
            CommonUtil.swap(arr, left, end);
        } else {
            left++;
        }

        return left;

    }

}
