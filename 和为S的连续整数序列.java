/**
 * 题目描述
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
输出描述:
输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * */

import java.util.ArrayList;
public class Solution {
    //采用双指针的滑动窗口来进行处理，当窗口值大于sum时，左指针右移；窗口值小于sum时，右指针右移；
    //二者相等，将窗口添加进队列
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if( sum < 3 ) return res;

        int pl = 1, ph = 2, s = 0; //s是窗口值
        while( pl < ph ){
            s = (pl + ph) * (ph - pl + 1) / 2;
            if( s == sum ){
                ArrayList<Integer> temp = new ArrayList();
                for( int i=pl; i<=ph; i++ ){
                    temp.add(i);
                }
                res.add(temp);
                ph++;
            }else if( s < sum ) ph++;
            else pl++;
        }
        return res;
    }
}
