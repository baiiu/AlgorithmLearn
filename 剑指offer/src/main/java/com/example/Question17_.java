package com.example;

import com.baiiu.Node;

/**
 * author: baiiu
 * date: on 17/6/8 14:42
 * description:
 */
class Question17_ {

    /**
     * 合并两个排序的链表
     * <p>
     * 输入两个递增的排序链表，合并这两个链表并使新链表也是有序的。
     */
    static void test() {
        Node nodeA = new Node(2);
        Node nodeB = new Node(4);
        Node nodeC = new Node(6);
        Node nodeD = new Node(7);
        Node nodeE = new Node(9);
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node7 = new Node(7);
        Node node9 = new Node(9);
        Node node11 = new Node(11);
        node1.next = node2;
        node2.next = node3;
        node3.next = node7;
        node7.next = node9;
        node9.next = node11;

        mergeList(nodeA, node1);
    }


    private static void mergeList(Node list1, Node list2) {
        /*
            归并两个链表，将list2插入到list1
         */

        int ptr1 = 0, ptr2 = 0;
        Node node1 = list1, node2 = list2, pHead = node1;

        while (node1 != null) {
            if (node2.numberData < node1.numberData) {
                // 第二个链表的结点小于第一个链表的结点
                node1.next = node2;

            }


            ++ptr1;
            node1 = node1.next;
        }


    }

}
