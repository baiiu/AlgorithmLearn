package com.baiiu;

public class MyClass {

    private static int TARGET = 17;

    public static void main(String[] args) {

        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = i;
        }

        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (i + j == TARGET) {
                    System.out.println(i + ", " + j + "， " + i * j);
                }
            }
        }

    }

}
