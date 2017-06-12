package com.baiiu.sort;

import com.baiiu.CommonUtil;

/**
 * auther: baiiu
 * time: 17/4/12 12 08:03
 * description: 当快排到一定长度数组时，使用插入排序
 */
@SuppressWarnings("ALL")
class QuickSortWithInsertSort {
    private static final int MAX_LIMIT = 4;

    static void quickSortWithInsertSort(int[] arr) {
        quick_sort_recursive(arr, 0, arr.length - 1);
    }

    private static void quick_sort_recursive(int[] arr, int start, int end) {
        if (end - start <= MAX_LIMIT) {
            insertSort(arr, start, end);
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

    /**
     * 在arr[start...end]数组使用插入排序进行排序
     */
    private static void insertSort(int[] arr, int start, int end) {
        int temp;

        for (int i = start + 1, j; i <= end; ++i) {
            temp = arr[i];
            j = i - 1;

            while (j >= start && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = temp; //j多减了一次
        }

    }

}
