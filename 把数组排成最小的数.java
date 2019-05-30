/*
 * 题目描述
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * */

import java.util.ArrayList;

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        int len = numbers.length;
        if( len==0 ) return "";
        ArrayList<Integer> list = new ArrayList<>();
        for( int temp : numbers ){
            list.add(temp);
        }
        list.sort((Integer a, Integer b)->{
            String str1 = "" + a + b;
            String str2 = "" + b + a;
            return str1.compareTo(str2);
        });
        StringBuilder sb = new StringBuilder();
        for( int temp : list ){
            sb.append(String.valueOf(temp));
        }
        return sb.toString();
    }
}
