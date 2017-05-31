package com.example;

import java.util.LinkedList;
import java.util.Queue;

/**
 * author: baiiu
 * date: on 17/5/31 11:05
 * description:
 */
class Question07_StackWithTwoQueues {

    /**
     * 用两个队列实现栈，并实现栈的push和pop操作
     */
    static void test() {
        Stack stack = new Stack();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");

        stack.pop();
        stack.pop();

        stack.push("5");
        stack.push("6");

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }


    private static class Stack {
        private Queue<String> queue1 = new LinkedList<>();
        private Queue<String> queue2 = new LinkedList<>();

        void push(String element) {
            if (queue1.isEmpty()) {
                queue2.offer(element);
                return;
            }

            if (queue2.isEmpty()) {
                queue2.offer(element);
            }
        }

        String pop() {
            /*
                弹出元素时，将有元素队列中的值移动到另一队列中，弹出最后一个值
             */

            if (queue1.isEmpty() && queue2.isEmpty()) {
                System.out.println("没有元素");
                return null;
            }

            if (queue1.isEmpty()) {
                return pop(queue2, queue1);
            }

            if (queue2.isEmpty()) {
                return pop(queue1, queue2);
            }

            return null;
        }

        private String pop(Queue<String> fullQueue, Queue<String> emptyQueue) {

            while (fullQueue.size() != 1) {
                String poll = fullQueue.poll();
                emptyQueue.offer(poll);
            }

            String poll = fullQueue.poll();
            System.out.println(poll);
            return poll;
        }

    }
}
