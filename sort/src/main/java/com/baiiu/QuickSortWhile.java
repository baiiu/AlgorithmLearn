package com.baiiu;

/**
 * author: baiiu
 * date: on 17/4/12 11:07
 * description:
 */
class QuickSortWhile {
    private static final int MAX_LIMIT = 4;

    static void quickSort(int[] arr) {
        if (arr == null || arr.length == 1) return;

        quick_sort_recursive(arr, 0, arr.length - 1);
    }

    private static void quick_sort_recursive(int[] arr, int start, int end) {
        if (end - start <= MAX_LIMIT) {
            insertSort(arr, start, end);
            return;
        }

        while (start < end) { //尾递归优化
            int pivot = partition(arr, start, end);

            quick_sort_recursive(arr, start, pivot - 1);

            start = pivot + 1;
        }
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

    private static void insertSort(int[] arr, int start, int end) {

        for (int i = start + 1, j, temp; i <= end; ++i) {
            temp = arr[i];
            j = i - 1;

            while (j >= start && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = temp;
        }

    }

}
