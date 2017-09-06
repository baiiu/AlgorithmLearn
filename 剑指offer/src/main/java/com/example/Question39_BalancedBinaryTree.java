package com.example;

import com.baiiu.BiNode;

/**
 * auther: baiiu
 * time: 17/9/5 05 07:32
 * description:
 * ------A
 * --B------C
 * D---E--F---G
 * ------------H
 * ----------I
 */
class Question39_BalancedBinaryTree {

    /**
     * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
     * <p>
     * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
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
        BiNode INode = new BiNode("I");

        tree.lChild = BNode;
        tree.rChild = CNode;
        BNode.lChild = DNode;
        BNode.rChild = ENode;
        CNode.lChild = FNode;
        CNode.rChild = GNode;
        GNode.rChild = HNode;
        DNode.lChild = HNode;
        HNode.lChild = INode;

        System.out.println(isBalanceTree(tree));
    }

    /*
        计算某一结点的 左子树的深度 和 右子树的深度 之差

        计算某一结点的最大深度

        计算所有非叶子节点的左右子树高度差
     */
    private static boolean isBalanceTree(BiNode node) {
        if (node == null) return true;

        int left = countDepth(node.lChild);
        int right = countDepth(node.rChild);
        if (Math.abs(left - right) > 1) {
            return false;
        }

        return isBalanceTree(node.lChild) && isBalanceTree(node.rChild);
    }

    private static int countDepth(BiNode node) {
        if (node == null) return 0;

        int left = countDepth(node.lChild);
        int right = countDepth(node.rChild);

        return 1 + Math.max(left, right);
    }


}
