/*
 * 题目描述
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * */


public class Solution {
    public int RectCover(int target) {

        //因为n是奇数还是偶数会影响覆盖方法的数量，所以可以用n之前最接近的两个数（一奇一偶）来计算
        //转化成可以根据前一部分的状态来得出后一部分的方法数
        if( target==0 ) return 0;
        if( target==1 ) return 1;
        int i=1, j=2, cnt=2;
        while( cnt<target ){
            j += i;
            i = j - i;
            ++cnt;
        }
        return j;
    }
}
