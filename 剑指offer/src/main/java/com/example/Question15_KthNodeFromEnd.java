package com.example;

import java.util.Stack;

/**
 * author: baiiu
 * date: on 17/6/6 11:13
 * description:
 */
class Question15_KthNodeFromEnd {

    /**
     * 输出链表中倒数第k个结点
     * <p>
     * 输入一个链表，输出该链表中倒数第k个结点。
     * 其中倒数从1开始，到时第1个结点即该链表的最后一个结点
     */
    static void test() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;

        int k = 4;

        printReverseNumberK(nodeA, k);
        findKthToTail(nodeA, k);
    }


    /*
        1. 第一次遍历，求出结点个数size
        2. 第二次遍历，输出第size - k个结点，开头是第0个结点

        这种解法要遍历两次。

        只遍历一次，用两个指针，第一个到K - 1时再开始移动第二个指针

     */
    private static void findKthToTail(Node node, int k) {
        if (node == null) return;

        int endPtr = 0, kPtr = 0;

        while (node != null) {
            ++endPtr;

            if (endPtr == k) {
                ++kPtr;
            }

            node = node.next;
        }

    }

    /*
        放到栈里弹出k个
     */
    private static void printReverseNumberK(Node node, int k) {
        Stack<Node> stack = new Stack<>();

        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        for (int i = 0; i < k - 1; ++i) {
            if (stack.empty()) {
                System.out.println("k超过list长度");
                return;
            }
            stack.pop();
        }

        if (stack.empty()) {
            System.out.println("k超过list长度");
            return;
        }
        System.out.println(stack.pop());

    }


}
