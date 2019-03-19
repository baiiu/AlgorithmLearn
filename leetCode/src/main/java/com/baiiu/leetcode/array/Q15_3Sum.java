package com.baiiu.leetcode.array;

import java.util.List;
import java.util.Stack;

/**
 * auther: baiiu
 * time: 19/3/16 16 22:24
 * description:
 */
public class Q15_3Sum {

    /**
     * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     */
    public static void main(String[] args) {
        int[] arr = new int[] { -1, 0, 1, 2, -1, -4 };

        threeSum(arr);
        //System.out.println(threeSum(arr));

    }


    /*
        C(n)(m)

        从一组数字中找到所有和为0的3位数字

        1. 枚举所有3位组合，找到为0的
        2. 递归，选择和为0的3位

        对于每个数字number而言
            1. 包括该数字，将其计入和中，从剩下的n-1个数字中找到和为0-number该数字的
            2. 不包括该数字，从剩下的n-1个数字中找3个
      */
    private static List<List<Integer>> threeSum(int[] arr) {
        if (arr == null) return null;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            findIt(arr, i, 3, stack);
        }

        return null;
    }

    /*
        全组合，start表示当前数字，target表示要找几个数字

         对于每个数字number而言
            1. 包括该数字，将其计入组合中，从剩下的n-1个数字中找到targe-1个
            2. 不包括该数字，从剩下的n-1个数字中找target个
     */
    private static void findIt(int[] arr, int start, int target, Stack<Integer> stack) {
        if (target == 0) {
            //System.out.println(stack);

            int sum = 0;
            for (Integer integer : stack) {
                sum += integer;
            }

            if (sum == 0) {
                System.out.println(stack);
            }
            return;
        }

        if (start > arr.length - 1) {
            return;
        }


        stack.push(arr[start]);
        findIt(arr, start + 1, target - 1, stack); // 剩下数字从start+1开始算
        stack.pop();
        findIt(arr, start + 1, target, stack);

    }


    private static void findIt2(int[] arr, int start, int number, int target, Stack<Integer> stack) {
        if (stack.size() == 3) {
            System.out.println(stack);
            return;
        }

        if (start > arr.length - 1) {
            return;
        }


        stack.push(arr[start]);
        findIt2(arr, start + 1, number, target - arr[number], stack);
        stack.pop();
        findIt2(arr, start + 1, number, target, stack);

    }

}