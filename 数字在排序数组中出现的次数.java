/*
 * 题目描述
统计一个数字在排序数组中出现的次数。
 * */
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        int len = array.length;
        if( len==0 ) return 0;
        int res = 0;
        int i = 0;
        for( ; i<len; i++ ){
            if( array[i]==k ) break;
        }
        for( ; i<len; i++ ){
            if( array[i]!=k ) break;
            else res++;
        }
        return res;
    }
}
