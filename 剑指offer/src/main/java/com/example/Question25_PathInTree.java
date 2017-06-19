package com.example;

import com.baiiu.BiNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * author: baiiu
 * date: on 17/6/16 10:38
 * description:
 * ------1
 * ---2-----3
 * -4---5--6---7
 * <p>
 * 7   8  10  11
 */
class Question25_PathInTree {

    /**
     * 二叉树中和为某一值的路径：
     * <p>
     * 输入一课二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 从树的根结点开始往下一直到叶节点所经过的结点形成一条路径。
     */
    static void test() {

        BiNode node1 = new BiNode(1);
        BiNode node2 = new BiNode(2);
        BiNode node3 = new BiNode(3);
        BiNode node4 = new BiNode(4);
        BiNode node5 = new BiNode(5);
        BiNode node6 = new BiNode(6);
        BiNode node7 = new BiNode(7);

        node1.lChild = node2;
        node1.rChild = node3;
        node2.lChild = node4;
        node2.rChild = node5;
        node3.lChild = node6;
        node3.rChild = node7;

        /*
            路径的定义： 从根结点到某一叶节点

            所以，可以看出，路径 <= 2^n(满二叉树)，n表示树的高度
         */
        findPath(node1, 11);
        findPath(node1, 8);
    }

    /*
        多考虑递归，多考虑使用递归。

        当循环搞不定的时候
     */
    private static void findPath(BiNode tree, int target) {
        if (tree == null) return;

        Stack<BiNode> path = new Stack<>();
        int currentSum = 0;
        findPath(tree, target, path, currentSum);

    }

    private static void findPath(BiNode tree, int targetSum, Stack<BiNode> path, int currentSum) {
        currentSum += tree.numberData;

        path.push(tree);

        boolean isLeaf = tree.lChild == null && tree.rChild == null;
        if (isLeaf && currentSum == targetSum) {
            System.out.print("path is ");
            for (BiNode biNode : path) {
                System.out.print(biNode.numberData);
            }
            System.out.println();
        }

        if (tree.lChild != null) {
            findPath(tree.lChild, targetSum, path, currentSum);
        }

        if (tree.rChild != null) {
            findPath(tree.rChild, targetSum, path, currentSum);
        }

        currentSum -= tree.numberData;
        path.pop();
    }


    /*
        已经想到前序遍历了。但拘泥于使用单个方法来解决问题。

        即在前序遍历中，使用另外一个数据结构来存储路径。很明显是另外一个栈。

        path这个栈弹出的时机是什么。
     */
//    private static void findPath_Foreach(BiNode tree, int target) {
//        Stack<BiNode> path = new Stack<>();
//        int sum = 0;
//
//        Stack<BiNode> stack = new Stack<>();
//        while (tree != null || !stack.empty()) {
//
//            if (tree != null) {
//                path.push(tree);
//                sum += tree.numberData;
//                if (sum == target) {
//                    System.out.println(tree.numberData);
//                }
//                System.out.println(sum);
//
//                stack.push(tree);
//                tree = tree.lChild;
//            } else {
//                tree = stack.pop();
//                tree = tree.rChild;
//            }
//
//        }
//
//    }


    /*
        直接开始遍历，遇到合适的即输出。
        可以按照前序遍历来

        修改遍历方式
     */
    private static void findPath_Wrong_self(BiNode tree, int target) {
        if (tree == null) return;

        Stack<BiNode> stack = new Stack<>();

        int sum = 0;

        while (tree != null || !stack.empty()) {

            if (tree != null) {
//                System.out.print(tree.numberData);
                stack.push(tree);
                sum += tree.numberData;

                if (sum == target) {
                    System.out.println();
                    System.out.println("find it: " + tree.numberData);
                }


                tree = tree.lChild;


            } else {
                tree = stack.pop();

                sum -= tree.numberData;
                System.out.println("减去" + tree.numberData + "后： " + sum);

                tree = tree.rChild;
            }


        }

    }


    /*
        另外一个想法：稍微简单点

        1. 层序遍历出该数组，并且标明start...end是一层。这样就可以在层中去循环，找出和
        2. 找出满足条件的多组结点后，判断是否是路径。
                因为这种方法只能区别出层，并不能区别哪一个结点是哪一个的子节点。

        另外一个方法：
            用一个数组表示该二叉树，位置一一对应，进行计算。这种方法应该最简单，但需要消耗更多的空间。
     */
    private static void findPath2(BiNode tree, int target) {
        /*
            1. 层序遍历，并标明层.
                把这个层序遍历后的结果存储在一个数组或集合中都行
                怎么标明这个层，使用另外一个数组或集合记录换层的index

             用数组的话得首先知道tree的结点个数
         */
//        int[] treeArray = new int[];


    }

    private static void getCount(BiNode tree) {
        if (tree == null) return;
        Queue<BiNode> queue = new LinkedList<>();
        queue.add(tree);

        int count = 0;

        while (!queue.isEmpty()) {
            ++count;

            BiNode node = queue.poll();
            System.out.print(node.numberData);

            if (node.lChild != null) {
                queue.add(node.lChild);
            }

            if (node.rChild != null) {
                queue.add(node.rChild);
            }
        }

        System.out.println();
        System.out.println(count);
    }



    /*
        1. 找出所有的和为该值的数字的组，必须包含根结点
        2. 在这些组里看是否构成一条路径，满足路径的组即是要寻找的

        问题就转化为：找出所有的和为该值的数字的组

        两个值？三个值？...n个值？
     */


}
