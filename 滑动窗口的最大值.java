
/**
题目描述
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
*/

import java.util.ArrayList;

/**
 * {4,4,6,6,6,5}
 */
public class Main {


    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> a = new ArrayList();
        int len = num.length;
        if( len==0 || size<=0 ) return a;

        for( int s=0, e=size-1; e<len; ++s, ++e ){
            int index = 0;
            int[] array = new int[size];
            for( int i=s; i<=e; ++i ){
                array[index++] = num[i];
            }
            a.add(findMax(array, size));
        }

        return a;
    }

    private int findMax(int[] a, int size){
        int max = Integer.MIN_VALUE;
        for( int i=0; i<size; i++){
            if( a[i]>max ){
                max = a[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
	// write your code here

        int[] num = {0,0,0,1};
        System.out.println(new Main().maxInWindows(num, 3));
    }
}
