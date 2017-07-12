package com.baiiu;

import java.util.Arrays;
import java.util.Collection;

/**
 * auther: baiiu
 * time: 17/4/9 09 10:05
 * description:
 */
@SuppressWarnings("WeakerAccess")
public class CommonUtil {

    public static boolean isEmpty(int[] array) {
        return array == null || array.length == 0 || array.length == 1;
    }

    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0 || array.length == 1;
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean arrayContains(Integer[] array, int target) {
        if (isEmpty(array)) return false;

        for (int i = 0, length = array.length; i < length; i++) {
            if (array[i] == null) continue;

            if (array[i] == target) {
                return true;
            }
        }

        return false;
    }

    /**
     * 交换数组中两个元素
     */
    public static void swap(int[] array, int i, int j) {
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

    public static void printArray(int[] array) {
        if (array == null) {
            return;
        }

        System.out.println(Arrays.toString(array));
    }

    /**
     * 打印链表
     */
    public static void printNodeList(Node node) {
        while (node != null) {
            System.out.print(node);
            node = node.next;
        }
    }

    /**
     * 是否从小到大排序
     */
    public static void isSorted(int[] array) {
        for (int i = 1, length = array.length; i < length; i++) {
            if (array[i] < array[i - 1]) {
                throw new IllegalStateException("array is not sorted");
            }
        }
    }


    // test方法
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        printArray(array);

        swap(array, 0, 2);

        printArray(array);
        isSorted(array);
    }

}
