package com.example;

import com.baiiu.CommonUtil;

/**
 * author: baiiu
 * date: on 17/5/31 11:58
 * description:
 */
class Question08_SortAges {

    /**
     * 对公司几万人员工按照年龄排序
     * <p>
     * 要求时间复杂度为O(n)，可以使用不超过n的额外空间
     */
    static void test() {
        /*
            O(n)时间复杂度的只有 非比较排序算法：计数、基数、桶排序。
         */
        int[] ages = new int[] { 21, 20, 23, 22, 25, 24, 27, 26, 29, 28, 20, 21, 20 };

        sortAges(ages);

        CommonUtil.printArray(ages);
    }

    private static void sortAges(int[] ages) {

        int oldestAge = 99;

        int[] timesOfAge = new int[oldestAge + 1]; // 年龄从0开始到oldest

        for (int i = 0, length = ages.length; i < length; ++i) {
            int age = ages[i];

            if (age > oldestAge) {
                continue;
            }

            ++timesOfAge[age]; // 年龄为i的个数
        }

        CommonUtil.printArray(timesOfAge);

        for (int i = 0, index = 0; i <= oldestAge; ++i) {
            for (int j = 0; j < timesOfAge[i]; ++j) {
                ages[index] = i;
                ++index;
            }
        }

    }

}
