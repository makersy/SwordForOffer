/*
 * 题目描述
地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
*/


public class Solution {
    public int movingCount(int k, int rows, int cols)
    {
        if( rows<=0 || cols<=0 ) return 0;
        boolean[] flag = new boolean[rows*cols];

        if( k<0 ){
            return 0;
        }
        return fun(k, rows, cols, 0, 0, flag);
    }

    public int fun(int k, int rows, int cols, int x, int y, boolean[] flag){
        if( x<0 || x>=rows || y<0 || y>=cols || flag[x*cols+y] ){
            return 0;
        }
        if( get(x)+get(y) > k ){
            return 0;
        }
        flag[x*cols+y] = true;
        return 1 + fun(k, rows, cols, x-1, y, flag) + fun(k, rows, cols, x+1, y, flag) +
                    fun(k, rows, cols, x, y-1, flag) + fun(k, rows, cols, x, y+1, flag);
    }

    public int get(int num){
        int sum = 0;
        while(num > 0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }

    private int max(int a, int b, int c, int d){
        return Math.max(Math.max(a, b), Math.max(c, d));
    }
}
