package com.baiiu;

/**
 * auther: baiiu
 * time: 17/4/9 09 10:59
 * description:
 */
public class TestSort {

    public static void main(String[] args) {
        int[] array = new int[] { 5, 0, 10, 0, 2, 6, 9, 7, 8, -1 };

        //BubbleSort.simpleSwapSort(array);
        //BubbleSort.bubbleSort(array);
        //BubbleSort.bubbleSortBetter(array);

        //SimpleSelectionSort.simpleSelectionSort(array);

        //StraightInsertionSort.straightInsertionSort(array);
        //StraightInsertionSort.straightInsertionSort2(array);

        //BinaryInsertionSort.binaryInsertionSort(array);

        //ShellSort.shellSort(array);

        HeapSort.heapSort(array);

        CommonUtil.printArray(array);

    }

}
