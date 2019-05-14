/*
 * 题目描述
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * */

public class Solution {
    public double Power(double base, int exponent) {
        if( exponent==0 ) return 1;
        if( base==0 ) return 0;
        double res = 1.0;
        int abs = Math.abs(exponent);
        while( abs>0 ){
            if( (abs&1)==1 ) res *= base;
            base *= base;
            abs >>= 1;
        }
        return exponent<0 ? 1/res : res;
    }
}
