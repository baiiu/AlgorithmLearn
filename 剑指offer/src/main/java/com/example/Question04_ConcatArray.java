package com.example;

import java.util.Arrays;

/**
 * author: baiiu
 * date: on 17/5/25 09:54
 * description:
 */
class Question04_ConcatArray {

    /**
     * 合并两个有序数组(增序)A1和A2，并保证合并后的数组依然是有序的。
     * 其中A1的末尾有足够多的空间容纳A2。
     */
    static void test() {
        Integer[] arrayA = new Integer[10];
        for (int i = 0; i < 3; i++) {
            arrayA[i] = i * 2 + 2;
        }

//        Integer[] arrayB = new Integer[]{11, 12};//j排完了

        Integer[] arrayB = new Integer[]{0, 1, 5, 11, 12}; // i排完了

        System.out.println(Arrays.toString(arrayA));
        System.out.println(Arrays.toString(arrayB));


        concat(arrayA, arrayB);
    }

    /*
        1. 确定合并后的数组大小
        2. 从A1的末尾遍历，选取两数组中最大的直接移动到指定位置
      */
    private static void concat(Integer[] arrayA, Integer[] arrayB) {
        int iLength = 0;
        for (Integer integer : arrayA) {
            if (integer == null) break;
            ++iLength;
        }

        int jLength = arrayB.length;

        // 从后往前遍历，选取最大的值放置
        for (int k = iLength + jLength - 1, i = iLength - 1, j = jLength - 1; k >= 0; --k) {

            if (i < 0) {
                // 说明i排完了，赋值j
                arrayA[k] = arrayB[j];
                --j;
                continue;
            }

            if (j < 0) {
                // 说明j排完了，不用排了
                break;
//                arrayA[k] = arrayA[i];
//                --i;
//                continue;
            }

            // k = 0 时，i或j必然有一个为-1，此时直接赋值到0即可
            if (arrayA[i] > arrayB[j]) {
                arrayA[k] = arrayA[i];
                --i;
            } else {
                arrayA[k] = arrayB[j];
                --j;
            }
        }

        System.out.println("合并后： \n" + Arrays.toString(arrayA));

    }

}
