package com.baiiu.Sorting;

import static com.baiiu.Sorting.ABaseExample.exch;
import static com.baiiu.Sorting.ABaseExample.isSorted;
import static com.baiiu.Sorting.ABaseExample.less;

/**
 * author: baiiu
 * date: on 16/12/28 14:47
 * description: 选择排序
 *
 * 1. 找到数组中最小的那个元素，
 * 2. 将它和数组的第一个元素交换位置（如果第一个元素就是最小元素那么它就和自己交换）。
 * 3. 在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。
 * 4. 如此往复，直到将整个数组排序。
 *
 * 这种方法叫做选择排序， 因为它在不断地选择剩余元素之中的最小者。
 */

public class SelectSort {

    /*
        选择排序：
            使用N次交换，和数组长度成线性关系
            使用N(N-1)/2次比较，约等于N*N/2次

        特点：
            运行时间和输入无关。无论初始值是什么样子，所消耗的资源都是这样
            数据移动是最少的。即交换次数和数组大小是线性关系
     */
    private static void sort(Comparable[] list) {
        for (int i = 0, minIndex = 0, N = list.length; i < N; ++i) {
            minIndex = i;

            // 找剩余数组中最小值
            for (int j = i + 1; j < N; ++j) {
                if (less(list[j], list[minIndex])) {
                    minIndex = j;
                }
            }

            //交换
            exch(list, i, minIndex);
        }
    }


    public static void main(String[] args) {
        Integer[] array = new Integer[] { 245, 234, 1234, 6, 1, 0, 1 };
        sort(array);
        assert isSorted(array);

        ABaseExample.show(array);
    }

}
