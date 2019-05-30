/*
 * 题目描述
把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * */

public class Solution {
    //要求丑数的质因子只有2、3、5，可以有其他非质因子
    //如果要求质因子只有2/3/5，那么只需要从1开始轮番乘2/3/5，得到的数一定只有2/3/5的质因子
    public int GetUglyNumber_Solution(int index) {
        if( index<=0 ) return 0;
        int[] res = new int[index];  //存放丑数
        res[0] = 1;
        int now=1, idx2=0, idx3=0, idx5=0;
        int temp2, temp3, temp5;
        int min;
        while( now<index ){
            temp2 = res[idx2] * 2;
            temp3 = res[idx3] * 3;
            temp5 = res[idx5] * 5;
            min = Math.min(temp2, Math.min(temp3, temp5));
            res[now] = min;
            if( min==temp2 ) idx2++;
            if( min==temp3 ) idx3++;
            if( min==temp5 ) idx5++;
            now++;
        }
        return res[index-1];
    }
}
