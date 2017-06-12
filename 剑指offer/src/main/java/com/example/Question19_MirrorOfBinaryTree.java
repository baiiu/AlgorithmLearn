package com.example;

import com.baiiu.BiNode;

import java.util.Stack;

/**
 * auther: baiiu
 * time: 17/6/12 12 22:42
 * description:
 * ------A
 * --B------C
 * D---E--F---G
 * <p>
 * ------A
 * --C------B
 * G---F--E---D
 */
class Question19_MirrorOfBinaryTree {

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
        BNode.rChild = ENode;
        CNode.lChild = FNode;

//        BNode.lChild = DNode;
//        CNode.rChild = GNode;

        System.out.print("原来的：");
        inOrderRe(tree);
        System.out.println();
        System.out.println("---------------------------------------");


        System.out.println("循环做法：");
        mirrorTree_Foreach(tree);
        inOrderRe(tree);
        System.out.println();
        mirrorTree_Foreach(tree);
        inOrderRe(tree);
        System.out.println();
        System.out.println("---------------------------------------");

        System.out.println("递归做法：");
        mirrorTree(tree);
        inOrderRe(tree);
        System.out.println();
        mirrorTree(tree);
        inOrderRe(tree);
    }

    /*
        镜像： 递归时交换非叶子结点的子结点
     */
    private static void mirrorTree(BiNode tree) {
        if (tree == null) return;

        if (tree.lChild != null || tree.rChild != null) {
            BiNode lChild = tree.lChild;
            tree.lChild = tree.rChild;
            tree.rChild = lChild;
        }
        mirrorTree(tree.lChild);
        mirrorTree(tree.rChild);
    }

    private static void mirrorTree_Foreach(BiNode tree) {
        if (tree == null) return;

        Stack<BiNode> stack = new Stack<>();

        while (tree != null || !stack.empty()) {
            if (tree != null) {
                stack.push(tree);

                //交换
                if (tree.lChild != null || tree.rChild != null) {
                    BiNode lChild = tree.lChild;
                    tree.lChild = tree.rChild;
                    tree.rChild = lChild;
                }

                tree = tree.lChild;
            } else {
                tree = stack.pop();
                tree = tree.rChild;
            }
        }

    }


//    static void levelOrder(BiNode tree) {
//        if (tree == null) return;
//
//        Queue<BiNode> queue = new LinkedList<>();
//
//        int nodesInCurrentLevel = 1, nodesInNextLevel = 0;
//        queue.offer(tree);
//
//        while (!queue.isEmpty()) {
//            BiNode node = queue.poll();
//            --nodesInCurrentLevel;
//
//            if (node != null) {
//                System.out.print(node);
//                queue.offer(node.lChild);
//                queue.offer(node.rChild);
//                nodesInNextLevel += 2;
//            }
//
//            if (nodesInCurrentLevel == 0) {
//                nodesInCurrentLevel = nodesInNextLevel;
//                nodesInNextLevel = 0;
//                System.out.println();
//            }
//
//        }
//
//    }

    private static void inOrderRe(BiNode tree) {
        if (tree == null) {
            return;
        }

        inOrderRe(tree.lChild);
        System.out.print(tree.data);
        inOrderRe(tree.rChild);
    }


}
