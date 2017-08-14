package com.baiiu.combinationPermutation;

import java.util.Stack;

/**
 * auther: baiiu
 * time: 17/8/13 13 22:47
 * description:
 * <p>
 * 输入两个整数n和m，从数列1,2,3...n中随意取几个数，使其和等于m，要求列出所有的组合。
 */
public class EqualsMCombination {

    public static void main(String[] args) {
//        findSumIsM(5, 12);
        System.out.println();
        System.out.println();
        findSumIsM_Simple(5, 16);
    }

    private static void findSumIsM_Simple(int n, int m) {
        if (m > ((1 + n) * n / 2)) {
            System.out.println("m太大了");
        }

        Stack<Integer> stack = new Stack<>();
        findIt_Simple(n, m, stack);
    }

    /*
        从最大值开始开始寻找，即从n开始

        对于每个n，都有两种选择：
            1. 将即计入和m中，在剩下的n-1个数字中继续寻找和为 n-m 的数字
            2. 不计算于其中，在剩下的 n-1 个数字中寻找和为m 的数字

        终止条件： m==0(找完了)
                 n<0 || m<0 (找不到)
     */
    private static void findIt_Simple(int n, int m, Stack<Integer> stack) {
        if (n < 0 || m < 0) {
            return;
        }

        if (m == 0) {
            System.out.println(stack);
            return;
        }


        stack.push(n);
        findIt_Simple(n - 1, m - n, stack);
        stack.pop();
        findIt_Simple(n - 1, m, stack);

    }


    /*
        [1,n] 中，获取所有的组合，输出和为m的组合

        分两步：
            1. 获取所有组合 (就可以使用之前字符串组合的方式)
            2. 输出所有和为m的组合

        在n个数字中选取m个数字(1<=m<=n), 从1开始遍历数列，针对第一个数字：
           将这个数字放到组合中，在剩下的 n-1个 数字中选取m - 1个
           不把这个数字放到组合中，在剩下的 n-1 个 数字中选取m个
     */
    private static void findSumIsM(int n, int m) {
        if (m > ((1 + n) * n / 2)) {
            System.out.println("m太大了");
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= n; ++i) {
            findIt(n, 1, i, stack, m);
        }
    }

    private static void findIt(int n, int start, int number, Stack<Integer> stack, int targetSum) {
        if (number == 0) {
            int sum = 0;
            for (Integer integer : stack) {
                sum += integer;
            }

            if (sum == targetSum) {
                System.out.println(stack);
            }

            return;
        }

        if (start == n + 1) {
            return;
        }

        stack.push(start);
        findIt(n, start + 1, number - 1, stack, targetSum);
        stack.pop();
        findIt(n, start + 1, number, stack, targetSum);
    }

}
