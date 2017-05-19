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

        Preorder.preOrderRe(tree);
        System.out.println();
        Preorder.preOrder(tree);
        System.out.println();
        Preorder.preOrder2(tree);
        System.out.print("\n-------------------------------\n");


        Inorder.inOrderRe(tree);

    }

}
