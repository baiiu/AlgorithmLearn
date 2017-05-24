package com.baiiu.string;

import java.util.Arrays;

/**
 * auther: baiiu
 * time: 17/4/15 15 13:28
 * description:
 * <p>
 * [从头到尾彻底理解KMP](http://blog.csdn.net/v_july_v/article/details/7041827#t14)
 */
@SuppressWarnings("ALL")
class KMPStringMatcher {

    private static int[] next;

    static int KMPStringMatcher(String s, String t) {
        if (s == null || t == null) return -1;

        int i = 0, j = 0, sLength = s.length(), jLength = t.length();

        /*
            1. 获取移动位数表
         */
        int[] next = getNextVal(t);

        /*
            2. 遍历查找
         */
        while (i < sLength && j < jLength) {
            if (j == -1 || s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];//i不回溯，j变化。
            }
        }

        if (j == jLength) {
            return i - j;
        }

        return -1;
    }

    // 获取模式串的移动位数
    public static int[] getNext(String t) {
        int jLength = t.length();
        int[] next = new int[jLength];

        int k = -1;
        int j = 0;
        next[0] = -1; // next数组中next[0]为-1
        while (j < jLength - 1) {
            if (k == -1 || t.charAt(j) == t.charAt(k)) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }

        return next;
    }

    public static int[] getNextVal(String t) {
        int jLength = t.length();
        int[] next = new int[jLength];

        int k = -1;
        int j = 0;
        next[0] = -1; // next数组中next[0]为-1
        while (j < jLength - 1) {
            if (k == -1 || t.charAt(j) == t.charAt(k)) {
                k++;
                j++;

                if (t.charAt(j) != t.charAt(k)) {
                    next[j] = k;   //之前只有这一行
                } else {
                    //因为不能出现p[j] = p[ next[j ]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]
                    next[j] = next[k];
                }

            } else {
                k = next[k];
            }
        }

        return next;
    }

    public static void main(String[] args) {
        String t = "ABCDABD"; // 7
        //最大长度表：0000120 (包括自身的前缀后缀相等元素的长度)
        //next数组：-1000012 (全部元素右移一位，初始值为-1)

        /*
             仔细看进行比对的过程：
                 0123456
             s = ABCDABCDABDE
             t = ABCDABD
                     ABCDABD
             一直比对到D才发现不匹配，接下来该从哪比对呢？

             从j = 2开始，因为ABCDAB的部分匹配值为2。
                因为t中ABCD都互不相等，无需再和s比较比较；
                因为t[0、1]为AB和t[4、5]相等，而t[4、5]和s[4、5]已经比较过了，无需比较


             所以从数组获取时，j = next[6] = 2

             所以这张表应该计算值j之前的匹配值，是因为匹配到第j个发现不匹配了，要从新的j开始匹配
         */


        System.out.println(Arrays.toString(getNext(t)));
    }

}
