package com.example;

/**
 * author: baiiu
 * date: on 17/6/5 18:41
 * description:
 */
class Question13_ {

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

        printList(nodeA);
        System.out.println();
        deleteNode(nodeA, nodeB);
        printList(nodeA);
    }

    // O(n)，遍历删除
    private static void deleteNode(Node head, Node toDelete) {
        Node node = head;

        while (node != null) {
            if (node.next == toDelete) {
                node.next = toDelete.next;
                break;
            }


            node = node.next;
        }
    }

    private static void printList(Node node) {

        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }

    }

}
