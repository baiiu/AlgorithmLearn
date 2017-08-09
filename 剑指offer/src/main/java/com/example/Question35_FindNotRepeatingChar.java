package com.example;

import com.baiiu.CommonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * auther: baiiu
 * time: 17/8/10 10 06:42
 * description:
 */
class Question35_FindNotRepeatingChar {

    /**
     * 第一个只出现一次的字符
     * 在字符串中找出第一个只出现一次的字符。
     * <p>
     * 例如：
     * 输入abaccdeff，则输出b
     */
    static void test() {
        String s = "abaccdeff";
        findFirstOccurOnce(s);
        findFirstOccurOnce2(s);
    }

    /*
        1. 使用Map，：
            1) 先找出所有出现一次的字符，使用HashMap
            2) 在这些字符里找出第一个

        O(n)
     */
    private static void findFirstOccurOnce(String s) {
        if (CommonUtil.isEmpty(s)) return;

        char[] chars = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for (char aChar : chars) {
            Integer integer = map.get(aChar);
            map.put(aChar, integer == null ? 1 : ++integer);
        }

        for (char aChar : chars) {
            if (map.get(aChar) == 1) {
                System.out.println(aChar);
                return;
            }
        }

        System.out.println("no result");
    }

    /*
        2. 双重遍历
            和朴素字符串匹配很像，出现重复即continue

        最坏情况：O(n*n),可能是O(n*logn)
     */
    private static void findFirstOccurOnce2(String s) {
        if (CommonUtil.isEmpty(s)) return;

        char[] chars = s.toCharArray();

        for (int i = 0, length = chars.length; i < length; ++i) {
            char aChar = chars[i];
            boolean duplicate = false;

            for (int j = i + 1; j < length; ++j) {
                if (chars[j] == aChar) {
                    //有重复的了
                    duplicate = true;
                    break;
                }
            }

            if (duplicate) {
                continue;
            }

            System.out.println(aChar);
            break;
        }

    }


}
