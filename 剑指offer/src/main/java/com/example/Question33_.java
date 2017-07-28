package com.example;

import com.baiiu.CommonUtil;

/**
 * author: baiiu
 * date: on 17/7/28 09:41
 * description:
 */
public class Question33_ {

    /**
     * 把数组排成最小的数
     * <p>
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印出
     * 能拼接出的所有数字中最小的一个。
     * <p>
     * 例如：输入数组{3,32,321}，则打印出这三个数字能排成的最小数字是321,323
     */
    static void test() {
        int[] ints = new int[]{3, 32, 321};

        minNumber(ints);
//        powerBase10(ints);
    }

    /*
        1. 这几个数字的全排列，找出最小的
     */
    private static void minNumber(int[] numbers) {
        if (CommonUtil.isEmpty(numbers)) return;

        int[] minNumber = new int[]{Integer.MAX_VALUE};
        permutationNumber(numbers, 0, minNumber);

        System.out.println(minNumber[0]);
    }


    private static void permutationNumber(int[] number, int start, int[] minNumber) {
        if (CommonUtil.isEmpty(number)) return;

        if (number.length - 1 == start) {
            int currentNumber = powerBase10(number);
            minNumber[0] = minNumber[0] < currentNumber ? minNumber[0] : currentNumber;
        } else {
            int tmp;

            for (int i = start; i < number.length; i++) {
                // 下面是交换元素的位置
                tmp = number[start];
                number[start] = number[i];
                number[i] = tmp;

                // 处理下一个位置
                permutationNumber(number, start + 1, minNumber); // 剩余部分

                // 恢复原状
                tmp = number[start];
                number[start] = number[i];
                number[i] = tmp;
            }
        }
    }

    private static int powerBase10(int[] number) {
        //{3,32,321} | {32,3,321}


        StringBuilder sb = new StringBuilder();
        for (int i = 0, length = number.length; i < length; ++i) {
            sb.append(number[i]);
        }
        String s = sb.toString();

        int[] ints = new int[s.length()];
        for (int i = 0, length = s.length(); i < length; ++i) {
            ints[i] = sb.charAt(i) - '0';
        }

        int result = 0;
        for (int i = 0, length = ints.length; i < length; ++i) {
            result = ints[i] + result * 10;
        }

        return result;
    }


}
