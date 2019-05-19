/*
 * 题目描述
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * */

import java.util.Stack;

public class Solution {

    //整体思路是按压入顺序入栈，当出现栈顶元素等于popA当前位置元素时就开始出栈
    //直到栈为空或栈顶元素不等于popA时，继续入栈。这样将压入栈走完了之后，如果
    //辅助栈不为空说明此序列不是那个栈的弹出顺序
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int len1 = pushA.length, len2 = popA.length;
        if( len1 != len2 || (len1==0 || len2==0 ) ) return false;

        //辅助栈
        Stack<Integer> stack = new Stack();

        int idx=0;
        for( int i=0; i<len1; ++i ){
            stack.push(pushA[i]);
            while( !stack.isEmpty() && stack.peek()==popA[idx] ){
                stack.pop();
                idx++;
            }
        }
        return stack.isEmpty();
    }
}
