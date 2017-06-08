package com.example;

import com.baiiu.CommonUtil;
import com.baiiu.Node;

import java.util.Stack;

/**
 * author: baiiu
 * date: on 17/6/7 10:42
 * description:
 */
class Question16_ReverseList {

    /**
     * 反转链表
     * <p>
     * 输入链表的头结点，反转该链表并输出反转后链表的头结点
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

        /*
            1. 循环遍历，挨个找出倒数第k个结点， ++k
            2. 使用栈
            3. 构造成了双向链表？ 在结点中加一个prev指向前一个结点，一次遍历搞定
            4. 基于3，将下下个结点放在内存里，一次遍历也可以
         */
        reverseList_Simple(nodeA);
//        reverseList(nodeA);
//        reverseList_Stack(nodeA);
    }

    // 一遍遍历
    private static void reverseList_Simple(Node node) {
        if (node == null) return;

        Node pReverseHead = null;
        Node pNode = node;
        Node pPrev = null;

        // 当前结点pNode，下一个结点pNext，上一个结点pPrev
        while (pNode != null) {
            Node pNext = pNode.next;

            if (pNext == null) {
                pReverseHead = pNode;
            }

            pNode.next = pPrev;

            pPrev = pNode;
            pNode = pNext;
        }

        CommonUtil.printNodeList(pReverseHead);
    }

    private static void reverseList(Node node) {
        if (node == null) return;

        Node nodeFirst = node, nodeMiddle = nodeFirst.next;
        if (nodeMiddle == null) {
            System.out.println("只有一个结点，无需反转");
            return;
        }

        nodeFirst.next = null;

        Node nodeEnd = nodeMiddle.next;
        if (nodeEnd == null) {
            // 只有两个结点
            nodeMiddle.next = nodeFirst;
            nodeFirst.next = null;
            CommonUtil.printNodeList(nodeMiddle);
            return;
        }

        while (nodeEnd != null) {
            nodeMiddle.next = nodeFirst;

            Node lastNode = nodeEnd.next;
            nodeEnd.next = nodeMiddle;

            nodeFirst = nodeMiddle;
            nodeMiddle = nodeEnd;
            nodeEnd = lastNode;
        }
        CommonUtil.printNodeList(nodeMiddle);


    }

    /*
        使用栈
     */
    private static void reverseList_Stack(Node node) {
        if (node == null) return;

        Stack<Node> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        if (stack.empty()) {
            return;
        }

        // 反转
        Node pop = stack.pop();
        Node nodeStart = pop;
        while (!stack.empty()) {
            Node next = stack.pop();
            pop.next = next;
            pop = next;
        }
        pop.next = null;

        CommonUtil.printNodeList(nodeStart);
    }


}
