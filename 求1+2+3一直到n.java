/*
 * 题目描述
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * */

public class Solution {
    //利用短路与运算符，将递归调用放在后面，递归成立条件放前面，如果条件
    //不成立就不会进入递归调用
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (n>0) && (sum += Sum_Solution(n-1))>0;
        return sum;
    }
}
