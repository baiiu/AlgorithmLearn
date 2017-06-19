package com.example;

/**
 * author: baiiu
 * date: on 17/6/19 10:42
 * description:
 */
class Question26_ {

    /**
     * 复杂链表的复制
     * <p>
     * 实现函数 complexListNode clone(ComplexListNode pHead)复制一个复杂链表
     * 在复杂链表中，每个节点除了有一个m_pNext指针指向下一个结点外，还有一个m_pSibling指向
     * 链表中的任意结点或者Null.
     */
    static void test() {

    }

    private static class ComplexListNode {
        int mValue;
        ComplexListNode mNext;
        ComplexListNode mSibling;
    }

}
