/*
 * 题目描述
求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * */

public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if( n<=0 ) return 0;
        int count = 0;
        int temp = 1;
        for( int i=1; i<=n; i*=10 ){
            temp = i*10;
            int tail = 0;
            if( n%temp > 2*i-1 ){
                tail = i;
            }else if( n%temp < i ){
                tail = 0;
            }else{
                tail = n%temp-i+1;
            }
            count += (n/temp*i) + tail;
        }
        return count;
    }
}
