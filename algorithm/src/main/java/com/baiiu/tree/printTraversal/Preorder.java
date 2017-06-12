package com.baiiu.tree.printTraversal;


import com.baiiu.BiNode;

import java.util.Stack;

/**
 * author: baiiu
 * date: on 17/5/19 16:02
 * description:
 * <p>
 * 前序遍历：根左右
 */
class Preorder {

    static void preOrderRe(BiNode tree) {
        if (tree == null) {
            return;
        }

        System.out.print(tree.data);
        preOrderRe(tree.lChild);
        preOrderRe(tree.rChild);
    }

    static void preOrder(BiNode tree) {
        if (tree == null) {
            return;
        }

        Stack<BiNode> stack = new Stack<>();
        stack.push(tree);

        while (!stack.empty()) {
            BiNode node = stack.pop();
            System.out.print(node.data);

            if (node.rChild != null) {
                stack.push(node.rChild);
            }

            if (node.lChild != null) {
                stack.push(node.lChild);
            }
        }
    }

    static void preOrder2(BiNode tree) {
        Stack<BiNode> stack = new Stack<>();

        while (tree != null || !stack.empty()) {
            if (tree != null) {
                //遍历完左子树，全部存入栈内
                System.out.print(tree.data);//打印根节点
                stack.push(tree);
                tree = tree.lChild;
            } else {
                // 左节点到底了，回溯取右节点
//                System.out.println(stack);
                tree = stack.pop();
                tree = tree.rChild;
            }
        }
    }


}
