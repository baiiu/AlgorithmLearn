package com.baiiu.sort;

import com.baiiu.CommonUtil;

/**
 * auther: baiiu
 * time: 17/4/9 09 10:59
 * description:
 */
class TestSort {

    public static void main(String[] args) {
        int[] array = new int[]{5, 0, 10, 0, 2, 6, 9, 7, 8, -1, 3};//11

        //BubbleSort.simpleSwapSort(array);
        //BubbleSort.bubbleSort(array);
        //BubbleSort.bubbleSortBetter(array);

        //SimpleSelectionSort.simpleSelectionSort(array);

        //StraightInsertionSort.straightInsertionSort(array);
        //StraightInsertionSort.straightInsertionSort2(array);

        //BinaryInsertionSort.binaryInsertionSort(array);

        //ShellSort.shellSort(array);

        HeapSort.heapSort(array);

//        MergeSort.mergeSort(array);
        //MergeSortWhile.mergeSort(array);

        //QuickSort.quickSort(array);
        //QuickSortWithInsertSort.quickSortWithInsertSort(array);

        //array = CountSort.countSort(array);

//        BucketSort.bucketSort(array, 5);


        //RadixSort.radixSort(array); //需要对负数进行单独处理。

        CommonUtil.printArray(array);
        CommonUtil.isSorted(array);

    }

}
