package com.baiiu.Sorting;

import static com.baiiu.Sorting.ABaseExample.isSorted;
import static com.baiiu.Sorting.ABaseExample.show;

/**
 * author: baiiu
 * date: on 16/12/28 19:06
 * description: 希尔排序
 */

public class ShellSort {

    public static void sort(Comparable[] list) {


    }


    public static void main(String[] args) {
        Integer[] array = new Integer[] { 245, 234, 1234, 6, 1, 0, 1 };
        sort(array);
        assert isSorted(array);

        show(array);
    }

}
