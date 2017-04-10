package com.baiiu.Sorting;

import static com.baiiu.Sorting.ABaseExample.exch;
import static com.baiiu.Sorting.ABaseExample.isSorted;
import static com.baiiu.Sorting.ABaseExample.less;
import static com.baiiu.Sorting.ABaseExample.show;

/**
 * author: baiiu
 * date: on 16/12/28 15:44
 * description:插入排序
 *
 * 在一个有序数组中插入元素，移动其后的元素，这就是插入排序。
 *
 * ⒈ 从第一个元素开始，该元素可以认为已经被排序
 * ⒉ 取出下一个元素，在已经排序的元素序列中从后向前扫描
 * ⒊ 如果该元素（已排序）大于新元素，将该元素移到下一位置
 * ⒋ 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * ⒌ 将新元素插入到下一位置中
 * ⒍ 重复步骤2~5
 */

public class InsertSort {

    /*
        插入排序所需的时间取决于输入元素中起始状态

        对于随机排列的长度为 N 且主键不重复的数组，
        平均情况下插入排序需要～ N2/4 次比较以及～ N2/4 次交换。
        最坏情况下需要～ N2/2 次比较和～ N2/2 次交换，
        最好情况下需要 N-1次比较 和 0次交换
     */
    public static void sort(Comparable[] list) {

        for (int i = 1, N = list.length; i < N; ++i) {

            //从第i位往前排序，确保第i位之前是有序的
            for (int j = i; j > 0; --j) {
                if (less(list[j], list[j - 1])) {
                    exch(list, j, j - 1);
                }
            }

        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[] { 245, 234, 1234, 6, 1, 0, 1 };
        sort(array);
        assert isSorted(array);

        show(array);
    }

}
