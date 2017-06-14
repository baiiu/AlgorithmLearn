package com.example;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * author: baiiu
 * date: on 17/6/13 11:27
 * description:
 */
class Question21_MinInStack {

    /**
     * 定义栈的数据结构，并在该类型中实现一个能够得到栈的最小元素的min函数
     * 并且在该栈中，调用min、push、pop的时间复杂度都是O(1)
     */
    static void test() {
        StackWithMin stack = new StackWithMin();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.toString());
        System.out.println(stack.min());

        stack.pop();
        stack.pop();
        stack.push(0);
        stack.push(-1);

        System.out.println(stack.toString());
        System.out.println(stack.min());

        stack.pop();
        System.out.println(stack.min());
    }

    /*
        定义一个数组存储响应的最小值
     */
    private static class StackWithMin {
        private int[] elements;
        private int[] minElements;

        private int size = 0;

        public StackWithMin() {
            this.elements = new int[10];
            this.minElements = new int[10];
        }

        public void push(int number) {
            //ignore ensureCapicity
            if (size >= 10) return;

            elements[size] = number;

            if (size == 0) {
                minElements[size] = number;
            } else {
                int minElementTop = minElements[size - 1];
                minElements[size] = minElementTop < number ? minElementTop : number;
            }

            ++size;
        }

        public int pop() {
            if (size == 0) throw new EmptyStackException();

            --size;
            return elements[size];
        }

        public int min() {
            if (size == 0) throw new EmptyStackException();

            return minElements[size - 1];
        }

        @Override
        public String toString() {
            return "elements :" + Arrays.toString(elements) + "\n"
                    + "minElements :" + Arrays.toString(minElements);
        }

    }

}
