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
        if (start >= end) {
            return;
        }

        int pivot = partition(array, start, end);
        System.out.println("start: " + start + ", pivot: " + pivot + ", pivotKey: " + array[pivot]);
        CommonUtil.printArray(array);

        quick_sort_recursive(array, start, pivot - 1);
        quick_sort_recursive(array, pivot + 1, end);
    }

    /**
     * 以end为锚点进行交换，比end小的都换到前面去，比end大的都换到后面去
     */
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


        if (arr[left] >= arr[end]) {
            CommonUtil.swap(arr, left, end);
        } else {
            left++;
        }

        return left;
    }

}
