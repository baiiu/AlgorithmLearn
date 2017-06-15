package com.example;

import com.baiiu.BiNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * author: baiiu
 * date: on 17/6/15 11:07
 * description:
 * ------A
 * --B------C
 * D---E--F---G
 */
class Question23_TreeLevelOrder {

    /**
     * 树的层序遍历：从上往下打印二叉树
     * <p>
     * 从上往下打印二叉树的每个结点，同一层的结点按照从左到右的顺序打印
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
//        BNode.lChild = DNode;
        BNode.rChild = ENode;
        CNode.lChild = FNode;
//        CNode.rChild = GNode;

        levelOrder(tree);
    }

    private static void levelOrder(BiNode tree) {
        if (tree == null) return;

        Queue<BiNode> queue = new LinkedList<>();
        int currentLevelCount, nextLevelCount = 0; //单纯的打印不需用记录层，可以去掉

        queue.offer(tree);
        currentLevelCount = 1;

        while (!queue.isEmpty()) {

            if (currentLevelCount != 0) {
                BiNode node = queue.poll();
                System.out.print(node.data);

                if (node.lChild != null) {
                    ++nextLevelCount;
                    queue.add(node.lChild);
                }
                if (node.rChild != null) {
                    ++nextLevelCount;
                    queue.add(node.rChild);
                }

                --currentLevelCount;
            }

            if (currentLevelCount == 0) {
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
                System.out.println();
            }


        }

    }
}
