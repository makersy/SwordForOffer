/*
 * 题目描述
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * */

public class Solution {

    int[] temp;  //用来临时存储排好序的数组
    int cnt;  //记录逆序对个数
    int mod = 1000000007;

    public int InversePairs(int [] array) {
        int len = array.length;
        if( len==0 ) return 0;
        temp = new int[len];
        merge(array, 0, len-1);
        return cnt;
    }

    //归并排序思想，分为左右两部分分别排好序，最终把左右两部分合并到一起
    public void merge(int[] a, int start, int end){
        if( start>=end ) return;
        int mid = (start + end) / 2;
        merge(a, start, mid);
        merge(a, mid+1, end);
        mergeSub(a, start, mid, end);
    }

    //将排好序的左半部分和右半部分合并到一起，最终形成一个整体有序的数组
    public void mergeSub(int[] a, int s, int m, int e){
        int i = s, j = m + 1;
        int idx = 0;  //记录排序数组当前最后的元素位置
        while( i<=m && j<=e ){
            if( a[i]<a[j] ){
                temp[idx++] = a[i++];
            }else{
                temp[idx++] = a[j++];
                cnt += (m-i+1);
                cnt %= mod;
            }
        }
        while( i<=m ) temp[idx++] = a[i++];
        while( j<=e ) temp[idx++] = a[j++];
        //将a数组中对应位置的数覆盖为有序的数组temp
        for( int k=0; k<=(e-s); k++ ){
            a[s+k] = temp[k];
        }
    }
}
