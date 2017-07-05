package com.example;

/**
 * author: baiiu
 * date: on 17/7/4 10:14
 * description:
 */
@SuppressWarnings("ForLoopReplaceableByForEach")
public class Question28_ {

    /**
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     * <p>
     * 例如输入abc，则打印出由a、b、c所能排列出来的所有字符串:abc,acb,bac,bca,cab,cba
     */
    static void test() {
        String s = "abc";
        permutation(s.toCharArray());
    }

    /*
        求一个位置的所有可能性，就是将它和其他位置交换。

        从头开始，固定首字母，求剩余部分字符串的全排列。
        在剩余部分，也可按照此种方法求。

        怎么求呢？就是将剩余部分的字符串的首字母和其他位置交换。

     */
    private static void permutation(char[] chars) {
        if (chars == null || chars.length == 0) return;

        permutation(chars, 0);
    }

    private static void permutation(char[] chars, int start) {
        if (chars.length - 1 == start) {
            System.out.println(chars);
        } else {
            char tmp;

            for (int i = start; i < chars.length; i++) {
                // 下面是交换元素的位置
                tmp = chars[start];
                chars[start] = chars[i];
                chars[i] = tmp;

                // 处理下一个位置
                permutation(chars, start + 1); // 剩余部分

                // 恢复原状
                tmp = chars[start];
                chars[start] = chars[i];
                chars[i] = tmp;
            }
        }

    }

    /*
        在选中的第一位后，应该选剩下的没用过的。可以传入 func(chars,int[] usedIndex)，在这里面选。
        可以使用递归来处理，终结条件就是printChar被放满了

        先不考虑去重，
     */
    private static void allSort2(char[] chars) {
        if (chars == null || chars.length == 0) return;

        int length = chars.length;
        int[] usedIndex = new int[length];
        for (int i = 0; i < length; ++i) {
            usedIndex[i] = -1;
        }

        char[] printChars = new char[length];
        countPrintChars(chars, printChars, 0, usedIndex);
    }

    private static void countPrintChars(char[] chars, char[] printChars, int currentIndex, int[] usedIndex) {
        for (int i = 0, length = chars.length; i < length; ++i) {
            if (arrayContainsInteger(usedIndex, i)) {
                continue;
            }

            usedIndex[currentIndex] = i;

            printChars[currentIndex] = chars[i];
            ++currentIndex;

            if (currentIndex == length) {
                currentIndex = 0;
                System.out.println(printChars);
                for (int k = 0; k < length; ++k) {
                    usedIndex[k] = -1;
                }
                return;
            }
            break;
        }

        countPrintChars(chars, printChars, currentIndex, usedIndex);
    }

    private static boolean arrayContainsInteger(int[] array, int target) {
        if (array == null || array.length == 0) return false;

        for (int i = 0, length = array.length; i < length; ++i) {
            if (array[i] == target) {
                return true;
            }
        }

        return false;

    }


    //  仅适用于length = 3的情况，一个例子
    private static void allSort(char[] chars) {

        int length = chars.length;

        char[] printChar = new char[length];

//        for (int i = 0; i < length; ++i) {
//            printChar[0] = chars[i];
//
//            for (int j = 0; j < length; ++j) {
//                if (j == i) continue; //上一个用过这个了
//
//                printChar[1] = chars[j];
//
//                for (int k = 0; k < length; ++k) {
//                    if (k == i || k == j) continue; //前面两个用过了
//                    printChar[2] = chars[k];
//                    System.out.println(printChar);
//                }
//            }
//        }

        int currentIndex = 0;
        int[] usedIndex = new int[length];
        for (int i = 0; i < length; ++i) {
            usedIndex[i] = -1;
        }

        for (int i = 0; i < length; ++i) {
            if (arrayContainsInteger(usedIndex, i)) continue;

            printChar[currentIndex] = chars[i];
            usedIndex[currentIndex] = i;
            currentIndex++;
        }
        System.out.println(printChar);

    }


}
