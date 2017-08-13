package com.example;

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
        combination(2);
    }

    /*

     */
    private static void combination(int maxNumber) {
        int n = 1 << maxNumber;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < maxNumber; ++j) {
                if ((i & (1 << j)) != 0) {
                    builder.append(String.valueOf(i));
                }
            }
            System.out.println(builder.toString());

            builder.delete(0, builder.length());
        }

    }

}
