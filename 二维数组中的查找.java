/*
 *题目描述
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * */

public class Solution {
    public boolean Find(int target, int[][] array){
        if( array.length==0 ) return false;
        //从左下角开始查找，比目标大就往上走，比目标小就往右走
        int i = array.length-1, j = 0;  //i -- 纵坐标 j -- 横坐标
        while( i>=0 && j<array[0].length ){
            if( array[i][j]==target ){
                return true;
            }else if( array[i][j]>target ){
                i--;
            }else{
                j++;
            }
        }
        return false;
    }
}
