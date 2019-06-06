/*
 * 题目描述
在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * */

import java.util.*;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        int len = str.length();
        if( len==0 ) return -1;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap();
        for( int i=0; i<len; ++i ){
            char c = str.charAt(i);
            if( !map.containsKey(c) ){
                map.put(c, 1);
            }else{
                int v = map.get(c);
                map.put(c, v+1);
            }
        }
        Set<Character> set = map.keySet();
        int res = -1;
        for( char temp : set ){
            if( map.get(temp)==1 ){
                res = str.indexOf(temp);
                break;
            }
        }
        return res;
    }
}
