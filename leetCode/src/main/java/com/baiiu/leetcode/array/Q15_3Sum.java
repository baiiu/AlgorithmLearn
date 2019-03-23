package com.baiiu.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        //int[] arr = new int[] {
        //        6, -5, -6, -1, -2, 8, -1, 4, -10, -8, -10, -2, -4, -1, -8, -2, 8, 9, -5, -2, -8, -9, -3, -5
        //};
        //int[] arr = new int[] {
        //        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        //};

        //System.out.println(threeSum(arr));
        //System.out.println(threeSum2(arr));
        System.out.println(threeSum3(arr));
    }


    /*
        思路独特，选定一个，而不是选定两个，剩下的两个遍历

        -4, -1, -1, 0, 1, 2
     */
    private static List<List<Integer>> threeSum3(int[] arr) {
        if (arr == null) return null;
        Arrays.sort(arr);

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < arr.length - 2; i++) {

            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int sum = 0 - arr[i];
            int start = i + 1, end = arr.length - 1;

            while (start < end) {

                if (arr[start] + arr[end] == sum) {
                    list.add(Arrays.asList(arr[i], arr[start], arr[end]));

                    // 还得继续向下遍历，去找下一个start和end
                    while (start < end && arr[start] == arr[start + 1]) ++start;
                    while (start < end && arr[end] == arr[end - 1]) --end;
                    ++start;
                    --end;
                } else if (arr[start] + arr[end] < sum) {
                    ++start;
                } else {
                    --end;
                }

            }
        }


        return list;
    }

    /*
        Cnm耗费时间，考虑其他方式。
        先将数组排序，即转变成 在一个有序数组里找出3个数相加等于0

        因为是有序的，所以就不用挨个找，直接从两头开始找就行，所以能屏蔽大部分无效计算

        -4, -1, -1, 0, 1, 2

        比如将-4入栈，再将2入栈，接下来只要找到2就行。但是2已经是最大，所以该计算被丢弃。从头开始。
     */

    private static List<List<Integer>> threeSum2(int[] arr) {
        if (arr == null) return null;


        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));

        int start = 0, end = arr.length - 1;
        Stack<Integer> stack = new Stack<>();

        while (end - start >= 2) {
            stack.push(arr[start]);

            for (int j = end; j > start; --j) {
                stack.push(arr[j]);
                int forTarget = 0 - (arr[start] + arr[j]);

                int binarySearch = Arrays.binarySearch(arr, start + 1, j, forTarget);
                if (binarySearch > 0) {
                    stack.push(forTarget);

                    List<Integer> integers = new ArrayList<>(stack);
                    Collections.sort(integers);

                    if (!list.contains(integers)) {
                        list.add(integers);
                    }

                    stack.pop();
                }

                //for (int i = start + 1; i < j; ++i) {
                //    if (arr[i] == forTarget) {
                //        stack.push(forTarget);
                //        System.out.println(stack);
                //        stack.pop();
                //        break;
                //    }
                //}
                stack.pop();
            }

            start++;
            stack.clear();
        }
        return list;

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

        List<List<Integer>> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < arr.length; i++) {
            //findIt2(arr, i, 0, stack, list);
            findIt3(arr, i, 0, stack, list);
            //findIt(arr, i, 3, stack);
        }

        return list;
    }


    private static void findIt3(int[] arr, int start, int target, Stack<Integer> stack, List<List<Integer>> list) {
        if (stack.size() == 2) {
            boolean found = false;
            for (; start < arr.length; ++start) {
                if (arr[start] == target) {
                    found = true;
                    stack.push(target);
                    break;
                }
            }

            if (found) {
                List<Integer> integers = new ArrayList<>(stack);
                stack.pop();
                Collections.sort(integers);

                if (list.contains(integers)) {
                    return;
                }
                list.add(integers);
            }

            return;
        }

        if (start > arr.length - 1) {
            return;
        }

        stack.push(arr[start]);
        findIt3(arr, start + 1, target - arr[start], stack, list);
        stack.pop();
        findIt3(arr, start + 1, target, stack, list);
    }

    // target表示当前要找到几
    // -1, 0, 1, 2, -1, -4
    private static void findIt2(int[] arr, int start, int target, Stack<Integer> stack, List<List<Integer>> list) {
        if (stack.size() == 3 && target == 0) {
            List<Integer> integers = new ArrayList<>(stack);
            Collections.sort(integers);

            if (list.contains(integers)) {
                return;
            }
            list.add(integers);
            return;
        }

        if (start > arr.length - 1) {
            return;
        }

        stack.push(arr[start]);
        findIt2(arr, start + 1, target - arr[start], stack, list);
        stack.pop();
        findIt2(arr, start + 1, target, stack, list);
    }

    /*
        全组合，start表示当前数字，target表示要找几个数字

         对于每个数字number而言
            1. 包括该数字，将其计入组合中，从剩下的n-1个数字中找到targe-1个
            2. 不包括该数字，从剩下的n-1个数字中找target个
     */
    private static void findIt(int[] arr, int start, int target, Stack<Integer> stack) {
        if (target == 0) {
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

}