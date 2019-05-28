/*
 * 题目描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * */

public class Solution {
    //总共进行两次遍历。
    //第一次遍历找出出现次数可能最多的。采用攻守思想，将第一个元素设为出现最多元素，遇到相同元素cnt++，不同的cnt--，
    //如果cnt==0,就替换出现最多元素为当前元素，直到遍历完整个数组。
    //第二次遍历判断此元素是否正确，记录此元素出现次数并*2判断
    public int MoreThanHalfNum_Solution(int [] array) {
        int len = array.length;
        if( len == 0 ) return 0;

        int most = array[0], cnt = 1;
        for( int i=1; i<len; ++i ){
            if( array[i]==most ) ++cnt;
            else {
                if( --cnt == 0 ){
                    most = array[i];
                    cnt = 1;
                }
            }
        }
        cnt = 0;
        for( int i=0; i<len; ++i ){
            if( array[i] == most ) ++cnt;
        }
        if( cnt*2 <= len ){
            most = 0;
        }
        return most;
    }
}
