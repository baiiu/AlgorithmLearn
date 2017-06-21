package com.example;

import java.util.HashMap;
import java.util.Map;

/**
 * author: baiiu
 * date: on 17/6/19 10:42
 * description:
 */
@Deprecated
class Question26_CopyComplexList {

    /**
     * 复杂链表的复制
     * <p>
     * 实现函数 complexListNode clone(ComplexListNode pHead)复制一个复杂链表
     * <p>
     * 复杂链表是指：
     * 每个节点除了有一个m_pNext指针指向下一个结点外，还有一个m_pSibling指向，链表中的任意结点或者Null.
     */
    static void test() {
        /*
            题意：首先构造一个复杂链表，然后复制它
         */
        ComplexListNode nodeA = new ComplexListNode("A");
        ComplexListNode nodeB = new ComplexListNode("B");
        ComplexListNode nodeC = new ComplexListNode("C");
        ComplexListNode nodeD = new ComplexListNode("D");
        ComplexListNode nodeE = new ComplexListNode("E");

        nodeA.mNext = nodeB;
        nodeB.mNext = nodeC;
        nodeC.mNext = nodeD;
        nodeD.mNext = nodeE;
        nodeA.mSibling = nodeC;
        nodeB.mSibling = nodeE;
        nodeD.mSibling = nodeB;

//        copyComplexList(nodeA);
        printNodeList(nodeA);
        System.out.println();
        copyComplexList(nodeA);

    }


//    private static void copyComplexList(ComplexListNode node) {
//        ComplexListNode cloneHead = new ComplexListNode();
//        cloneHead.mValue = node.mValue + "'";
////        cloneHead.mSibling = node.mSibling; // 这种写法是指向原来的
//
//        ComplexListNode head = cloneHead;
//
//        node = node.mNext;
//        while (node != null) {
//            ComplexListNode nodeClone = new ComplexListNode();
//
//            nodeClone.mValue = node.mValue + "'";
////            nodeClone.mSibling = node.mSibling;
//            cloneHead.mNext = nodeClone;
//
//
//            cloneHead = cloneHead.mNext;
//            node = node.mNext;
//        }
//
//        printNodeList(head);
//
//    }

    // 复制链表
    private static void copyComplexList(ComplexListNode node) {
        ComplexListNode current = node;
        ComplexListNode cloneHead = null;
        ComplexListNode head = null;

        Map<ComplexListNode, ComplexListNode> map = new HashMap<>(); //存储对应的结点，A对应A'

        // 1. 复制链表
        while (current != null) {
            if (cloneHead == null) {
                cloneHead = new ComplexListNode();
                cloneHead.mValue = current.mValue + "'";
                head = cloneHead;
            } else {
                ComplexListNode nodeClone = new ComplexListNode();
                nodeClone.mValue = current.mValue + "'";
                cloneHead.mNext = nodeClone;

                cloneHead = cloneHead.mNext;
            }

            map.put(current, cloneHead);

            current = current.mNext;
        }


        // 2. 设置sibling
        ComplexListNode siblingStart = head;
        while (node != null) {
            if (node.mSibling != null) {
                siblingStart.mSibling = map.get(node.mSibling);
            }

            siblingStart = siblingStart.mNext;
            node = node.mNext;
        }

        printNodeList(head);
    }


    public static void printNodeList(ComplexListNode node) {
        while (node != null) {
            System.out.print(node);
            node = node.mNext;
        }
    }

    private static class ComplexListNode {
        String mValue;
        ComplexListNode mNext;
        ComplexListNode mSibling;

        public ComplexListNode() {
        }

        ComplexListNode(String mValue) {
            this.mValue = mValue;
        }

        @Override
        public String toString() {
            if (mSibling != null) {
                return mValue + "-" + mSibling.mValue + "; ";
            }

            return mValue + "; ";
        }
    }

}
