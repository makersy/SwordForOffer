/*
 * 题目描述
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * */

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> a = new ArrayList<>();
        int r = matrix.length;
        if( r==0 ) return a;
        int c = matrix[0].length-1;
        int i=0, jx=c, jy=r-1;
        while( i<=jx && i<=jy ){
            round(i, i, jx--, jy--, a, matrix);
            i++;
        }
        return a;
    }

    public void round(int a, int b, int c, int d, ArrayList<Integer>array, int[][] m){

        for( int i=a; i<=c; i++ ){
            array.add(m[b][i]);
        }

        if( b==d ){
            return;
        }
        for( int i=b+1; i<=d; i++ ){
            array.add(m[i][c]);
        }

        for( int i=c-1; i>=a; i-- ){
            array.add(m[d][i]);
        }
        if( a==c ) return;
        for( int i=d-1; i>=b+1; i-- ){
            array.add(m[i][a]);
        }
    }
}
