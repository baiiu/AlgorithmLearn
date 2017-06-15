package com.example;

import java.util.Arrays;
import java.util.Stack;

/**
 * author: baiiu
 * date: on 17/6/14 10:56
 * description:
 */
class Question22_StackPushPopOrder {

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
//        int[] input = new int[]{1, 2, 3, 4, 5};
//        int[] output = new int[]{1, 2, 3, 4, 5}; //是
//        int[] output = new int[]{5, 4, 3, 2, 1};//是
//        int[] output = new int[]{4, 5, 3, 2, 1};//是
//        int[] output = new int[]{4, 3, 5, 1, 2};//不是
//        int[] output = new int[]{5, 4, 1, 2, 3};//不是

        int[] input = new int[]{1, 2, 3};
        int[] output = new int[]{3, 1, 2}; //不是
//        int[] output = new int[]{3, 2, 1};
//        int[] output = new int[]{1, 2, 3};
//        int[] output = new int[]{2, 3, 1};
//        int[] output = new int[]{2, 1, 3};


//        System.out.println(judge_Wrong(input, output) ? "是" : "不是");
        System.out.println(isPopOrder(input, output) ? "是" : "不是");

    }

    /*
        判断一个序列是不是栈的弹出序列的规律：
            如果下一个弹出的数字刚好是栈顶数字，那么直接弹出；
            如果不是，则把压榨序列中还没有入栈的数字压入栈中，直到把下一个需要弹出的数字压入栈顶为止。

            如果所有的数字都压入栈了仍然没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列。

        需要一个辅助栈：
            这种思想得要学下，使用额外的辅助工具、手段。不是单纯的数组运算。
     */
    private static boolean isPopOrder(int[] input, int[] output) {
        if (input == null || output == null) return false;
        if (input.length != output.length) return false;
        if (input.length == 1 || input.length == 2) return true;

        int pushIndex = 0, popIndex = 0;

        Stack<Integer> stack = new Stack<>();

        while (popIndex < output.length) {
            int popNumber = output[popIndex];

            while (stack.empty() || stack.peek() != popNumber) {
                if (pushIndex > input.length - 1) {
                    return false;
                }
                stack.push(input[pushIndex]);
                ++pushIndex;
            }

            stack.pop();
            ++popIndex;
        }

        return true;
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
    private static boolean judge_Wrong(int[] input, int[] output) {
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
