package com.example;

import com.baiiu.CommonUtil;
import com.baiiu.Node;

/**
 * author: baiiu
 * date: on 17/6/8 14:42
 * description:
 */
class Question17_MergeSortedLists {

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


//        mergeList(nodeA, node1);
        Node head = merge_recursive(nodeA, node1);
        CommonUtil.printNodeList(head);

    }

    /*
        用递归实现，真的方便

        之前想的是归并数组那样去实现，难度大。
        不过归并数组就是插入排序，链表的数据结构并不这么简单

        递归真的化繁为简。

        之后在思考时，可以用递归的方式去思考实现，不要局限于循环结构。
     */
    private static Node merge_recursive(Node list1, Node list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        Node pHead;

        if (list1.numberData < list2.numberData) {
            pHead = list1;
            pHead.next = merge_recursive(list1.next, list2);
        } else {
            pHead = list2;
            pHead.next = merge_recursive(list1, list2.next);
        }

        return pHead;
    }

    /*
        这种方法实现难度大，如果这个List是个完整的链表数据结构就很好实现。

        归并两个链表，就是在正确的位置插入元素。
        所以核心是addNode(int index, Node node)方法
     */
    private static void mergeList(Node list1, Node list2) {
        /*
            归并两个链表，将list2插入到list1
         */

    }


}
