package com.example;

import java.util.Stack;

/**
 * author: baiiu
 * date: on 17/5/31 10:26
 * description:
 */
class Question07_QueueWithTwoStacks {

    /**
     * 用两个栈实现一个队列
     * <p>
     * 队列的声明如下：请实现它的两个函数appendTail(队列尾部插入结点)和deleteHead(队列头部删除结点)。
     */
    static void test() {
        /*
            栈：先进后出，后进先出
            队列：先进先出
         */

        Queue queue = new Queue();
        queue.appendTail("1");
        queue.appendTail("2");
        queue.appendTail("3");
        queue.appendTail("4");

        queue.deleteHead();
        queue.deleteHead();

        queue.appendTail("5");
        queue.appendTail("6");

        queue.deleteHead();
        queue.deleteHead();
        queue.deleteHead();
        queue.deleteHead();
        queue.deleteHead();
        queue.deleteHead();
    }

    private static class Queue {
        private Stack<String> stackAppendTail = new Stack<>();
        private Stack<String> stackDeleteHead = new Stack<>();

        // 插入到队尾
        void appendTail(String element) {
            stackAppendTail.push(element);
        }

        // 从队首取出元素
        String deleteHead() {
            /*
                如果stackDeleteHead中无元素，则从stackAppendTail弹出所有元素放入其中

                如果stackDeleteHead中有元素，则从其中取出。
             */
            if (stackDeleteHead.empty()) {
                if (stackAppendTail.empty()) {
                    System.out.println("没数据啦");
                } else {
                    while (!stackAppendTail.empty()) {
                        String pop = stackAppendTail.pop();
                        stackDeleteHead.push(pop);
                    }
                }
            }

            if (stackDeleteHead.empty()) {
                System.out.println("没数据啦");
                return null;
            }
            String pop = stackDeleteHead.pop();
            System.out.println(pop);
            return pop;

        }

    }

}
