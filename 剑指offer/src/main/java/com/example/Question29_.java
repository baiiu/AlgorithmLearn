package com.example;

/**
 * auther: baiiu
 * time: 17/7/11 11 23:16
 * description:
 */
class Question29_ {

    /**
     * 数组中出现次数超过一半的数字
     * <p>
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * <p>
     * 例如：输入长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中
     * 出现5次，超过数组长度一半，所以输出2.
     */
    static void test() {
        int[] arr = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};

        findNumberOverHalf(arr);
    }

    /*
        排序，然后找中位数就可以了
     */





    /*
        最基础的解法，遍历每个数字。 O(n*n)

        这种数字有且仅有一个。

        借助空间记录遍历过的数字，可以提高效率。
     */
    private static void findNumberOverHalf(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) return;

        int length = array.length;
        int half = (int) (length / 2 + 0.5F);

        int temp, count;
//        Integer[] alreadyBeen = new Integer[half];

        for (int i = 0; i < half; ++i) { // i从一半开始
            temp = array[i];
            count = 1;

//            if (i == 0) {
//                alreadyBeen[i] = temp;
//            } else {
//                if (CommonUtil.arrayContains(alreadyBeen, temp)) {
//                    continue;
//                }
//            }


            for (int j = i + 1; j < length; ++j) {
                if (array[j] == temp) {
                    ++count;
                }
            }

            if (count > half) {
                System.out.println(temp);
                break;
            }
        }

    }

}
