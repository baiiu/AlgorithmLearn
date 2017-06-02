package com.example;

/**
 * author: baiiu
 * date: on 17/6/2 16:15
 * description:
 */
class Question11_Power {

    /**
     * 实现函数 double power(double base, int exponent)
     * 求base的exponent次方，不需要考虑大数问题
     */
    static void test() {
        double base = 3.3;
//        double base = 0.0;
//        int exponent = 5;
//        int exponent = 0;
        int exponent = -5;

        power(base, exponent);
        System.out.println(Math.pow(base, exponent));
    }

    /*
        exponent为正、零、负

        底数为0，指数为负。这种情况没考虑到。
      */
    private static double power(double base, int exponent) {
        int positiveExponent = Math.abs(exponent);

//        double result = powerWithPositiveExponent(base, positiveExponent);
        double result = powerWithPositiveExponent2(base, positiveExponent);

        if (exponent < 0) {
            if (Math.abs(base - 0.0) < 0.0000001) { // base为0
                throw new IllegalArgumentException("base can not be zero");
            }

            result = 1 / result;
        }

        System.out.println(result);
        return result;
    }

    private static double powerWithPositiveExponent(double base, int positiveExponent) {
        if (positiveExponent == 0) return 1;
        if (positiveExponent == 1) return base;

        double result = 1.0;
        for (int i = 0; i < positiveExponent; i++) {
            result *= base;
        }
        return result;
    }

    /**
     * a^n = a ^ (n/2) * a ^ (n/2), n为偶数
     * a^n = a ^ ((n - 1)/2)) * a ^ ((n - 1)/2)) * a, n为奇数
     */
    private static double powerWithPositiveExponent2(double base, int positiveExponent) {
        if (positiveExponent == 0) return 1;
        if (positiveExponent == 1) return base;

        double result = base;
        int exponent = positiveExponent;

        while (exponent != 1) {
            result *= result;
            exponent = exponent >> 1; // 除以2
        }

        if ((positiveExponent & 1) == 1) {
            // 奇数
            result *= base;
        }

        return result;
    }


}
