package com.example;

import com.baiiu.BiNode;

import java.util.Stack;

/**
 * author: baiiu
 * date: on 17/6/12 10:51
 * description:
 * ------A
 * --B------C
 * D---E--F---G
 */
class Question18_ {

    /**
     * 树的子结构
     * <p>
     * 输入两个二叉树A和B，判断B是不是A得子结构（子树）。
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
        BNode.lChild = DNode;
        BNode.rChild = ENode;
        CNode.lChild = FNode;
        CNode.rChild = GNode;

        //DEC
        BiNode childTree = new BiNode("D");
        childTree.lChild = new BiNode("E");
        childTree.rChild = new BiNode("C");

        childTree = DNode;
        childTree = BNode;

        isChildTree_Funny(tree, childTree);
        System.out.println(isChildTree(tree, childTree) ? "包含" : "不包含");
    }

    /*
        1. 在父树中判断是否包含chidTree的根节点(遍历),可能有相同的结点
        2. 依次遍历(可以递归)该树的子节点是否相同
     */
    private static boolean isChildTree(BiNode tree, BiNode childTree) {
        boolean result = false;

        if (tree != null && childTree != null) {
            if (tree.data.equals(childTree.data)) {
                result = isChildTreeReally(tree, childTree);
            }

            if (!result) {
                result = isChildTree(tree.lChild, childTree);
            }

            if (!result) {
                result = isChildTree(tree.rChild, childTree);
            }
        }

        return result;
    }

    private static boolean isChildTreeReally(BiNode tree, BiNode childTree) {
        if (childTree == null) return true;
        //noinspection SimplifiableIfStatement
        if (tree == null) return false;

        return tree.data.equals(childTree.data)
                && isChildTreeReally(tree.lChild, childTree.lChild)
                && isChildTreeReally(tree.rChild, childTree.rChild);
    }


    ////////////////////////////////////////////////////////////////////////////////////////

    /*
        1. 在父树中判断是否包含chidTree的根节点(遍历)
        2. 依次遍历(可以递归)该树的子节点是否相同

        或

        1. 判断childTree是不是只有一个结点

        2.
        如果两个树的遍历结果是包含的，并且childTree的根结点是tree的非叶子结点，那么就是子树。
        因为如果该childTree是DEC,则不是子树。

        第一种方法不知道怎么实现,书中给出了答案
     */
    private static void isChildTree_Funny(BiNode tree, BiNode childTree) {
        if (tree == null || childTree == null) return;

        BiNode targetNode = preOrderTarget(tree, childTree);

        if (childTree.lChild == null && childTree.rChild == null && targetNode != null) {
            //只有一个结点，判断一下
            System.out.println("包含，叶子结点");
            return;
        }

        if (targetNode != null && targetNode.lChild == null && targetNode.rChild == null) {
            // childTree有多个结点，但根结点是tree的叶子节点
            System.out.println("不包含");
            return;
        }

        String treeString = getPreOrder(tree);
        String childTreeString = getPreOrder(childTree);

//        System.out.println(treeString);
//        System.out.println(childTreeString);

        if (treeString.contains(childTreeString)) {
            // 字符串匹配算法
            System.out.println("包含");
        } else {
            System.out.println("不包含");
        }
    }

    private static boolean isNotLeafNode(BiNode tree, BiNode childTree) {
        if (tree == null || childTree == null) return false;
        /*
            1. 是否包含
            2. 包含的那个结点左右结点有一个不为空
          */


        BiNode biNode = preOrderTarget(tree, childTree);
        System.out.println(biNode);

        return biNode != null && biNode.lChild == null && biNode.rChild == null;
    }

    private static BiNode preOrderTarget(BiNode tree, BiNode childTree) {
        if (tree == null || childTree == null) return null;

        Stack<BiNode> stack = new Stack<>();
        while (!stack.empty() || tree != null) {
            if (tree != null) {
                if (tree.data.equals(childTree.data)) {
                    return tree;
                }

                stack.push(tree);
                tree = tree.lChild;
            } else {
                tree = stack.pop();
                tree = tree.rChild;
            }
        }

        return null;
    }


    private static String getPreOrder(BiNode tree) {
        StringBuilder builder = new StringBuilder();
        Stack<BiNode> stack = new Stack<>();
        while (!stack.empty() || tree != null) {
            if (tree != null) {
                builder.append(tree.data);

                stack.push(tree);
                tree = tree.lChild;
            } else {
                tree = stack.pop();
                tree = tree.rChild;
            }
        }

        return builder.toString();
    }


}
