import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
        int len = A.length;
        if( len==0 ) return null;
        int[] res = new int[len];
        int temp=1;
        res[0] = 1;
        for( int i=0; i<len-1; ++i ){
            temp *= A[i];
            res[i+1] = temp;
        }
        temp = 1;
        for( int i=len-2; i>=0; --i ){
            temp *= A[i+1];
            res[i] *= temp;
        }
        return res;
    }
}