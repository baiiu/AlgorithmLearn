package com.baiiu.string;

/**
 * auther: baiiu
 * time: 17/4/15 15 10:42
 * description:
 * 朴素的模式匹配算法
 */
@SuppressWarnings("ALL")
class NativeStringMatcher {

    static int nativeStringMatching(String s, String t) {
        if (s == null || t == null) return -1;

        int i, j, sLength = s.length(), jLength = t.length();

        for (i = 0; i < sLength; ++i) { //滑动窗口始终为1

            j = 0;

            while (j < jLength) {
                if (i + j < sLength && s.charAt(i + j) == t.charAt(j)) {
                    ++j;//最后一个相等时，j会多加1
                } else {
                    break;// 不相等时，i + 1后重新开始。
                }
            }

            if (j == jLength) {
                return i;
            }

        }

        return -1;
    }

    static int nativeStringMatching2(String s, String t) {
        if (s == null || t == null) return -1;

        int i = 0, j = 0, sLength = s.length(), jLength = t.length();

        while (i < sLength && j < jLength) {
            if (s.charAt(i) == t.charAt(j)) {
                ++i;
                ++j;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == jLength) {
            return i - j;
        }

        return -1;
    }

}
