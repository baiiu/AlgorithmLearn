package com.example;

/**
 * author: baiiu
 * date: on 17/6/15 11:22
 * description:
 */
class Question24_SequenceOfBST {

    /**
     * 二叉搜索树的后序遍历序列：
     * <p>
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历。
     * 假设输入的所有数字均不相同。
     */
    static void test() {
        /*
            二叉搜索树：左子结点总是小于等于父结点，而右子结点总是大于等于父结点。
            堆(完全二叉树)：父节点总是 >=或<= 子节点。
         */
        int[] array = new int[]{5, 7, 6, 9, 11, 10, 8};
//        int[] array = new int[]{7, 6, 4, 5};

        System.out.println(judge(array) ? "是" : "不是");
        System.out.println(verifySquenceOfBST(array, 0, array.length - 1) ? "是" : "不是");
    }

    /*
        二叉搜索树的后序遍历特点：
            最后一个值为根结点，前面的数字能分成两部分：比根结点小的部分和比根结点大的部分
         其中这两部分又满足此特点。

            可以递归来判断。

            判断什么？ --> 比根结点小的部分全都比根结点小，比根结点大的部分全都比根结点大

     */

    // start、end都是角标
    private static boolean verifySquenceOfBST(int[] array, int start, int end) {
        if (array == null || array.length <= 0) return false;

        // 根结点的值
        int root = array[end];

        // 区分两部分数组的角标
        int partIndex = start;
        for (; partIndex < end; ++partIndex) {
            if (array[partIndex] > root) {
                break;
            }
        }

        //判断右部分的值是否全部大于根结点,抛除根结点
        for (int i = partIndex; i < end; ++i) {
            if (array[i] < root) return false;
        }

//        System.out.println(start + ", " + partIndex + ", " + end);

        boolean isBST = true;

        // 递归判断两部分数组
        if (partIndex - 1 > start) {
            isBST = verifySquenceOfBST(array, start, partIndex - 1); //左
        }

        if (end - 1 > partIndex) {
            isBST &= verifySquenceOfBST(array, partIndex, end - 1); //右
        }

        return isBST;
    }


    // 用了多余的空间
    private static boolean judge(int[] array) {
        if (array == null) return false;
        if (array.length == 0 || array.length == 1) return true;


        /*
            根结点的值
          */
        int rootValue = array[array.length - 1];

        /*
            找出两部分数组，从头开始和root比较，一直到比它大的，就从这个部分分两个数组

            左子树里的所有值都小于根结点，右子树里的所有值都大于根结点
          */
        // 第一个大于根结点的位置
        int partIndex = 0;
        for (int i = 0, length = array.length; i < length; ++i) {
            if (array[i] < rootValue) continue;

            partIndex = i;
            break;
        }
        // 拆分两个数组,根结点抛除在外
        int[] leftArray = new int[partIndex];
        int[] rightArray = new int[array.length - partIndex - 1];
        for (int i = 0, lenght = array.length - 1; i < lenght; ++i) {
            int number = array[i];
            if (i < partIndex) {
                leftArray[i] = number;
            } else {
                if (number < rootValue) {
                    // 右半部分必须全都大于根结点
                    return false;
                }
                rightArray[i - partIndex] = number;
            }
        }
//        System.out.println(Arrays.toString(leftArray) + "\n" + Arrays.toString(rightArray));

        /*
            递归判断：
                1. 判断该左子树是否是二分搜索树
                2. 判断该右子树是否是二分搜索树
         */
        return judge(leftArray) && judge(rightArray);
    }


}
