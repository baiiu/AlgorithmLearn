package com.example;

/**
 * author: baiiu
 * date: on 17/5/31 11:58
 * description:
 */
class Question_SortAges {

    /**
     * 对公司几万人员工按照年龄排序
     * <p>
     * 要求时间复杂度为O(n)，可以使用不超过n的额外空间
     */
    static void test() {
        /*
            O(n)时间复杂度的只有 非比较排序算法：计数、基数、桶排序。
         */
        int[] ages = new int[]{20, 21, 22, 23, 24, 25, 26, 27, 28, 29,};

        sortAges(ages, ages.length);
    }

    private static void sortAges(int[] ages, int length) {

    }

}
