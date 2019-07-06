/*
 * 题目描述
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
输出描述:
对应每个测试案例，输出两个数，小的先输出。
 * */

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int len = array.length;
        ArrayList<Integer> res = new ArrayList();
        if( len==0 ) return res;
        int s = 0, e = len-1;
        while( s < e ){
            if( array[s] + array[e] == sum ){
                res.add(array[s]);
                res.add(array[e]);
                break;
            }else if( array[s] + array[e] < sum ){
                s++;
            }else e--;
        }
        return res;
    }
}
