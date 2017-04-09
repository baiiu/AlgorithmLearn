package com.baiiu;

/**
 * auther: baiiu
 * time: 17/4/9 09 13:40
 * description:
 */
class BinaryInsertionSort {

    static void binaryInsertionSort(int[] array) {
        if (array == null || array.length == 1) return;

        int temp, left, right, middle;
        for (int i = 1, size = array.length; i < size; i++) {
            temp = array[i];
            left = 0;
            right = i - 1;

            while (left <= right) {
                middle = (left + right) / 2;
                if (array[middle] > temp) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }

            for (int j = i - 1; j >= left; j--) {
                array[j + 1] = array[j];
            }

            array[left] = temp;
        }

    }



    //static void binaryInsertionSort(int[] array) {
    //    if (array == null || array.length == 1) return;
    //
    //    for (int i = 1, j, temp, size = array.length; i < size; ++i) {
    //
    //        if (array[i] < array[i - 1]) {
    //
    //            temp = array[i];
    //            j = i - 1;
    //
    //            int targetJ = binarySearch(array, 0, i - 1, array[i]);
    //
    //            while (j >= targetJ) {
    //                array[j + 1] = array[j];
    //                --j;
    //            }
    //
    //            array[targetJ] = temp;
    //        }
    //    }
    //
    //}

    // 寻找target应该被放置的位置
    //static int binarySearch(int[] arr, int low, int high, int khey) {
    //    if (low > high) {
    //        return low;
    //    }
    //
    //    int mid = (low + high) / 2;
    //
    //    if (arr[mid] > khey) {
    //        return binarySearch(arr, low, mid - 1, khey);
    //    }
    //
    //    if (arr[mid] < khey) {
    //        return binarySearch(arr, mid + 1, high, khey);
    //    }
    //
    //    return mid;
    //}

}
