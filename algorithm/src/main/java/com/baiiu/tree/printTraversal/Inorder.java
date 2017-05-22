package com.baiiu.tree.printTraversal;

import com.baiiu.tree.BiNode;

import java.util.Stack;

/**
 * author: baiiu
 * date: on 17/5/19 16:03
 * description:
 * <p>
 * 中序遍历：左根右
 */
class Inorder {

    static void inOrderRe(BiNode tree) {
        if (tree == null) {
            return;
        }

        inOrderRe(tree.lChild);
        System.out.print(tree.data);
        inOrderRe(tree.rChild);
    }

    static void inOrder(BiNode tree) {
        Stack<BiNode> stack = new Stack<>();

        while (tree != null || !stack.isEmpty()) {
            if (tree != null) {
                stack.push(tree);
                tree = tree.lChild;
            } else {
                BiNode pop = stack.pop();
                System.out.print(pop.data);
                tree = pop.rChild;
            }
        }
    }


}
