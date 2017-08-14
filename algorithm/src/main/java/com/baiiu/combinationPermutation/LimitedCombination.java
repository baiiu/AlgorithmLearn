package com.baiiu.combinationPermutation;

import java.util.Stack;

/**
 * auther: baiiu
 * time: 17/8/13 13 15:26
 * description:
 * <p>
 * Given two integers n and k,
 * return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * 从[1...n]中选取k个数的所有组合
 */
public class LimitedCombination {

    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        Stack<Integer> stack = new Stack<>();

        combination(n, 0, k, stack);
    }


    /*
        从n个数中选取k个数，从第一个数开始
            1) 选择将其放入组合内，从剩下的 n-1 个数中选取 k-1 个数
            2) 不将其放入组合内，从剩下的 n-1 个数中 选取 k 个数
     */
    private static void combination(int n, int start, int number, Stack<Integer> stack) {
        if (number == 0) {
            System.out.println(stack);
            return;
        }

        if (start == n + 1) {
            return;
        }

        stack.push(start);
        combination(n, start + 1, number - 1, stack);
        stack.pop();
        combination(n, start + 1, number, stack);
    }

}
