package com.example;

/**
 * author: baiiu
 * date: on 17/6/2 10:53
 * description:
 */
class Question10_NumberOfOneInBinary {

    /**
     * 输入一个整数，输出该整数的二进制表示中1的个数。
     * <p>
     * 考虑负数
     */
    static void test() {
        int number = -11;
//        int number = 11;

        countsNumberOfOne_Wonderful(number);
        countsNumberOfOne1(number);
        countsNumberOfOne2(number);
        countsNumberOfOne_Stupid(number);
    }

    /*
        原值减去1后，与原值相与。则相当于原值最右边的1变为0
     */
    private static void countsNumberOfOne_Wonderful(int number) {
        int count = 0;

        while (number != 0) {
            number = number & (number - 1);
            ++count;
        }

        System.out.println(count);
    }

    // 移动标志位
    private static void countsNumberOfOne2(int number) {
        int count = 0, flag = 1;

        for (int i = 0; i < 32; ++i) {
            if ((number & flag) == flag) {
                ++count;
            }

            flag = flag << 1;
        }

        System.out.println(count);

    }

    // 使用位运算，进行右移判断
    private static void countsNumberOfOne1(int number) {
        int count = 0;

        //
        while (number != 0) {
            if ((number & 1) == 1) {
                ++count;
            }

            number = number >>> 1; //无符号右移，前面补0
            // number = number >> 1; // 右移，前面补符号位
        }

        System.out.println(count);
    }

    // 愚蠢的解法，整数本身存储的就是二进制数，可以使用位运算
    /*
            1. 将该整数转化为二进制
            2. 计算该二进制数中1的个数

            [十进制转二进制](http://zh.wikihow.com/%E4%BB%8E%E5%8D%81%E8%BF%9B%E5%88%B6%E8%BD%AC%E6%8D%A2%E4%B8%BA%E4%BA%8C%E8%BF%9B%E5%88%B6)

            负数的二进制表示：
                该正数的二进制表示的补码：原码各位取反 + 1
    */
    private static void countsNumberOfOne_Stupid(int number) {
//        StringBuilder builder = new StringBuilder();
//
//        int positiveNumber = Math.abs(number);
//        while (positiveNumber != 0) {
//            int remainder = positiveNumber % 2;
//            positiveNumber = positiveNumber / 2;
//
//            builder.append(remainder);
//        }
//        builder.reverse();

        int count = 0;
//        String numberString = builder.toString();
        String numberString = Integer.toBinaryString(number);
        byte[] bytes = numberString.getBytes();
//        if (number >= 0) {
        for (byte aByte : bytes) {
            if ('1' == aByte) {
                ++count;
            }
        }
//        } else {
//            //进行取反,还要考虑int字节是4个，32位
//            /*
//                stupid
//             */
//            for (int i = 0, length = bytes.length; i < length; ++i) {
//                if (bytes[i] == '1') {
//                    bytes[i] = '0';
//                } else {
//                    bytes[i] = '1';
//                }
//            }
//            System.out.println(new String(bytes));
//        }

        System.out.println(Integer.toBinaryString(number));
        System.out.println(numberString + ", " + count);

    }


}
