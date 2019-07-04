/*
 * 题目描述
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * */

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果

import java.util.*;
public class Solution {
    //首先将所有数进行异或，结果就是两个不同的数的异或，然后找到这个值的1的位置，这个1的位置就是这两个
    //不同的数的不同的位（异或性质）。由此就按照这个位置是否为1将数组分为两组，然后在这2个组里分别异或。
    //结果就是这2个数
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int temp = 0;
        for( int num : array ){
            temp ^= num;
        }
        int pos = 0;  //1的位置
        for( ; pos<32; pos++ ){
            if( ((temp>>pos)&1) == 1 ){
                break;
            }
        }
        for( int num : array ){
            if( ((num>>pos)&1) == 1 ){
                num1[0] ^= num;
            }else num2[0] ^= num;
        }
    }
}
