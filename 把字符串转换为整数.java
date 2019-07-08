/*
 * 题目描述
将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
输入描述:
输入一个字符串,包括数字字母符号,可以为空
输出描述:
如果是合法的数值表达则返回该数字，否则返回0
示例1
输入
复制
+2147483647
    1a33
输出
复制
2147483647
    0
 * */

public class Solution {
    //先用正则表达式判断这个字符串是不是一个数，如果是，
    //那么从最后一位开始将其转换为数字
    public int StrToInt(String str) {
        String reg = "[+|-]?[1-9][0-9]*";
        int res = 0;
        if( str.matches(reg) ){
            int base = 1;
            for( int i=str.length()-1; i>=1; i-- ){
                res += (str.charAt(i)-'0')*base;
                base *= 10;
            }
            if( str.charAt(0)=='-' ){
                res = -res;
            }else if( str.charAt(0)!='+' ){
                res += (str.charAt(0)-'0')*base;
            }
        }
        return res;
    }
}
