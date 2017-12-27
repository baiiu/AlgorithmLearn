package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * auther: baiiu
 * time: 17/9/14 14 07:40
 * description:
 */
class Question45_ {

    /**
     * 圆圈中最后剩下的数字
     * <p>
     * 0，1，...n-1 这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里剔除第m个数字。
     * 求出这个圆圈里剩下的最后一个数字。
     */
    static void test() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            list.add(i);
        }

        findLast(list, 2);
    }

    private static void findLast(List<Integer> list, int m) {

        int i = 0;

        while (list.size() != 1) {
            ListIterator<Integer> listIterator = list.listIterator();

            while (listIterator.hasNext()) {
                ++i;
                listIterator.next();

                if (i == m) {
                    listIterator.remove();
                    i = 0;
                }
            }
        }

        System.out.println(list);
    }

}
