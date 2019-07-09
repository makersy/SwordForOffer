/*
题目描述
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */

import java.util.ArrayList;
public class Main3 {
    //将其转化为一个上三角和下三角的形式，中间的对角线可以看做1
    //我们只需要将上三角和下三角乘出来即可
    public int[] multiply(int[] A) {
        if( A == null ) return null;
        int len = A.length;
        int[] res = new int[len];
        res[0] = 1;
        //计算下三角
        for( int i=1; i<len; i++ ){
            res[i] = res[i-1] * A[i-1];
        }
        //计算上三角
        int temp = 1;
        for( int j=len-2; j>=0; j-- ){
            temp *= A[j+1];
            res[j] *= temp;
        }
        return res;
    }
}
