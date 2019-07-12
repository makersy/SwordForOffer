/*
 题目描述
地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向
移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格
（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人
能够达到多少个格子？
*/
public class Solution {
    
    //使用标记数组记录已到达过的格子，递归遍历
    public int movingCount(int t, int rows, int cols)
    {
        if( t<0 || rows <= 0 || cols <= 0 ) return 0;
        boolean[] flag = new boolean[rows*cols];  //已访问标记
        return fun(t, 0, 0, rows, cols, flag);
    }
    
    //遍历. m 行数 n 列数
    public int fun(int t, int x, int y, int m, int n, boolean[] flag){
        if( getBitSum(x, y) > t || x>=n || x<0 || y>=m || y<0 ){
            return 0;
        }
        if( flag[y*n+x] ) return 0;
        
        flag[y*n+x] = true;
        return 1 + fun(t, x+1, y, m, n, flag) + fun(t, x, y+1, m, n, flag)
            + fun(t, x-1, y, m, n, flag) + fun(t, x, y-1, m, n, flag);
    }
    
    public int getBitSum(int a, int b){
        int sum = 0;
        while( a > 0 ){
            sum += a%10;
            a /= 10;
        }
        while( b > 0 ){
            sum += b%10;
            b /= 10;
        }
        return sum;
    }
} 
