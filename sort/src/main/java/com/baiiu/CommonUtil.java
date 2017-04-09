package com.baiiu;

import java.util.Arrays;

/**
 * auther: baiiu
 * time: 17/4/9 09 10:05
 * description:
 */
public class CommonUtil {

    /**
     * 交换数组中两个元素
     */
    static void swap(int[] array, int i, int j) {
        // @formatter:off
        if (array == null
                || i > array.length - 1 || j > array.length - 1
                || i < 0 || j < 0
                || i == j) {
            return;
        }
        // @formatter:on

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static void printArray(int[] array) {
        if (array == null) {
            return;
        }

        System.out.println(Arrays.toString(array));
    }

    // test方法
    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 3, 4, 5 };
        printArray(array);
        swap(array, 0, 2);
        printArray(array);
    }

}
