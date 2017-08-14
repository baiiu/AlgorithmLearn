package com.baiiu.combinationPermutation;

import com.baiiu.CommonUtil;

/**
 * auther: baiiu
 * time: 17/8/14 14 07:12
 * description:
 * <p>
 * 八皇后问题：
 * 在8×8的国际象棋上摆放八个皇后，使其不能相互攻击，
 * 即任意两个皇后不得处在同一行、同一列或者同一对角斜线上。
 * <p>
 * 求出总共有多少种摆法
 */
public class EightQueue {
    public static void main(String[] args) {
        int[] ints = new int[]{0, 1, 2, 3, 4, 5, 6, 7};

        sortQueue(ints, 0);
    }

    /*
        在[0,8)的数组上，第i个位置上的数字j表示(第i行，第j列)

        0 <= i < 8
        0 <= j < 8

        即j的全排列，每个i上可以放置[0,8)个数字，

        共有8!种方法，排除掉：
            处于同一行的 --> 不可能，在设置的时候就有8个位置了
            处于同一列的 --> 任意两个i上的数字相同，也是不可能的
            任意两个皇后处于同一对角线的 --> arr[i] - i相等了
     */
    private static void sortQueue(int[] ints, int start) {
        if (start == ints.length - 1) {
            // 过滤
            if (isDiagonal(ints)) {
                return;
            }

            CommonUtil.printArray(ints);

        } else {
            for (int i = start, length = ints.length; i < length; ++i) {
                CommonUtil.swap(ints, start, i);
                sortQueue(ints, start + 1);
                CommonUtil.swap(ints, start, i);
            }
        }
    }

    private static boolean isDiagonal(int[] arr) {

        for (int i = 0, length = arr.length; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {

                if (arr[i] - arr[j] == i - j || arr[i] - arr[j] == j - i) {
                    return true;
                }

            }
        }

        return false;
    }


}
