/*
   题目描述
    请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
    路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
    如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 
    例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩
    阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能
    再次进入该格子。
*/

public class Solution {
    
    /*
      使用一个bool型数组来映射此矩阵，记录是否被访问过。经过一个地方时就设置flag为true，代表
      此位置是该路径所经过的地方，如果此路径不满足条件，就重置flag，尝试新的路径
    */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if( matrix==null || rows*cols!=matrix.length ) return false;
        boolean[] flags = new boolean[matrix.length];
        for(int i=0; i<cols; i++ ){
            for( int j=0; j<rows; j++ ){
                if( fun(matrix, rows, cols, i, j, str, 0, flags) ) return true;
            }
        }
        return false;
    }

    //x 横坐标 y 纵坐标
    private boolean fun(char[] m, int rows, int cols, int x, int y, char[] str, int idx, boolean[] flags){
        int index = y * cols + x;
        if( x>=cols || x<0 || y>=rows || y<0 || m[index]!=str[idx] || flags[index] ) return false;
        //如果字符串和矩阵全部对应
        if( idx==str.length-1 ) return true;
        flags[index] = true;
        if( fun(m, rows, cols, x+1, y, str, idx+1, flags) ||
          fun(m, rows, cols, x, y+1, str, idx+1, flags) ||
          fun(m, rows, cols, x-1, y, str, idx+1, flags) ||
          fun(m, rows, cols, x, y-1, str, idx+1, flags) ){
            return true;
        }
        //如果从当前位置出发任何方向都不行，那么重置flag访问记录
        flags[index] = false;
        return false;
    }

}
