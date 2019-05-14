/*
 * 题目描述
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */

import java.util.Stack;

public class Solution {

    Stack<Integer> stack1 = new Stack(), stack2 = new Stack();

    public void push(int node) {
        //如果stack2为空，push；不为空，比较并push
        if( stack2.isEmpty() ){
            stack2.push(node);
        }else{
            if( node<stack2.peek() ){
                stack2.push(node);
            }
        }
        stack1.push(node);
    }

    public void pop() {
        if( stack1.peek()==stack2.peek() ){
            stack2.pop();
        }
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
