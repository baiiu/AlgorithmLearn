package com.baiiu.tree.printTraversal;

import com.baiiu.tree.BiNode;

/**
 * author: baiiu
 * date: on 17/5/19 15:00
 * description:
 * <p>
 * ------A
 * --B------C
 * D---E--F---G
 */
public class ZZTreeTest {

    public static void main(String[] args) {
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

        System.out.println("前序遍历：");
        Preorder.preOrderRe(tree);
        System.out.println();
        Preorder.preOrder(tree);
        System.out.println();
        Preorder.preOrder2(tree);
        System.out.print("\n-------------------------------\n\n");


        System.out.println("中序遍历：");
        Inorder.inOrderRe(tree);
        System.out.println();
        Inorder.inOrder(tree);
        System.out.print("\n-------------------------------\n\n");


        System.out.println("后序遍历：");
        PostOrder.postOrderRe(tree);
        System.out.println();
        PostOrder.postOrder(tree);
        System.out.println();
        PostOrder.postOrder2(tree);
        System.out.print("\n-------------------------------\n\n");

        //层序遍历

    }

}
