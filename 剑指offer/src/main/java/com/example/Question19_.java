package com.example;

import com.baiiu.BiNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * auther: baiiu
 * time: 17/6/12 12 22:42
 * description:
 * ------A
 * --B------C
 * D---E--F---G
 */
class Question19_ {

    /**
     * 二叉树的镜像
     * <p>
     * 输入一个二叉树，输出它的镜像
     */
    static void test() {
        BiNode tree = new BiNode("A");
        BiNode BNode = new BiNode("B");
        BiNode CNode = new BiNode("C");
        BiNode DNode = new BiNode("D");
        BiNode ENode = new BiNode("E");
        BiNode FNode = new BiNode("F");
        BiNode GNode = new BiNode("G");

        tree.lChild = BNode;
        tree.rChild = CNode;
        BNode.lChild = DNode;
        BNode.rChild = ENode;
        CNode.lChild = FNode;
        CNode.rChild = GNode;

        mirrorTree(tree);
        levelOrder(tree);

    }

    /*
        镜像： 递归时交换非叶子结点的子结点
     */
    private static void mirrorTree(BiNode tree) {
        if (tree == null) return;

        if (tree.lChild != null) {
            BiNode lChild = tree.lChild;
            tree.lChild = tree.rChild;
            tree.rChild = lChild;
        }
        mirrorTree(tree.lChild);
        mirrorTree(tree.rChild);
    }

    static void levelOrder(BiNode tree) {
        if (tree == null) return;

        Queue<BiNode> queue = new LinkedList<>();

        int nodesInCurrentLevel = 1, nodesInNextLevel = 0;
        queue.offer(tree);

        while (!queue.isEmpty()) {
            BiNode node = queue.poll();
            --nodesInCurrentLevel;

            if (node != null) {
                System.out.print(node);
                queue.offer(node.lChild);
                queue.offer(node.rChild);
                nodesInNextLevel += 2;
            }

            if (nodesInCurrentLevel == 0) {
                nodesInCurrentLevel = nodesInNextLevel;
                nodesInNextLevel = 0;
                System.out.println();
            }

        }

    }


}
