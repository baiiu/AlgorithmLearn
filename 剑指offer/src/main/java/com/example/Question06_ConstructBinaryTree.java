package com.example;

import java.util.LinkedList;
import java.util.Queue;

/**
 * auther: baiiu
 * time: 17/5/29 29 09:29
 * description:
 */
class Question06_ConstructBinaryTree {

    /**
     * 输入某二叉树的前序遍历和中序遍历结果，重建出该二叉树
     */
    static void test() {
        int[] preorder = new int[] { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] inorder = new int[] { 4, 7, 2, 1, 5, 3, 8, 6 };

        try {
            BiNode construct = construct(preorder, inorder);
            levelOrder(construct);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }

    private static BiNode construct(int[] preOrder, int[] inOrder) throws Exception {
        // 空指针判断
        if (preOrder == null || inOrder == null || preOrder.length <= 0) {
            return null;
        }

        return constructCore(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    private static BiNode constructCore(int[] preOrder, int startPreOrder, int endPreOrder, int[] inOrder,
            int startInOrder, int endInOrder) throws Exception {
        // 前序遍历序列的第一个数字是根结点的值
        int rootValue = preOrder[startPreOrder];
        BiNode root = new BiNode();
        root.data = String.valueOf(rootValue);
        root.lChild = root.rChild = null;

        if (startPreOrder == endPreOrder) {
            if (startInOrder == endInOrder && preOrder[startPreOrder] == inOrder[startInOrder]) {
                return root;
            } else {
                throw new Exception("Invalid input!");
            }
        }

        // 在中序遍历中找到根结点的值
        int rootInOrder = startInOrder;
        while (rootInOrder <= endInOrder && inOrder[rootInOrder] != rootValue) {
            rootInOrder++;
        }

        // 输入的两个序列不匹配的情况
        if (rootInOrder == endInOrder && inOrder[rootInOrder] != rootValue) {
            throw new Exception("Invalid input!");
        }

        int leftLength = rootInOrder - startInOrder;
        int leftPreOrderEnd = startPreOrder + leftLength;
        if (leftLength > 0) {
            // 构建左子树
            root.lChild =
                    constructCore(preOrder, startPreOrder + 1, leftPreOrderEnd, inOrder, startInOrder, rootInOrder - 1);
        }
        if (leftLength < endPreOrder - startPreOrder) {
            // 构建右子树
            root.rChild =
                    constructCore(preOrder, leftPreOrderEnd + 1, endPreOrder, inOrder, rootInOrder + 1, endInOrder);
        }

        return root;
    }

    private static void levelOrder(BiNode tree) {
        Queue<BiNode> queue = new LinkedList<>();
        queue.offer(tree);
        int nodesInCurrentLevel = 1, nodesInNextLevel = 0;


        while (!queue.isEmpty()) {
            BiNode node = queue.poll();
            --nodesInCurrentLevel;

            if (node != null) {
                System.out.print(node.data);
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

