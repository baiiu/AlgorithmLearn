package com.baiiu;

/**
 * author: baiiu
 * date: on 17/4/13 10:44
 * description: 计数排序
 */
@SuppressWarnings("ForLoopReplaceableByForEach")
class CountSort {

    static int[] countSort(int[] a) {
        int b[] = new int[a.length];
        int max = a[0], min = a[0];
        for (int i : a) {
            max = i > max ? i : max;
            min = i < min ? i : min;
        }

        //这里k的大小是要排序的数组中，元素大小的极值差+1
        int k = max - min + 1;
        int c[] = new int[k];

        /*
            a[i]的出现次数放在数组c的第a[i] - min个中
            即：min + i 出现了 c[i]次
         */
        for (int i = 0; i < a.length; ++i) {
            c[a[i] - min] += 1;
        }

        /*
            统计出小于等于a[i]的个数有几个
         */
        for (int i = 1; i < c.length; ++i) {
            c[i] = c[i] + c[i - 1];
        }

        /*
            例如有10个年龄不同的人，统计出有8个人的年龄比A小，那A的年龄就排在第9位，
            用这个方法可以得到其他每个人的位置，也就排好了序。
         */
        for (int i = a.length - 1; i >= 0; --i) {
            // --c[a[i] - min],小于等于它的有这么多个，就排在这个位置上，数组下标要减1
            // 此处c数组在不断变化，取走一个，小于等于它的便少了一个
            int index = --c[a[i] - min];

            b[index] = a[i];//按存取的方式取出c的元素
        }


        return b;
    }

}
