package com.baiiu.string;

/**
 * auther: baiiu
 * time: 17/4/15 15 10:59
 * description:
 */
public class Test {

    public static void main(String[] args) {
        String s = "goodgoogle"; //10
        String t = "oo";//6

        //int index = NativeStringMatcher.nativeStringMatching(s, t);
        //int index = NativeStringMatcher.nativeStringMatching2(s, t);

        int index = KMPStringMatcher.KMPStringMatcher(s, t);


        System.out.println("index: " + index + ", " + (index == s.indexOf(t)));
    }

}
