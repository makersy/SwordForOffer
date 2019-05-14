/*
 * 题目描述
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * */

public class Solution {
    public void reOrderArray(int [] array) {
        //可以采用插入排序的思想，将奇数插入到奇数队列,这个时间复杂度有点高，是O(n2)的
        //想要时间复杂度更低，需要使用空间换时间，新开一个数组，先装入奇数在装入偶数
        int len = array.length;
        if( len ==0 ) return;
        int indexOdd=0, indexEven=0;
        int[] num = new int[len];
        for( int i=0; i<len; ++i ){
            if( (array[i]&1)==1 ){
                num[indexOdd++] = array[i];
            }
        }
        indexEven = indexOdd;
        for( int i=0; i<len; ++i ){
            if( (array[i]&1)==0 ){
                num[indexEven++] = array[i];
            }
        }
        System.arraycopy(num, 0, array, 0, len);
    }
}
