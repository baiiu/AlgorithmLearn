package com.example;

import com.baiiu.CommonUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DiffInsertTwoList {

    /**
     * 1. 将local里remote没有的元素删去
     * 2. 将remote中新添加的元素添加到local中的相应位置上
     * <p>
     * 集合元素都相等时，local不变
     */
    public static void main(String[] args) {
        List<String> remote = new ArrayList();
        remote.add("1");
        remote.add("7");
        remote.add("2");
        remote.add("3");
        remote.add("5");

        List<String> local = new ArrayList();
        local.add("3");
        local.add("5");
        local.add("6");
        local.add("4");
        local.add("2");
        local.add("1");

        diffAndInsert(local, remote);
        System.out.println(local);
    }

    private static void diffAndInsert(List<String> local, List<String> remote) {
        if (CommonUtil.isEmpty(local) || CommonUtil.isEmpty(remote)) return;

        /*
            1. 先判断是否相等
         */
        if (local.size() == remote.size() && local.containsAll(remote)) {
            return;
        }

        /*
            2. 遍历local, 先删掉local中remote没有的元素
         */
        Iterator<String> iterator = local.listIterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (!remote.contains(s)) {
                iterator.remove();
            }
        }

        /*
            3. 遍历remote，向local中相应位置插入不同元素
         */
        for (int i = 0, size = remote.size(); i < size; i++) {
            String s = remote.get(i);
            if (local.contains(s)) continue;

            local.add(i, s);
        }


    }

    private static void diffAndInsert2(List<String> local, List<String> remote) {
        /*
            1. 先判断是否相等
         */
        if (local.size() == remote.size() && local.containsAll(remote)) {
            return;
        }

        /*
            2.
                newList = remote 交集 local，全是相同的元素
                newList = newList 补集 remote，不同的元素
         */

    }


}
