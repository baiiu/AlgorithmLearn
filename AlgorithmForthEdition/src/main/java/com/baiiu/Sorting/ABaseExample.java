package com.baiiu.Sorting;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * author: baiiu
 * date: on 16/12/28 11:14
 * description: 模板代码
 *
 * 将数据操作限制在sort()和less()这两个方法中使得代码的可读性和可移植性更好，
 * 更容易验证代码的正确性、分析性能以及排序算法之间的比较。
 */

public class ABaseExample {

    public static void sort(Comparable[] list) {

    }

    /**
     * a是否小于b
     */
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    /**
     * 交换i和j
     */
    public static void exch(Comparable[] list, int i, int j) {
        Comparable comparable = list[i];
        list[i] = list[j];
        list[j] = comparable;
    }

    /**
     * 打印数组
     */
    public static void show(Comparable[] list) {
        for (int i = 0, length = list.length; i < length; ++i) {
            StdOut.print(list[i] + " ");
        }
    }

    /**
     * 是否从小到大排序
     */
    public static boolean isSorted(Comparable[] list) {
        for (int i = 1, length = list.length; i < length; i++) {
            if (less(list[i], list[i - 1])) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String[] strings = StdIn.readAllStrings();
        sort(strings);
        assert isSorted(strings);
        show(strings);
    }

}
