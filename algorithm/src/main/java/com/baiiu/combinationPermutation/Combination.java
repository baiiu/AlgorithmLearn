package com.baiiu.combinationPermutation;

import java.util.Stack;

/**
 * auther: baiiu
 * time: 17/8/13 13 14:30
 * description: 组合
 * <p>
 * 输入一个字符串，输出该字符串中字符的所有组合。举个例子，如果输入abc，它的组合有a、b、c、ab、ac、bc、abc。
 */
public class Combination {

    /*
        2^n -1 个
     */
    public static void main(String[] args) {
        String s = "abc";
        combination_bit(s.toCharArray());

//        combination(s.toCharArray());
    }

    /*
        共有 2^n -1 中组合

        使用位运算， 001表示a, 010表示b， 100表示c

        遍历 [1, 2^n) 个数字，对每个数字进行位运算，找出所有组合

        O(2^n) 指数级
     */
    private static void combination_bit(char[] chars) {
        if (chars == null || chars.length == 0) return;

        int length = chars.length;
        int n = 1 << length;

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < length; ++j) {
                if ((i & (1 << j)) != 0) { // 001 010 100
                    builder.append(chars[j]);
                }
            }
            System.out.println(builder.toString());

            builder.delete(0, builder.length());
        }
    }

    /*
        在长度为n的字符串中求m个字符的组合, 1 <= m <= n。我们先从头扫描字符串的第一个字符。

        针对第一个字符，我们有两种选择：
            第一是把这个字符放到组合中去，接下来我们需要在剩下的n-1个字符中选取m-1个字符；
            第二是不把这个字符放到组合中去，接下来我们需要在剩下的n-1个字符中选择m个字符。
            这两种选择都很容易用递归实现。
     */
    private static void combination(char[] chars) {
        if (chars == null || chars.length == 0) return;

        Stack<Character> stack = new Stack<>();
        for (int i = 1, length = chars.length; i <= length; ++i) {
            combination(chars, 0, i, stack);
        }
    }

    /*
        start指从哪开始，即 n 还是 n - 1个字符
        number是指几位组合， 1位组合还是n位组合
     */
    private static void combination(char[] chars, int start, int number, Stack<Character> stack) {
        if (number == 0) {
            System.out.println(stack.toString());
            return;
        }

        if (start == chars.length) {
            return;
        }

        stack.push(chars[start]);
        combination(chars, start + 1, number - 1, stack);
        stack.pop();
        combination(chars, start + 1, number, stack);
    }
}
