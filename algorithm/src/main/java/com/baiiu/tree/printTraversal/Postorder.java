package com.baiiu.tree.printTraversal;

import com.baiiu.tree.BiNode;

/**
 * author: baiiu
 * date: on 17/5/19 16:04
 * description:
 * <p>
 * 后序遍历：左右根
 */
public class Postorder {

    static void postOrder(BiNode tree) {
        if (tree == null) {
            return;
        }

        postOrder(tree.lChild);
        postOrder(tree.rChild);
        System.out.print(tree.data);
    }

}
