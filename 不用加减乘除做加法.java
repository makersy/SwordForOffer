/*
 * 题目描述
写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * */

public class Solution {
    //1. 两个数相异或，代表将两个数相加（不考虑进位）
    //2. 两个数相与，代表得出两个数相加的进位
    //3. 将前两步结果相加即可得出最后结果

    public int Add(int num1,int num2) {
        while( num2!=0 ){
            int sum = num1^num2;
            num2 = (num1 & num2) << 1;
            num1 = sum;
        }
        return num1;
    }
}
