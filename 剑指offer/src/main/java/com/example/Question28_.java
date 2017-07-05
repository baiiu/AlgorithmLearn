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
//        allSort("abb".toCharArray());

        allSort2("abc".toCharArray());
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
        boolean flagUsed = false;
        for (int i = 0, length = chars.length; i < length; ++i) {

            for (int j = 0; j < length; ++j) {
                if (usedIndex[j] == i) {
                    flagUsed = true;
                    break; //这个i上的字符用过了,跳出循环，++i
                }

                flagUsed = false;
                usedIndex[currentIndex] = i;

                printChars[currentIndex] = chars[i];
                ++currentIndex;

                if (currentIndex == length) {
                    currentIndex = 0;
                    System.out.println(printChars);
                    return;
                }
                break;
            }

            if (!flagUsed) {
                countPrintChars(chars, printChars, currentIndex, usedIndex);
            }

        }

    }


    //  仅适用于length = 3的情况，一个例子
    private static void allSort(char[] chars) {

        int length = chars.length;

        char[] printChar = new char[length];

        for (int i = 0; i < length; ++i) {
            printChar[0] = chars[i];

            for (int j = 0; j < length; ++j) {
                if (j == i) continue; //上一个用过这个了

                printChar[1] = chars[j];

                for (int k = 0; k < length; ++k) {
                    if (k == i || k == j) continue; //前面两个用过了
                    printChar[2] = chars[k];
                    System.out.println(printChar);
                }

            }

        }


    }


}
