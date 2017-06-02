package com.example;

/**
 * author: baiiu
 * date: on 17/6/1 11:57
 * description:
 */
class Question09_Fibonacci {

    /**
     * 求斐波那契数列的第n项值
     * <p>
     * <p>
     * f(0) = 0
     * f(1) = 1
     * f(n) = f(n - 1) + f(n - 2)
     * <p>
     * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233 ...
     * <p>
     * 考虑大数溢出情况
     */
    static void test() {
        System.out.println(fibonacci_Resursive(8));
        System.out.println(fibonacci(8));
    }

    // 时间复杂度O(n)
    private static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int sum = 0, sum1 = 0, sum2 = 1;

        for (int i = 1; i < n; ++i) {
            sum = sum1 + sum2;
            sum1 = sum2;
            sum2 = sum;
        }

        return sum;
    }

    // 递归里面有重复计算
    private static int fibonacci_Resursive(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fibonacci_Resursive(n - 1) + fibonacci_Resursive(n - 2);
    }


}
