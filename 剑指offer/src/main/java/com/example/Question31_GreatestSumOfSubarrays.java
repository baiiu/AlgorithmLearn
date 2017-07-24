package com.example;

import com.baiiu.CommonUtil;

/**
 * author: baiiu
 * date: on 17/7/14 11:37
 * description:
 */
class Question31_GreatestSumOfSubarrays {
    /**
     * 连续子数组的最大和
     * <p>
     * 输入一个整型数组，数组里有正数和负数。
     * 数组中一个或连续多个数字组成一个子数组，求所有子数组的最大值。
     * <p>
     * 要求时间复杂度为O(n)
     * <p>
     * 例如：输入{1,-2,3,10,-4,7,2,-5}的最大子数组为{3,10,-4,7,2}，因此最大和为18
     */
    static void test() {
        int[] arr = new int[]{1, -2, 3, 10, -4, 7, 2, -5}; // length=8
//        int[] arr = new int[]{1, -2};

        findSum(arr);
        findSum_Foreach(arr);
    }


    /*
       2. 相加后的和为正，为负，为0。
        保留上一次的最大值，不停更新。

        最大和：
            正数和子数组+正数和字数则 会变得更大

            如果和为负的子数组则就要重新开始。因为不能继续累加了。并且前期的最大值已经记录下来了，
            所以只需用遇到更大的值进行更新即可。


        要想想到这种解法，就得逐步耐心分析相加的过程。

        O(n)
    */
    private static void findSum(int[] arr) {
        if (CommonUtil.isEmpty(arr)) return;


        /*
            这种算法不对，直接进行相邻的添加，忽略了负数之后为正数更大的情况
            更应该计算子数组的和后相比
          */
//        int sum = arr[0], tempSum = arr[0];
//        for (int i = 1; i < arr.length; ++i) {
//            tempSum += arr[i];
//
//            if (tempSum <= sum) { //直接进行相邻的添加了，判断条件不对
//                tempSum = arr[i];
//            }
//
//            if (tempSum > sum) {
//                sum = tempSum;
//            }
//        }

        int currentSum = 0, largestSum = Integer.MIN_VALUE;

        for (int i = 0, length = arr.length; i < length; ++i) {
            if (currentSum <= 0) {
                /*
                    和为负数的情况下，重新开始。

                    前面的子数组的和为负，单个值的话所有负数相加只会更小
                 */
                currentSum = arr[i];
            } else {
                currentSum += arr[i];
            }

            if (currentSum > largestSum) { //保存上一个最大值
                largestSum = currentSum;
            }
        }

        System.out.println(largestSum);
    }

    /*
       1. 穷举，计算所有子数组的和，长度为n数组的所有子数组共有 n(n + 1)/2
             长度为1的子数组有 n个
                  2         n-1
                  3         n-2
                  i         n+1-i
                  n          1

        O(n*n*n)
    */
    private static void findSum_Foreach(int[] arr) {
        if (CommonUtil.isEmpty(arr)) return;

        int sum = 0;

        for (int step = 1, length = arr.length; step <= length; ++step) {

            System.out.println("长度为： " + step + " 的子数组为：");

            for (int i = 0; i <= length - step; ++i) {
                int tempSum = 0; //每个子数组的和

                System.out.print("[ ");
                for (int j = i; j < i + step; ++j) {
                    tempSum += arr[j];
                    System.out.print(arr[j]);

                    if (j < i + step - 1) {
                        System.out.print(" ,");
                    }
                }
                System.out.print(" ]");

                sum = sum > tempSum ? sum : tempSum;

                System.out.print(" , ");
            }

            System.out.println();
            System.out.println("----------------------------");
        }

        System.out.println(sum);

    }


}
