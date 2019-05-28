/*
 * 题目描述
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * */

import java.util.*;

public class Solution {
    //用最大/小堆
    //在java中，优先队列使用了最大/小堆来实现
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        int len = input.length;
        if( len==0 || k==0 || k>len ) return res;
        Queue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for( int i=0; i<len; ++i ){
            if( maxHeap.size() != k ){
                maxHeap.add(input[i]);
            } else if( maxHeap.peek()>input[i] ) {
                maxHeap.remove();
                maxHeap.add(input[i]);
            }
        }
        for( Integer temp : maxHeap ){
            res.add(temp);
        }
        return res;
    }
}
