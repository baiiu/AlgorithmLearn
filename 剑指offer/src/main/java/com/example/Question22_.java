package com.example;

import java.util.Arrays;

/**
 * author: baiiu
 * date: on 17/6/14 10:56
 * description:
 */
class Question22_ {

    /**
     * 栈的压入、弹出序列
     * <p>
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序，
     * 假设入栈的所有数字均不相等。
     * <p>
     * 例如：
     * 序列1，2，3，4，5是某栈的压栈序列，则4，5，3，2，1是该压栈序列对应的一个弹出序列，
     * 但4，3，5，1，2就不可能是该压栈序列的弹出序列。
     */
    static void test() {
        int[] input = new int[]{1, 2, 3, 4, 5};
//        int[] output = new int[]{5, 4, 3, 2, 1};
//        int[] output = new int[]{4, 5, 3, 2, 1};
//        int[] output = new int[]{4, 3, 5, 1, 2};
        int[] output = new int[]{5, 4, 1, 2, 3};


        System.out.println(judge(input, output) ? "是" : "不是");
    }

    /*
        这种算法是错的。

        有一个不成熟的想法，

        有1个元素时，即弹出序列
        有2个元素时，弹出序列即(x,y)、(y,x)
        有3个元素(x,y,z)时，共有6种组合，其中只有(z,x,y)是不可能的
        有4个元素(a,b,c,d)时，共24种组合，其中
            d为首的序列只有(d,c,b,a)满足。#在这块错了#
            c为首的序列则输入是(a,b,d)，成三个输入，依照之前所述，只有(d,a,b)是不可能的
            b(输入为a,c,d)、a(输入为b,c,d)为首的序列都可以此推理

        由此可见，将输入输出序列删除到3个值，就可以判断出来。
     */
    private static boolean judge(int[] input, int[] output) {
        if (input == null && output == null) return true;
        if (input == null || output == null) return false;
        if (input.length != output.length) return false;
        if (input.length == 1 || input.length == 2) return true;


        int[] input3 = new int[3];
        int[] output3 = new int[3];

        if (input.length == 3) {
            input3 = input;
            output3 = output;
        } else {
            //开始删除至3,在两个序列中删除output的开头元素
            int deleteCount = input.length - 3;

            // 所有数字均不相等
            for (int i = 2; i >= 0; --i) {
                output3[i] = output[i + deleteCount];
            }

            for (int i = 0, index = 0, length = input.length; i < length; ++i) {
                int number = input[i];

                // number in output[0...deleteCount]
                if (outputContainsNumber(output, deleteCount, number))
                    continue;

                input3[index] = number;
                ++index;
            }
        }

        System.out.println(Arrays.toString(input3) + "\n" + Arrays.toString(output3));

        //noinspection RedundantIfStatement
        if (output3[0] == input3[2]
                && output3[1] == input3[0]
                && output3[2] == input3[1]) {
            return false;
        }

        return true;


    }

    private static boolean outputContainsNumber(int[] output, int deleteCount, int number) {
        if (output == null || deleteCount > output.length) return true;

        for (int i = 0; i < deleteCount; ++i) {
            if (output[i] == number) return true;
        }

        return false;
    }


}
