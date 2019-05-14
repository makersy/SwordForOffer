/*
 * 题目描述
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * */

public class Solution {
    public int NumberOf1(int n) {
        // 用flag来进行左移运算来判断每一位是否是1，由于flag和n长度一样，所以当flag=0时就数完了
        int count = 0;
        int flag = 1;
        while( flag!=0 ){
            if( (n&flag) != 0 ){
                count++;
            }
            flag <<= 1;
        }
        return count;
    }
}
