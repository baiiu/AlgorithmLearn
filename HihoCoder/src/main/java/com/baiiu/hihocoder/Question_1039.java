package com.baiiu.hihocoder;

import com.baiiu.CommonUtil;

class Question_1039 {

    /**
     * 1. 如果s包含长度超过1的由相同字母组成的子串，那么这些子串会被同时消除，余下的子串拼成新的字符串。
     * 例如"ABCCBCCCAA"中"CC","CCC"和"AA"会被同时消除，余下"AB"和"B"拼成新的字符串"ABB"。
     * <p>
     * 2. 上述消除会反复一轮一轮进行，直到新的字符串不包含相邻的相同字符为止。
     * 例如”ABCCBCCCAA”经过一轮消除得到"ABB"，再经过一轮消除得到"A"
     * <p>
     * 3. 游戏中的每一关小Hi都会面对一个字符串s。
     * 在消除开始前小Hi有机会在s中任意位置(第一个字符之前、最后一个字符之后以及相邻两个字符之间)插入任意一个字符('A','B'或者'C')，得到字符串t。
     * t经过一系列消除后，小Hi的得分是消除掉的字符的总数。
     * 3. 对于每一行输入的字符串，输出小Hi最高能得到的分数。
     */
    static void test() {


    }


    /*
        从第一个字符开始遍历字符串，
        如果后一个和前一个相同，则继续向下，看第二个位置和第0个位置是否相同

        再接着遍历下一个

        有点像KMP
     */
    private static void countScore(String s) {
        if (CommonUtil.isEmpty(s)) return;

        char[] chars = s.toCharArray();

        for (int i = 0, j; i < chars.length; ++i) {
            j = i + 1;


        }


    }


}
