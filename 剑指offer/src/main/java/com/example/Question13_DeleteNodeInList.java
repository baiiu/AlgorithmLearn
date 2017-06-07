package com.example;

import com.baiiu.Node;

import static com.baiiu.CommonUtil.printNodeList;

/**
 * author: baiiu
 * date: on 17/6/5 18:41
 * description:
 */
class Question13_DeleteNodeInList {

    /**
     * 给定单向链表的头指针和一个结点指针，在O(1)的时间内删除该结点
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

        printNodeList(nodeA);
        System.out.println();

        //deleteNode(nodeA, nodeA);
        deleteNode_Ingenious(nodeA, nodeE);
        printNodeList(nodeA);
    }

    /*
        O(1)的删除：将下一个结点NextNode的值赋给当前结点，并将当前结点的next指向NextNode所指就行。

        巧妙。
     */
    private static void deleteNode_Ingenious(Node head, Node toDelete) {
        if (head == null || toDelete == null) return;

        if (head == toDelete) {
            head.data = null;
            return;
        }


        Node next = toDelete.next;
        if (next == null) {
            //尾结点上,只能找它的上一个来删除它，即NodePrevious.next = null;
            while (head != null) {
                if (head.next == toDelete) {
                    head.next = null;
                    break;
                }
                head = head.next;
            }

        } else {
            toDelete.data = next.data;
            toDelete.next = next.next;
        }
    }


    // O(n)，遍历删除
    private static void deleteNode(Node head, Node toDelete) {
        if (head == null || toDelete == null) return;

        if (head == toDelete) {
            head.data = null;
            return;
        }

        Node node = head;
        while (node != null) {
            if (node.next == toDelete) {
                node.next = toDelete.next;
                break;
            }


            node = node.next;
        }
    }


}
