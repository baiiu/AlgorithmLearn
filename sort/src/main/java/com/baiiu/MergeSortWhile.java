package com.baiiu;

/**
 * author: baiiu
 * date: on 17/4/11 13:49
 * description:
 * 归并排序，迭代版实现
 */
class MergeSortWhile {

    static void mergeSort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        int block, start;

        // 原版代码的迭代次数少了一次，没有考虑到奇数列数组的情况
        for (block = 1; block < len * 2; block *= 2) { // block从1开始，1、2、4...这样进行拆分进行归并
            for (start = 0; start < len; start += 2 * block) {
                // block = 1时，start = 0、2、4、6、8、10、12...
                // block = 2时，start = 0、4、8、12、16...
                // block = 4时，start = 0、8、16...

                int mid = (start + block) < len ? (start + block) : len;
                int end = (start + 2 * block) < len ? (start + 2 * block) : len;

                merge(arr, result, start, --mid, --end);//merge函数计算的是下标，所以需要减去一位
            }
        }
    }

    /**
     * 合并两个有序数组
     * 多申请了一个result数组来存放，可以使用直接插入排序，避免申请
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
}
