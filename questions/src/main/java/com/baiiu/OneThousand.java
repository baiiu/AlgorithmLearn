package com.baiiu;

import java.util.Random;

/**
 * auther: baiiu
 * time: 17/4/11 11 22:14
 * description:
 * 1001个位置中，放置(0，1000]，总有一个数是相同的。求该数
 */
public class OneThousand {

    public static void main(String[] args) {
        int[] arr = new int[11];

        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }

        Random random = new Random();
        int number = random.nextInt(10) + 1;
        arr[10] = number;
        System.out.println("random: " + number);
        //arr[10] = 9;


        findRepeat(arr);

        CommonUtil.printArray(arr);
    }

    /**
     * 寻找在数组中重复的数字，使用堆来处理
     *
     * 构造堆时就可以找到
     */
    private static void findRepeat(int[] arr) {
        int length = arr.length;
        int lastNode = (length - 2) / 2;//最后一个非叶子节点

        for (int i = lastNode; i >= 0; --i) {
            maxHeapify(arr, i, length);
        }

        for (int i = length - 1; i >= 0; --i) {
            CommonUtil.swap(arr, 0, i);
            maxHeapify(arr, 0, i);
        }

    }

    //最大堆构造,然而找不出来相同数。可以使用归并，两两比较的，分治
    private static void maxHeapify(int[] arr, int index, int length) {
        int leftIndex, rightIndex, maxIndex;
        while (true) {


            leftIndex = 2 * index + 1;
            rightIndex = 2 * index + 2;
            maxIndex = index;

            //if (leftIndex < length && arr[maxIndex] == arr[leftIndex]) {
            //    System.out.println(maxIndex + " --- " + arr[maxIndex]);
            //}
            //
            //if (rightIndex < length && arr[maxIndex] == arr[rightIndex]) {
            //    System.out.println(maxIndex + " --- " + arr[maxIndex]);
            //}

            if (leftIndex < length && arr[maxIndex] < arr[leftIndex]) {
                maxIndex = leftIndex;
            }

            if (rightIndex < length && arr[maxIndex] < arr[rightIndex]) {
                maxIndex = rightIndex;
            }


            if (index == maxIndex) {
                break;
            } else {
                CommonUtil.swap(arr, maxIndex, index);
                index = maxIndex;
            }

        }

    }

}
