/*
 * 题目描述
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * */

public class Solution {

    //主要思路就是这个数组可以被数组最末的元素分为两部分，前一部分全部小于这个元素
    //后一部分全部大于这个元素，因为这是一个二叉搜索树的后序遍历序列。
    //如果当前这个数组满足这个条件，那么就分别遍历左右部分，直至最后每一个元素都被确认
    //用递归很容易想出来这个过程

    public boolean VerifySquenceOfBST(int [] sequence) {
        int len = sequence.length;
        if( len==0 ) return false;
        return judge(sequence, 0, len-1);
    }

    private boolean judge(int[] array, int s, int e){
        if( s>e ) return true;
        int i=e;
        while( i>s && array[i-1]>array[e] ) i--;
        for( int j=i-1; j>=s; --j ){
            if( array[j]>array[e] ){
                return false;
            }
        }
        return judge(array, s, i-1) && judge(array, i, e-1);
    }
}
