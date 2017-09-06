package com.example;

/**
 * author: baiiu
 * date: on 17/9/6 10:44
 * description:
 */
class Question41_ContinuesSequenceWithSum {

    /**
     * 输入正数s,打印出所有和为s的连续正数序列(至少两个数)。
     * <p>
     * 例如输入15，可知 1+2+3+4+5 = 4+5+6 = 7+8 = 15
     * 则输出3个连续序列{1,2,3,4,5}、{4,5,6}、{7,8}
     */
    static void test() {
        int target = 15;

        findSequenceNumber(target);
        System.out.println();
        printSequenceNumber(target);
        System.out.println();
        printSequenceNumber2(target);
    }

    /*
        使用{1,2}序列开头
            小于target时，向后添加一个大值
            大于target时，移除前面一个小值

        O(n)
     */
    private static void findSequenceNumber(int target) {
        if (target < 2) return;

        int start = 1, end = 2, middle = (target + 1) / 2;

        while (start < middle) {
            int sum = 0;
            for (int i = start; i <= end; ++i) {
                sum += i;
            }

            if (sum < target) {
                ++end;
            } else if (sum > target) {
                ++start;
            } else {
                System.out.println("{" + start + "~" + end + "}  ");
                ++start;
            }
        }


    }

    /*
        使用数学公式 (end - start + 1)(start + end)/2

        end^2 + end + start - start^2 - 2*target = 0;

        O(n)
     */
    private static void printSequenceNumber2(int target) {
        if (target < 2) return;

        int start = 1, middle = (target + 1) / 2;

        while (start < middle) {

            double sqrt = Math.sqrt(1 - 4 * (start - start * start - 2 * target));
            int sqrtInt = (int) sqrt;

//            System.out.println(sqrt + ", " + sqrtInt);

            if (Math.abs(sqrt - sqrtInt) <= 0.0000001) {
                int end = (-1 + sqrtInt) / 2;
//                int end2 = (-1 - sqrtInt) / 2;

                System.out.println("{" + start + "~" + end + "}  ");
            }

            ++start;
        }

    }

    /*
        双重循环
     */
    private static void printSequenceNumber(int target) {
        if (target < 2) return;

        for (int start = 1, middle = (target + 1) / 2; start < middle; ++start) {

            int tempSum = start;
            int end = start + 1;

            for (; end < target; ++end) {
                tempSum += end;

                if (tempSum > target) {
                    break;
                }

                if (tempSum == target) {
                    System.out.println("{" + start + "~" + end + "}  ");
                    break;
                }
            }

        }

    }

}
