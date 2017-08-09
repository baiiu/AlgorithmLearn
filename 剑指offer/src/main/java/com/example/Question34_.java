package com.example;

import java.util.Arrays;

/**
 * author: baiiu
 * date: on 17/8/3 10:13
 * description:
 */
class Question34_ {

    /**
     * 我们把只包含因子2、3、5的数称为丑数。1是第一个丑数
     * 求按从小到大的顺序的第1500个丑数。
     * <p>
     * 例如：6、8都是丑数，14不是，因为14包含因子7
     */
    static void test() {
        int index = 1500;
//        System.out.println(isAugly(732421875));

        countAuglyNumber(index);
        countToTarget(index);
    }

    /*
        2. 由n个2、3或5组成的从小到大的排列。使用额外的空间

        下一个丑数肯定是另一个丑数 * 2、3或5 得到。由此可以做出一个数列。
        问题的关键在于如何保证一个数列是有序的。


        1) 现有的已排序数列中所有数字分别*2、*3、*5中取最小的大于当前数列最大项的值就OK
        2) 并不必要所有数字，而是从某个*2、*3、*5时已经大于当前数列的最大值，此时只有3个值，在这三个值里选最小的
     */
    private static void countAuglyNumber(int index) {
        int[] auglyNumbers = new int[index];
        auglyNumbers[0] = 1;
        int currentMaxIndex = 0, currentMax = auglyNumbers[currentMaxIndex];

        int M2 = 0, M3 = 0, M5 = 0;//最小的三个数

        while (currentMaxIndex < index) {

            for (int i = 0; i <= currentMaxIndex; ++i) {
                if (auglyNumbers[M2] * 2 <= currentMax) ++M2;
                if (auglyNumbers[M3] * 3 <= currentMax) ++M3;
                if (auglyNumbers[M5] * 5 <= currentMax) ++M5;
            }

            currentMax = min(auglyNumbers[M2] * 2, auglyNumbers[M3] * 3, auglyNumbers[M5] * 5);

            ++currentMaxIndex;
            if (currentMaxIndex == index) break;

            auglyNumbers[currentMaxIndex] = currentMax;
        }

        System.out.println(auglyNumbers[index - 1]);
        System.out.println(Arrays.toString(auglyNumbers));
    }

    private static int min(int number1, int number2, int number3) {
        int min = number1 < number2 ? number1 : number2;
        min = min < number3 ? min : number3;

        return min;
    }


    /*
        1. 暴力法：
            求一个数的质因数，只能是2、3或5
     */
    private static void countToTarget(int index) {
        int targetCount = 0;
        int[] auglyNumbers = new int[index];

        int number = 1;
        while (true) {
            if (isAugly(number)) {
                auglyNumbers[targetCount] = number;

                ++targetCount;

//                System.out.println(number);

                if (targetCount == index) {
                    System.out.println(number);
                    break;
                }
            }

            ++number;
        }

        System.out.println(Arrays.toString(auglyNumbers));

    }

    private static boolean isAugly(int number) {
        if (number == 1) return true;

        while (number % 2 == 0) {
            number /= 2;
        }

        while (number % 3 == 0) {
            number /= 3;
        }

        while (number % 5 == 0) {
            number /= 5;
        }

        return number == 1;
    }


}
