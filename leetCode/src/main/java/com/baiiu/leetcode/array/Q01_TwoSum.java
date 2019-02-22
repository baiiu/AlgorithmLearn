package com.baiiu.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * auther: baiiu
 * time: 19/2/22 22 07:41
 * description:
 */
public class Q01_TwoSum {
    /**
     * 1. Two Sum
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     */
    public static void main(String[] args) {
        int[] array = new int[] { 1, -1, -3, -9, 2, 1, 4, 7, 11, 15 };
        int target = 2;

        System.out.println(Arrays.toString(twoSum(array, target)));
        System.out.println(Arrays.toString(twoSum2(array, target)));
        System.out.println(Arrays.toString(twoSum3(array, target)));
        System.out.println(Arrays.toString(twoSum4(array, target)));
    }

    // 暴力破解
    private static int[] twoSum(int[] arr, int target) {
        if (arr == null || arr.length <= 1) return null;

        for (int i = 0, length = arr.length; i < length - 1; ++i) {
            for (int j = i + 1; j < length; ++j) {
                if (arr[i] + arr[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        return null;
    }


    private static int[] twoSum2(int[] arr, int target) {
        if (arr == null || arr.length <= 1) return null;

        for (int i = 0, length = arr.length; i < length - 1; ++i) {
            int next = target - arr[i];

            for (int j = i + 1; j < length; ++j) {
                if (arr[j] == next) {
                    return new int[] { i, j };
                }
            }
        }


        return null;
    }

    private static int[] twoSum3(int[] arr, int target) {
        if (arr == null || arr.length <= 1) return null;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0, length = arr.length; i < length; ++i) {
            map.put(arr[i], i);
        }

        for (int i = 0, length = arr.length; i < length; ++i) {
            int key = target - arr[i];

            if (map.containsKey(key) && map.get(key) != i) {
                return new int[] { i, map.get(key) };
            }
        }

        return null;
    }

    private static int[] twoSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
