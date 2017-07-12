package com.example;

/**
 * author: baiiu
 * date: on 17/7/12 11:43
 * description:
 */
public class Question30_ {

    /**
     * 最小的k个数
     * <p>
     * 输入n个整数，找出其中最小的k个数。
     * 例如输入 { 4,5,1,6,2,7,3,8 } 这8个数字，最小的4个数字为1,2,3,4
     */
    static void test() {

    }

    /*
        1. 每次都遍历，去除掉上一个最小的数，O(k*n)
           同： int[k]，从输入数组中获取，填入int[0~k]中

        2. 先排序，后取. O(nlogn)

        3. O(n)
           桶排序： 以k为length的桶？
           计数排数： 小于某个值的总次数 >=k 即停止

        4. 最小堆，的前k个值。O(nLogn)
     */

}
