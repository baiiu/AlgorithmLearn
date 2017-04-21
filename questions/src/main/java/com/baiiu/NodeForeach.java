package com.baiiu;

/**
 * author: baiiu
 * date: on 17/4/21 14:56
 * description:
 */
public class NodeForeach {

    static class BTreeNode {

        String data;
        BTreeNode lNode;
        BTreeNode rNode;
    }

    public static void main(String[] args) {
        /*
                     A
                  B     C

         */
        BTreeNode lNode = new BTreeNode();
        lNode.data = "B";


        BTreeNode rNode = new BTreeNode();
        rNode.data = "C";

        BTreeNode parent = new BTreeNode();
        parent.data = "A";
        parent.lNode = lNode;
        parent.rNode = rNode;

        preOrder(parent);
        System.out.println();

        midOrder(parent);
        System.out.println();

        lastOrder(parent);

    }

    // 前序遍历：中左右
    static void preOrder(BTreeNode tree) {
        if (tree == null) return;

        System.out.print(tree.data);
        preOrder(tree.lNode);
        preOrder(tree.rNode);
    }

    // 中序遍历：左中右
    static void midOrder(BTreeNode tree) {
        if (tree == null) return;

        midOrder(tree.lNode);
        System.out.print(tree.data);
        midOrder(tree.rNode);
    }

    // 后序遍历：左右根
    static void lastOrder(BTreeNode tree) {
        if (tree == null) return;

        lastOrder(tree.lNode);
        lastOrder(tree.rNode);
        System.out.print(tree.data);
    }

}
