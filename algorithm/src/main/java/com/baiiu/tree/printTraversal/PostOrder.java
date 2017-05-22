package com.baiiu.tree.printTraversal;

import com.baiiu.tree.BiNode;

import java.util.Stack;

/**
 * author: baiiu
 * date: on 17/5/19 16:04
 * description:
 * <p>
 * 后序遍历：左右根
 */
class PostOrder {

    static void postOrderRe(BiNode tree) {
        if (tree == null) {
            return;
        }

        postOrderRe(tree.lChild);
        postOrderRe(tree.rChild);
        System.out.print(tree.data);
    }

    /*
        要保证根结点在左孩子和右孩子访问之后才能访问，因此对于任一结点P，先将其入栈。
        如果P不存在左孩子和右孩子，则可以直接访问它；或者P存在左孩子或者右孩子，但是其左孩子和右孩子都已被访问过了，则同样可以直接访问该结点。
        若非上述两种情况，则将P的右孩子和左孩子依次入栈，这样就保证了每次取栈顶元素的时候，左孩子在右孩子前面被访问，左孩子和右孩子都在根结点前面被访问。
     */
    static void postOrder(BiNode tree) {
        Stack<BiNode> stack = new Stack<>();
        stack.push(tree);

        BiNode pre = null;

        //push时候按照根右左入栈
        while (!stack.empty()) {
            BiNode cur = stack.peek();

            if ((cur.lChild == null && cur.rChild == null) ||
                    (pre != null && (pre == cur.rChild || pre == cur.lChild))) {
                //左右结点都是空 || 左右结点都被访问过(先判断右结点)

                System.out.print(cur.data);
                stack.pop();
                pre = cur;
            } else {

                if (cur.rChild != null) {
                    stack.push(cur.rChild);
                }
                if (cur.lChild != null) {
                    stack.push(cur.lChild);
                }
            }

        }
    }

    //用两个栈
    static void postOrder2(BiNode tree) {
        Stack<BiNode> stack = new Stack<>();
        Stack<BiNode> output = new Stack<>();

        stack.push(tree);

        //output按照根右左入栈，stack按照根左右入栈
        while (!stack.empty()) {
            BiNode pop = stack.pop();
            output.push(pop);

            if (pop.lChild != null) {
                stack.push(pop.lChild);
            }
            if (pop.rChild != null) {
                stack.push(pop.rChild);
            }
        }

        while (!output.empty()) {
            System.out.print(output.pop().data);
        }
    }


}
