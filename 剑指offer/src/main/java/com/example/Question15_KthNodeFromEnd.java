package com.example;

import com.baiiu.Node;

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

        int k = 1;
//        int k = 5;
//        int k = 7;

        findKthToTail(nodeA, k);
        findKthToTail_Twice(nodeA, k);
        printReverseNumberK(nodeA, k);
    }


    /*
        只遍历一次，用两个指针，第一个到K - 1时再开始移动第二个指针

        因为endPtr和targetPtr之间的间距总是k -1
     */
    private static void findKthToTail(Node node, int k) {
        if (node == null || k <= 0) return;

        int endPtr = 0, targetPtr = 0;

        Node target = node;

        while (true) {
            node = node.next;

            if (node == null) {
                if (target == null) {
                    System.out.println("k超过list长度");
                    return;
                }

                System.out.println(target + ", " + targetPtr);
                return;
            }


            if (endPtr - targetPtr == k - 1) {
                ++targetPtr;
                target = target.next;
            }

            ++endPtr;
        }
    }

    /*
        两次遍历：
            第一次计算链表长度
            第二次计算倒数第k个值，即下标为size - k的元素
      */
    private static void findKthToTail_Twice(Node node, int k) {
        if (node == null || k <= 0) return;

        int size = 0;

        Node nodeStart = node;
        while (nodeStart != null) {
            ++size;
            nodeStart = nodeStart.next;
        }

        for (int i = 0; i < size; ++i) {
            if (i == size - k) {
                System.out.println(node);
                return;
            }

            node = node.next;
        }

        System.out.println("k超过list长度");
    }

    /*
        放到栈里弹出k个
     */
    private static void printReverseNumberK(Node node, int k) {
        if (node == null || k <= 0) return;

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
