package com.baiiu.leetcode.array;

/**
 * auther: baiiu
 * time: 19/3/16 16 20:48
 * description:
 */
public class Q11_ContainerWithMostWater {


    /**
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
     *
     * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
     */
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        arr = new int[] { 1, 3, 2, 5, 25, 24, 5 };

        System.out.println(maxArea(arr));
        System.out.println(maxArea2(arr));
        System.out.println(maxAreaSimple(arr));
    }

    // O(n*n)
    private static int maxArea(int[] arr) {
        if (arr == null) return -1;

        int maxArea = 0;

        for (int i = 0, length = arr.length; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {
                maxArea = Math.max(maxArea, (j - i) * Math.min(arr[j], arr[i]));
            }
        }


        return maxArea;
    }


    /*
        1. 如果一个值在之前出现过，那么它之后的面积一定比之前的小

     */
    private static int maxArea2(int[] arr) {
        if (arr == null) return -1;

        int maxArea = 0;
        int currentMax = 0;

        for (int i = 0, length = arr.length; i < length; ++i) {
            if (arr[i] < currentMax) {
                continue;
            }

            currentMax = arr[i];
            for (int j = i + 1; j < length; ++j) {
                maxArea = Math.max(maxArea, (j - i) * Math.min(arr[j], arr[i]));
            }
        }


        return maxArea;
    }

    private static int maxAreaSimple(int[] arr) {
        if (arr == null) return -1;

        int maxArea = 0, start = 0, end = arr.length - 1;

        while (start < end) {
            maxArea = Math.max(maxArea, (end - start) * Math.min(arr[end], arr[start]));

            if (arr[start] < arr[end]) {
                ++start;
            } else {
                --end;
            }
        }

        return maxArea;
    }

}