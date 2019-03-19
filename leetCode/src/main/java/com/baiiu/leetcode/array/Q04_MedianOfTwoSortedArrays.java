package com.baiiu.leetcode.array;

/**
 * auther: baiiu
 * time: 19/3/11 11 22:47
 * description:
 */
public class Q04_MedianOfTwoSortedArrays {

    /**
     * 4.There are two sorted arrays nums1 and nums2 of size m and n respectively.
     * Find the median of the two sorted arrays.
     * The overall run time complexity should be O(log (m+n)).You may assume nums1 and nums2 cannot be both empty.
     *
     * nums1 = [1, 2]  nums2 = [3, 4] The median is (2 + 3)/2 = 2.5
     * nums1 = [1, 3]  nums2 = [2] The median is 2.0
     */
    public static void main(String[] args) {
        int[] arr1 = new int[] { 1, 2 };
        int[] arr2 = new int[] { 3, 4, 5, 6 };

        System.out.println(findMedian(arr1, arr2));
        System.out.println(findMedianOnce(arr1, arr2));
    }


    // O(n)空间+O(n)时间
    private static float findMedian(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            return -1;
        }

        int[] arr = new int[arr1.length + arr2.length];

        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                ++i;
            } else {
                arr[k] = arr2[j];
                ++j;
            }
            ++k;
        }
        while (i <= arr1.length - 1) {
            arr[k] = arr1[i];
            ++i;
            ++k;
        }
        while (j <= arr2.length - 1) {
            arr[k] = arr2[j];
            ++j;
            ++k;
        }

        int mid = (arr.length - 1) / 2;
        if (arr.length % 2 == 0) {
            return (arr[mid] + arr[mid + 1]) / 2f;
        } else {
            return arr[mid];
        }
    }


    /*
        二分查找是怎么查的：
        while(start <= end){
            mid = (start + end) / 2;
            if (arr[mid] > target){
                end = mid - 1;
            } else if (arr[mid] < target){
                start = mid + 1;
            } else{
                return mid;
            }
        }

        中位数

        四个指针，从两端开始分别前进，前进 < k/2步
     */
    private static float findMedianOnce(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            return -1;
        }

        int arr1Start = 0, arr2Start = 0;
        int arr1End = arr1.length - 1, arr2End = arr2.length - 1;

        int k = (arr1.length + arr2.length - 1) / 2;


        for (int i = 0; i < k; ++i) {
            if (arr1[arr1Start] < arr2[arr2Start]) {
                ++arr1Start;
            } else {
                ++arr2Start;
            }

            if (arr1[arr1End] > arr2[arr2End]) {
                --arr1End;
            } else {
                --arr2End;
            }
        }


        int x = Math.max(arr1[arr1Start], arr2[arr2Start]);
        int y = Math.min(arr1[arr1End], arr2[arr2End]);


        return (x + y) / 2f;
    }

}
