/*
 * 题目描述
在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * */
public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

    //这里要求是如果数组和长度输入都满足且存在重复数字，那么返回true
    //否则返回false
    //利用所有值都是0-n的特性，将每个值都放在数组对应的位置上，例如1就放在num[1]
    //这样到最后，如果一个值对应的下标处已经存在相同值，那么说明这个值是重复的
    public boolean duplicate(int numbers[],int length,int [] d) {
        if( len != numbers.length || numbers.length==0 ) return false;
        for( int i=0; i<length; i++ ){
            while( i!=numbers[i] ){
                if( numbers[i]==numbers[numbers[i]] ){
                    d[0] = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[temp] = temp;
            }
        }
        return false;
    }
}
