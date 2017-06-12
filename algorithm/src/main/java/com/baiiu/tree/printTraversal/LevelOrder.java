package com.baiiu.tree.printTraversal;


import com.baiiu.BiNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * author: baiiu
 * date: on 17/5/23 09:56
 * description: 层序遍历
 */
class LevelOrder {

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
            }

        }

    }

}
