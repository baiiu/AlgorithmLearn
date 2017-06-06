package com.example;

import com.baiiu.CommonUtil;

/**
 * author: baiiu
 * date: on 17/6/6 09:33
 * description:
 */
class Question14_ReorderArray {

    /**
     * 输入一个整数序列，实现一个函数来调整该数组中数字的顺序，
     * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     */
    static void test() {
        int[] array = new int[]{2, 4, 6, 8, 1, 2, 3, 4, 5, 6, 1};
//        int[] array = new int[]{2, 1, 1, 1, 1, 11, 1};

//        adjust_Bubble(array);
//        adjust_choose(array);
        reorderOddEven(array);

        CommonUtil.printArray(array);
    }

    /*
        优美的答案，一看就懂

        增强扩展性
      */
    private static void reorderOddEven(int[] array) {
        if (CommonUtil.isEmpty(array)) return;

        int ptrOdd = 0, length = array.length;
        int ptrEven = array.length - 1;


        while (ptrOdd < ptrEven) {
            while (ptrOdd < length && function_oddEven(array[ptrOdd])) {
                // 奇数位置移动
                ++ptrOdd;
            }

            while (ptrEven < length && !function_oddEven(array[ptrEven])) {
                --ptrEven;
            }

            if (ptrOdd < ptrEven) {
                CommonUtil.swap(array, ptrOdd, ptrEven);
            }
        }
    }

    private static boolean function_oddEven(int n) {
        return (n & 1) == 1;
    }

    /*
        优化的最基础的交换排序
            从最后一个元素开始，从头开始依次遍历，如果是偶数则交换。
     */
    private static void adjust_Bubble(int[] array) {
        if (CommonUtil.isEmpty(array)) return;

        int evenIndex = 0;
        for (int i = array.length - 1; i >= evenIndex; --i) {
            if ((array[i] & 1) == 0) {
                // 如果第i位是偶数，直接继续
                continue;
            }

            for (int j = evenIndex; j < i; ++j) { // j < i，i之后的位置全是偶数，已经交换过了
                if ((array[j] & 1) == 0) {
                    // 第i位是奇数(后面)，第j位是偶数(前面)，则交换
                    CommonUtil.swap(array, i, j);
                    ++evenIndex;
                    break;
                }
            }
        }
    }

    /*
        模仿选择排序
            从头开始遍历，从之后的元素中选择一个偶数来交换
     */
    private static void adjust_choose(int[] array) {
        if (CommonUtil.isEmpty(array)) return;

        for (int i = 0, length = array.length; i < length; ++i) {
            if ((array[i] & 1) == 1) {
                continue;
            }

            // 此时arr[i]是偶数了
            for (int j = i + 1; j < length; ++j) {
                if ((array[j] & 1) == 1) {
                    //如果j是奇数
                    CommonUtil.swap(array, j, i);
                    break;
                }
            }
        }
    }

}
