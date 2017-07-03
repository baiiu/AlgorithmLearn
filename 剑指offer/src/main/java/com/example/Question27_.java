package com.example;

import com.baiiu.BiNode;

/**
 * author: baiiu
 * date: on 17/6/21 11:10
 * description:
 * <p>
 * -------10
 * ----6-----14
 * --4--8--12---16
 */
class Question27_ {

    /**
     * 二叉搜索树与双向链表
     * <p>
     * 输入一个二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     */
    static void test() {
        BiNode node10 = new BiNode("10");
        BiNode node6 = new BiNode("6");
        BiNode node14 = new BiNode("14");
        BiNode node4 = new BiNode("4");
        BiNode node8 = new BiNode("8");
        BiNode node12 = new BiNode("12");
        BiNode node16 = new BiNode("16");

        node10.lChild = node6;
        node10.rChild = node14;
        node6.lChild = node4;
        node6.rChild = node8;
        node14.lChild = node12;
        node14.rChild = node16;

        BiNode head = null;
//        print(head);
//        inorder(node10);
//        BiNode convert = convert(node10);
//        print(convert);
    }

    /*
        BiNode中lChild即是双向链表中的前驱prev，rChild即是后继next

        使用中序遍历，左根右，
        根据搜索二叉树的特性，左子结点的后继即根结点，根结点的前驱即左子结点；右子结点亦然
     */
    private static BiNode convert(BiNode tree) {
        BiNode pLastNodeInList = null; //指向双向链表的尾结点

        convertNode(tree, pLastNodeInList);

        BiNode pHeadOfList = pLastNodeInList;
        while (pHeadOfList != null && pHeadOfList.lChild != null) {
            pHeadOfList = pHeadOfList.lChild;
        }

        return pHeadOfList;
    }

    private static void convertNode(BiNode node, BiNode pLastNodeInList) {
        if (node == null) return;

        BiNode pCurrent = node;

        if (pCurrent.lChild != null) {
            convertNode(pCurrent.lChild, pLastNodeInList);
        }

        pCurrent.lChild = pLastNodeInList;
        if (pLastNodeInList != null) {
            pLastNodeInList.rChild = pCurrent;
        }

        pLastNodeInList = pCurrent;

        if (pCurrent.rChild != null) {
            convertNode(pCurrent.rChild, pLastNodeInList);
        }
    }

//    private static void inorder(BiNode tree) {
//        Stack<BiNode> stack = new Stack<>();
//
//        while (tree != null || !stack.empty()) {
//            if (tree != null) {
//                stack.push(tree);
//                tree = tree.lChild;
//            } else {
//                tree = stack.pop();
//                System.out.print(tree.data + ", ");
//
//                tree = tree.rChild;
//            }
//        }
//
//    }

    private static void print(BiNode tree) {
        while (tree != null) {
            if (tree.lChild == null) {
                break;
            }

            tree = tree.lChild;
        }

        while (tree != null) {
            System.out.print(tree.data + ", ");
            tree = tree.rChild;
        }
    }


    ////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////



}
