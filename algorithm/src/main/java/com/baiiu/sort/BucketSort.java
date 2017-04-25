package com.baiiu.sort;

import java.util.LinkedList;
import java.util.List;

/**
 * auther: baiiu
 * time: 17/4/13 13 06:53
 * description: 桶排序
 */
@SuppressWarnings("ALL")
class BucketSort {

    /**
     * 使用数组结构来完成桶排序
     *
     * @param step 表示一个桶内放几个数字
     */
    static void bucketSort(int[] array, int step) {
        if (array == null || array.length == 1) return;

        int max = array[0], min = array[0], length = array.length;
        for (int i = 1; i < length; ++i) {
            max = array[i] > max ? array[i] : max;
            min = array[i] < min ? array[i] : min;
        }

        // 计算桶个数
        int num = (int) Math.ceil((max - min + 1) / (step + 0F));
        if (num < 1) num++;

        // 建桶,使用二维数组来存储，Integer可以避免数字为0而无法区分的情况
        List<List<Integer>> list = new LinkedList<List<Integer>>();

        for (int i = 0; i < num; ++i) {
            list.add(new LinkedList<Integer>());
        }

        // 将数据放入对应桶内
        for (int i = 0; i < length; i++) {
            int index = (array[i] - min) / step;
            list.get(index)
                    .add(array[i]);
        }

        // 对每个桶内部排序（可以递归桶排序）
        for (int i = 0; i < num; i++) {
            list.set(i, sort(list.get(i)));
        }

        // 将排序后的桶放回数组
        int k = 0;
        for (int i = 0, size = list.size(); i < size; ++i) {
            List<Integer> temp = list.get(i);

            for (int j = 0; j < temp.size(); j++) {
                array[k] = temp.get(j);
                k++;
            }
        }
    }

    private static List<Integer> sort(List<Integer> list) {
        //使用插入排序
        if (list == null) return null;

        for (int i = 1, j, temp, size = list.size(); i < size; ++i) {

            j = i - 1;
            temp = list.get(i);

            while (j >= 0 && list.get(j) > temp) {
                list.set(j + 1, list.get(j));
                --j;
            }

            list.set(j + 1, temp);
        }

        System.out.println(list.toString());

        return list;
    }

}
