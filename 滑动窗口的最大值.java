import java.util.*;
/*
题目描述
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
{[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， 
{2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
*/
public class Solution {
    
    /*
    使用队列来保存一个窗口的最大值所在的索引，每次移动窗口时将新元素与当前窗口头尾进行比较，
    从头开始，用窗口起始索引比较，将不在此窗口内的元素丢掉；
    从尾开始，用num[i]进行比较，将小于当前值的元素丢掉，将当前元素加入队列
    这样一来，每次计算都丢弃了不在窗口中的无用数，同时还使窗口始终保持从大到小的排序，每次取
    队列头就是窗口最大值
    */
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList();
        if( num==null || size<=0 ) return res;
        
        ArrayDeque<Integer> q = new ArrayDeque();
        int s = 0;
        for( int i=0; i<num.length; i++ ){
            s = i - size + 1;  //窗口的起始位置
            
            //除去不属于当前窗口的索引
            if( q.isEmpty() ){
                q.add(i);
            }else if( q.peekFirst() < s ){
                q.pollFirst();
            }
            
            //除去比当前值小的
            while( !q.isEmpty() && num[q.peekLast()] <= num[i] ) q.pollLast();
            q.add(i);
            if( s >= 0 ) res.add(num[q.peekFirst()]);
        }
        return res;
    }
}
