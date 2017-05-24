package com.example;

class Question03 {

    /**
     * 一个二维数组中，每一行都从左到右递增，每一列也从上到下递增；
     * <br />
     * Question:
     * 请输入一个二维数组和一个整数，判断该数组中是否含有该整数。
     */
    static void test() {
        int[][] array = new int[4][4];
        array[0] = new int[]{1, 2, 3, 4};
        array[1] = new int[]{2, 6, 7, 8};
        array[2] = new int[]{3, 10, 11, 12};
        array[3] = new int[]{4, 14, 15, 16};

        int target = 4;

        findSimple(array, target);
        find(array, 0, array.length - 1, target);
        find2(array, target);
    }

    /*
        从右上角开始查找
            target比它大，该行消失
            target比它小，该列消失

        剩余的数组，再从右上角开始

        row、column表示角标，不是length
    */
    private static void find(int[][] array, int row, int column, int target) {
        // @formatter:off
        if (array == null
                || row >= array.length || column >= array.length
                || row < 0 || column < 0) {
            System.out.println("不包含");
            return;
        }
        // @formatter:on

        int rightTopValue = array[row][column];//右上角值

        if (target < rightTopValue) {
            // 去除一列
            --column;
        } else if (target > rightTopValue) {
            //去除一行
            ++row;
        } else {
            System.out.println(row + "," + column);
            return;
        }

        find(array, row, column, target);
    }

    /*
        非递归写法
     */
    private static void find2(int[][] array, int target) {
        if (array == null) return;

        int row = 0;
        int column = array.length - 1;

        while (row >= 0 && column >= 0 && row < array.length & column < array.length) {
            int rightTopValue = array[row][column];

            if (target < rightTopValue) {
                // 去除一列
                --column;
            } else if (target > rightTopValue) {
                //去除一行
                ++row;
            } else {
                System.out.println(row + "," + column);
                return;
            }
        }

        System.out.println("不包含");
    }


    // 遍历，最简单方法
    private static void findSimple(int[][] array, int target) {
        if (array == null) return;

        for (int i = 0, iLength = array.length; i < iLength; ++i) {
            for (int j = 0, jLength = array[i].length; j < jLength; ++j) { //可能不规则
                if (array[i][j] == target) {
                    System.out.println(i + "," + j);
                    return;
                }
            }
        }

        System.out.println("不包含");
    }

}
