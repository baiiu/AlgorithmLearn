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

//        BiNode convert = convert(node10);
//        print(convert);

        BiNode biNode = convert2(node10);
        print(biNode);
    }

    /*
        BiNode中lChild即是双向链表中的前驱prev，rChild即是后继next

        使用中序遍历，左根右，
        根据搜索二叉树的特性，左子结点的后继即根结点，根结点的前驱即左子结点；右子结点亦然
     */

    private static BiNode convert(BiNode root) {
        // 用于保存处理过程中的双向链表的尾结点
        BiNode[] lastNode = new BiNode[1];
        convertNode(root, lastNode);
        // 找到双向链表的头结点
        BiNode head = lastNode[0];
        while (head != null && head.lChild != null) {
            head = head.lChild;
        }
        return head;
    }

    private static void convertNode(BiNode node, BiNode[] lastNode) {
        if (node == null)
            return;

        // 如果有左子树就先处理左子树
        if (node.lChild != null) {
            convertNode(node.lChild, lastNode);
        }
        // 将当前结点的前驱指向已经处理好的双向链表（由当前结点的左子树构成）的尾结点
        node.lChild = lastNode[0];
        // 如果左子树转换成的双向链表不为空，设置尾结点的后继
        if (lastNode[0] != null) {
            lastNode[0].rChild = node;
        }
        // 记录当前结点为尾结点
        lastNode[0] = node;
        // 处理右子树
        if (node.rChild != null) {
            convertNode(node.rChild, lastNode);
        }

    }


    private static BiNode convert2(BiNode root) {
        if (root == null)
            return null;
        if (root.lChild == null && root.rChild == null)
            return root;

        // 1.将左子树构造成双链表，并返回链表头节点
        BiNode left = convert2(root.lChild);
        BiNode p = left;
        // 2.定位至左子树双链表最后一个节点
        while (p != null && p.rChild != null) {
            p = p.rChild;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if (left != null) {
            p.rChild = root;
            root.lChild = p;
        }
        // 4.将右子树构造成双链表，并返回链表头节点
        BiNode right = convert2(root.rChild);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if (right != null) {
            right.lChild = root;
            root.rChild = right;
        }
        return left != null ? left : root;
    }

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


}
