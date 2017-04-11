package com.baiiu;

/**
 * author: baiiu
 * date: on 17/4/11 09:48
 * description:
 */
public class MergeSort {

    static void mergeSort(int[] array) {
        int length = array.length;
        int[] result = new int[length];//新声明一个同样长度数组，用于存储排序后的数组，可使用插入排序替换
        merge_sort_recursive(array, result, 0, length - 1);//传入最后一个元素下标会好理解很多
    }

    private static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end) return;

        int mid = start + ((end - start) >> 1);

        // 递归不断拆分
        merge_sort_recursive(arr, result, start, mid);
        merge_sort_recursive(arr, result, mid + 1, end);

        // 从最小的两个有序数组合并
        merge(arr, result, start, mid, end);
    }

    /**
     * 合并两个有序数组
     *
     * 将arr[start...mid]和arr[mid + 1...end]合并为有序的result，并重新赋值给arr
     */
    private static void merge(int[] arr, int[] result, int start, int mid, int end) {
        int i = start, j = mid + 1, k = start; //i是前半部分下标、j是后半部分下标、k是result下标

        while (i <= mid && j <= end) {
            result[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) result[k++] = arr[i++];
        while (j <= end) result[k++] = arr[j++];

        for (k = start; k <= end; ++k) {
            arr[k] = result[k];
        }
    }

    public static void merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        int block, start;

        // 原版代码的迭代次数少了一次，没有考虑到奇数列数组的情况
        for (block = 1; block < len * 2; block *= 2) {
            for (start = 0; start < len; start += 2 * block) {
                int low = start;
                int mid = (start + block) < len ? (start + block) : len;
                int high = (start + 2 * block) < len ? (start + 2 * block) : len;
                //两个块的起始下标及结束下标
                int start1 = low;
                int start2 = mid;

                //开始对两个block进行归并排序
                while (start1 < mid && start2 < high) {
                    result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
                }
                while (start1 < mid) {
                    result[low++] = arr[start1++];
                }
                while (start2 < high) {
                    result[low++] = arr[start2++];
                }

            }
            int[] temp = arr;
            arr = result;
            result = temp;
        }
    }

}
