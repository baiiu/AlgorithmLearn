package com.example;

/**
 * auther: baiiu
 * time: 17/6/13 13 07:16
 * description:
 */
class Question20_PrintMatrix {

    /**
     * 顺时针打印矩阵
     * <p>
     * 给定一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数组。
     * <p>
     * 例如矩阵如下：
     * 1 2 3 4
     * 5 6 7 8
     * 9 10 11 12
     * <p>
     * 则输出： 1 2 3 4 8 12 11 10 9 5 6 7
     */
    static void test() {
//        int[][] array = new int[3][4];
//        array[0] = new int[]{1, 2, 3, 4};
//        array[1] = new int[]{5, 6, 7, 8};
//        array[2] = new int[]{9, 10, 11, 12};


//        int[][] array = new int[4][3];
//        array[0] = new int[]{1, 2, 3};
//        array[1] = new int[]{4, 5, 6};
//        array[2] = new int[]{7, 8, 9};
//        array[3] = new int[]{10, 11, 12};

        int[][] array = new int[4][5];
        array[0] = new int[]{1, 2, 3, 4, 5};
        array[1] = new int[]{6, 7, 8, 9, 10};
        array[2] = new int[]{11, 12, 13, 14, 15};
        array[3] = new int[]{16, 17, 18, 19, 20};

        // 用二维数组表示矩阵
        printArray(array);

        /*
            实际上，这个遍历过程的动作是重复的，不断缩小的,应该可以看成递归来写

            不过这种面向过程的写法也不错
         */
    }

    /*
        面向过程写法，分析每一步的变化
     */
    private static void printArray(int[][] array) {
        if (array == null || array.length == 0) return;

        int iMax = array.length - 1;
        int jMax = array[0].length - 1;
        int i, j, iMin = 0, jMin = 0;
        int count = 0;

        int totalCount = (iMax + 1) * (jMax + 1);
        while (count < totalCount) {
//            System.out.println("iMin = " + iMin + ", iMax = " + iMax + ", jMin = " + jMin + ", jMax = " + jMax);

            // 第一行
            for (j = jMin; j <= jMax; ++j) {
                ++count;
                System.out.print(array[iMin][j] + " ");
            }

            ++iMin;

            // 最后一列
            for (i = iMin; i <= iMax; ++i) {
                ++count;
                System.out.print(array[i][jMax] + " ");
            }

            --jMax;

            if (count == totalCount) break; //

            // 最后一行
            for (j = jMax; j >= jMin; --j) {
                ++count;
                System.out.print(array[iMax][j] + " ");
            }
            --iMax;

            // 第一列
            for (i = iMax; i >= iMin; --i) {
                ++count;
                System.out.print(array[i][jMin] + " ");
            }

            ++jMin;
        }

        System.out.println();
        System.out.println("个数：" + count + ", " + totalCount);


    }

}
