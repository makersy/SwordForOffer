/*
    题目描述
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 
但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
*/


public class Solution {
    public boolean isNumeric(char[] str) {
        int len = str.length;
        if( len==0 ) return false;
        boolean flag = true;
        boolean[] flags = new boolean[3]; // 0 -- +/- 1--.  2 -- e
        
        for( int i=1; i<len; ++i ){
            //有e/E的话，后面一定有数字
            if( str[i]=='E' || str[i]=='e' ){
                if( i==len-1 ) return false;
                if( flags[2] ){
                    return false;
                }
                flags[2] = true;
            }else if( str[i]=='+' || str[i]=='-' ){
                //出现+/-符号，必须在开头或紧跟在e之后
                if( flags[0] && str[i-1]!='E' && str[i-1]!='e'){
                    //如果第二次出现，且不在e后,false
                    return false;
                }
                if( !flags[0] && i>0 && str[i-1]!='E' && str[i-1]!='e' ){
                    //如果第一次出现,且不在e后，不在开头，false
                    return false;
                }
                flags[0] = true;
            }else if( str[i]=='.' ){
                //出现.符号，不能在e后,不能出现两次
                if( flags[1] || flags[2]){
                    return false;
                }
                flags[1] = true;
            }else if( str[i]<'0' || str[i]>'9' ){
                return false;
            }
        }
        return true;
    }
}