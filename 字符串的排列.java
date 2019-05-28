/*
 * 题目描述
输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。

 * */

import java.util.*;
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList();
        if( str.length()==0 ) return res;
        fun(str.toCharArray(), res, 0);
        Collections.sort(res);
        return res;
    }
    
    //迭代交换前后字符，实现所有排列
    private void fun(char[] c, ArrayList<String> res, int idx){
        if( idx == c.length-1 ){
            String str = new String(c);
            if( !res.contains(str) ) res.add(str);
            return;
        } else {
            for( int i=idx; i<c.length; ++i ){
                swap(c, idx, i);
                fun(c, res, idx+1);
                swap(c, idx, i);
            }
        }
    }
    
    //交换两个位置的字符
    private void swap(char[] c, int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}


