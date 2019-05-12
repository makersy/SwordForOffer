/*题目描述
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
*/

public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if( matrix.length==0 || rows*cols != matrix.length){
            return false;
        }
        boolean[] flag = new boolean[matrix.length];  //记录每个位置是否到达过，到达过的格子不能再经过
        for( int i=0; i<rows; ++i ){
            for( int j=0; j<cols; ++j ){
                if( fun(matrix, rows, cols, i, j, 0, flag, str) ){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean fun(char[] m, int rows, int cols, int x, int y, int idx, boolean[] flag, char[] str){
        int index = x*cols+y; //计算str当前位置字符在matrix中位置
        if( x<0 || x>=rows || y<0 || y>=cols || m[index]!=str[idx] || flag[index]){
            return false;
        }
        if( idx==str.length-1 ){
            //字符串全部对应
            return true;
        }
        flag[index] = true; //将当前位置设置为到达过
        if ( fun(m, rows, cols, x-1, y, idx+1, flag, str) ||
          fun(m, rows, cols, x+1, y, idx+1, flag, str) ||
          fun(m, rows, cols, x, y-1, idx+1, flag, str) ||
          fun(m, rows, cols, x, y+1, idx+1, flag, str) ){
            return true;
        }
        flag[index] = false;  //如果从当前位置出发没有满足条件路径，就设置为未到达过，防止影响遍历其他位置
        return false;
    }

}
