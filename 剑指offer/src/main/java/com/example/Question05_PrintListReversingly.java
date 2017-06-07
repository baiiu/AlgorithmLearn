package com.example;

import com.baiiu.Node;

import java.util.Stack;

/**
 * author: baiiu
 * date: on 17/5/26 13:11
 * description:
 */
class Question05_PrintListReversingly {

    /**
     * 从尾到前打印链表
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

        printListReversingly(nodeA);
        System.out.println();
        printListReversingly_Recursive(nodeA);
    }

    private static void printListReversingly(Node node) {
        if (node == null) return;

        Stack<Node> stack = new Stack<>();

        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        while (!stack.empty()) {
            System.out.print(stack.pop().data);
        }
    }

    /*
        输出结点的值的时候，若它后面还有结点，先输出后面的
     */
    private static void printListReversingly_Recursive(Node node) {
        if (node == null) return;

        if (node.next != null) {
            printListReversingly_Recursive(node.next);
        }
        System.out.print(node.data);
    }

}
