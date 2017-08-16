package com.example;

import com.baiiu.Node;

/**
 * author: baiiu
 * date: on 17/8/16 10:23
 * description:
 */
class Question37_FirstCommonNodeInLists {

    /**
     * 两个链表的第一个公共结点
     * <p>
     * 输入两个链表，找出它们的第一个公共结点。
     */
    static void test() {

        // A --> B --> C --> D --> E
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;

        Node nodeF = new Node("F");
        nodeF.next = nodeC;

        printFirstSameNode(nodeA, nodeF);
        printFirstSameNode2(nodeA, nodeF);
    }

    /*
        2. 题意如此，从某个公共结点开始后所有结点相同

            A --> B -->
                         C --> D --> E
                  F -->

           首先，从最后往前遍历，找出最后一个相同的元素，它即是第一个公共结点。 可以使用两个栈，弹出栈顶元素。

           也可以从距离底部相同的长度开始遍历，即 lengthLong - lengthShort开始处遍历，找出第一个相同的元素。

       O(m + n)
     */
    private static void printFirstSameNode2(Node list1, Node list2) {
        if (list1 == null || list2 == null) return;

        int length1 = getLength(list1), length2 = getLength(list2);

        // 长的list先走的距离
        int diff = length1 - length2;

        if (diff != 0) {
            for (int i = 0; i < Math.abs(diff); ++i) {
                if (diff > 0) {
                    list1 = list1.next;
                } else {
                    list2 = list2.next;
                }
            }
        }

        // 此时list1.length 和 length2.length 相同
        while (list1 != null && list2 != null && !list1.data.equals(list2.data)) {
            list1 = list1.next;
            list2 = list2.next;
        }

        System.out.println(list1);


    }

    private static int getLength(Node list) {
        int length = 0;
        while (list != null) {
            ++length;

            list = list.next;
        }

        return length;
    }

    /*
        1. 两次遍历，把链表换成数组也行

        O(mn)
     */
    private static void printFirstSameNode(Node list1, Node list2) {
        if (list1 == null || list2 == null) return;

        Node node1 = list1;
        Node node2;

        while (node1 != null) {

            node2 = list2;
            while (node2 != null) {
                if (node1.data.equals(node2.data)) {
                    System.out.println("the first is " + node1);
                    return;
                }

                node2 = node2.next;
            }

            node1 = node1.next;
        }

    }


}
