/*
 * 题目描述
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
*/

import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if( !stack1.isEmpty() ){
            stack1.push(node);
        }else{
            stack2.push(node);
        }
    }

    //若其中一个栈为空，另一个不为空，把
    public int pop() {
        if( !stack1.isEmpty() ){
            while( !stack1.isEmpty() ){
                stack2.push(stack1.pop());
            }
            int res = stack2.pop();
            stack1.clear();
            while( !stack2.isEmpty() ){
                stack1.push(stack2.pop());
            }
            return res;
        }else{
            while( !stack2.isEmpty() ){
                stack1.push(stack2.pop());
            }
            int res = stack1.pop();
            stack2.clear();
            while( !stack1.isEmpty() ){
                stack2.push(stack1.pop());
            }
            return res;
        }
    }
}
