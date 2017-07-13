package com.example;

import com.baiiu.CommonUtil;

/**
 * author: baiiu
 * date: on 17/7/12 11:43
 * description:
 */
class Question30_KLeastNumbers {

    /**
     * 最小的k个数
     * <p>
     * 输入n个整数，找出其中最小的k个数。
     * 例如输入 { 4,5,1,6,2,7,3,8 } 这8个数字，最小的4个数字为1,2,3,4
     */
    static void test() {
        int[] arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8};

        kSmallestNumber_QuickSort(arr, 4);
    }


    private static void kSmallestNumber_QuickSort(int[] array, int k) {
        if (CommonUtil.isEmpty(array) || k <= 0) return;

        int start = 0, end = array.length - 1, targetIndex = k - 1;
        int partition = partition(array, start, end);

        while (partition != targetIndex) {

            if (partition > targetIndex) {
                end = partition - 1;
            } else {
                start = partition + 1;
            }

            partition = partition(array, start, end);
        }

        CommonUtil.printArray(array, k);
    }

    private static int partition(int[] arr, int start, int end) {
        int provitKey = arr[end];
        int left = start, right = end - 1;

        while (left < right) {

            while (left < right && arr[left] <= provitKey) ++left;
            while (left < right && arr[right] >= provitKey) --right;

            if (left < right) {
                CommonUtil.swap(arr, left, right);
            }
        }

        if (arr[left] >= provitKey) {
            CommonUtil.swap(arr, left, end);
        } else {
            ++left;
        }


        return left;
    }


    /*
        1. 每次都遍历，去除掉上一个最小的数，O(k*n)
           同： int[k]，从输入数组中获取，填入int[0~k]中

        2. 先排序，后取. O(nlogn)

        3. O(n)
           桶排序： 以k为length的桶？
           计数排数： 小于某个值的总次数 >=k 即停止

        4. 最小堆的前k个值。O(nLogn)。
           最大堆找出 arr.length - k 个值，剩下的就是最小的k个值。
     */


}
