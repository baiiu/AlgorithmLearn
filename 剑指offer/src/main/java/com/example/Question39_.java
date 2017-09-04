package com.example;

import com.baiiu.BiNode;

import java.util.LinkedList;
import java.util.Queue;

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
class Question39_ {

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
//        tree.rChild = CNode;
        BNode.lChild = DNode;
//        BNode.rChild = ENode;
        CNode.lChild = FNode;
//        CNode.rChild = GNode;
//        GNode.rChild = HNode;
        DNode.lChild = HNode;

        countDepth(tree);
    }


    /*
        1, 层序遍历，获取最大深度

        二叉树的数组表示。 --> 可以根据数组长度来确定深度
     */
    private static void countDepth(BiNode node) {
        Queue<BiNode> queue = new LinkedList<>();
        queue.add(node);

        int depth = 0;

        while (!queue.isEmpty()) {
            node = queue.poll();

            if (node.lChild != null) {
                queue.add(node.lChild);
            }

            if (node.rChild != null) {
                queue.add(node.rChild);
            }
        }

        System.out.println(depth);
    }


}
