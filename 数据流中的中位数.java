/*
题目描述
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
*/

import java.util.*;
public class Solution {

    LinkedList<Integer> a = new LinkedList();
    public void Insert(Integer num) {
        for( int i=0; i<a.size(); ++i ){
            if( a.get(i)>num ){
                a.add(i, num);
                return;
            }
        }
        a.add(num);
    }

    public Double GetMedian() {
        int size = a.size();
        if( (size&1)==1 ){
            //奇数个
            return Double.parseDouble(String.valueOf(a.get(size / 2)));
        }else{
            Double temp = (a.get(size / 2) + a.get(size / 2 - 1))/2.0;
            return temp;
        }
    }


}