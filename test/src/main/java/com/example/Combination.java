package com.example;

import java.util.Stack;

/**
 * auther: baiiu
 * time: 17/8/13 13 14:30
 * description: 组合
 * <p>
 * 输入一个字符串，输出该字符串中字符的所有组合。举个例子，如果输入abc，它的组合有a、b、c、ab、ac、bc、abc。
 */
public class Combination {

    /*
        2^n -1 个
     */
    public static void main(String[] args) {
        String s = "abc";
//        combination_bit(s.toCharArray());

        combination(s.toCharArray());
    }

    private static void combination_bit(char[] chars) {
        if (chars == null || chars.length == 0) return;

        int length = chars.length;
        int n = 1 << length;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < length; ++j) {
                if ((i & (1 << j)) != 0) { // 001 010 100
                    builder.append(chars[j]);
                }
            }
            System.out.println(builder.toString());

            builder.delete(0, builder.length());
        }
    }

    private static void combination(char[] chars) {
        if (chars == null || chars.length == 0) return;

        Stack<Character> stack = new Stack<>();
        for (int i = 1, length = chars.length; i <= length; ++i) {
            combination(chars, 0, i, stack);
        }
    }

    private static void combination(char[] chars, int start, int number, Stack<Character> stack) {
        if (number == 0) {
            System.out.println(stack.toString());
            return;
        }

        if (start == chars.length) {
            return;
        }

        stack.push(chars[start]);
        combination(chars, start + 1, number - 1, stack);
        stack.pop();
        combination(chars, start + 1, number, stack);
    }


    /*
void Combination(char *string ,int number , vector<char> &result)
{
    assert(string != NULL);
    if(number == 0)
    {
        static int num = 1;
        printf("第%d个组合\t",num++);

        vector<char>::iterator iter = result.begin();
        for( ; iter != result.end() ; ++iter)
            printf("%c",*iter);
        printf("\n");
        return ;
    }
    if(*string == '\0')
        return ;
    result.push_back(*string);
    Combination(string + 1 , number - 1 , result);
    result.pop_back();
    Combination(string + 1 , number , result);
}
     */


}
