package com.example;

import com.baiiu.BiNode;

/**
 * auther: baiiu
 * time: 17/8/24 24 07:57
 * description:
 * <p>
 * ------A
 * --B------C
 * D---E--F---G
 * ------------H
 */
class Question39_TreeDepth {

    /**
     * 二叉树的深度
     * <p>
     * 输入一颗二叉树的节点，求该树的深度。
     * <p>
     * 从根节点到叶节点依次经过的结点(含根、叶结点)形成的一条路径，最长路径的长度为树的深度。
     */
    static void test() {
        BiNode tree = new BiNode("A");
        BiNode BNode = new BiNode("B");
        BiNode CNode = new BiNode("C");
        BiNode DNode = new BiNode("D");
        BiNode ENode = new BiNode("E");
        BiNode FNode = new BiNode("F");
        BiNode GNode = new BiNode("G");
        BiNode HNode = new BiNode("H");

        tree.lChild = BNode;
        tree.rChild = CNode;
        BNode.lChild = DNode;
        BNode.rChild = ENode;
        CNode.lChild = FNode;
        CNode.rChild = GNode;
        GNode.rChild = HNode;
        DNode.lChild = HNode;

        System.out.println(countDepth(tree));
    }


    /*
        使用递归。

        根节点的深度等于其左右子树中最大的深度 + 1
     */
    private static int countDepth(BiNode node) {
        if (node == null) return 0;

        int left = countDepth(node.lChild);
        int right = countDepth(node.rChild);

        return 1 + Math.max(left, right);
    }


}
