import java.util.*;
public class Solution {

    //LinkedList使表中字符按输入顺序排序，且起到了set的去重作用；
    //使用一个char型数组充当简易哈希表，存储每个字符的出现次数
    
    private LinkedList<Character> list = new LinkedList();

    private char[] times = new char[256];

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if( ++times[ch]==1 ) list.add(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        while( !list.isEmpty() && times[list.peek()]>1 ) {
            list.remove();
        }
        return list.isEmpty() ? '#' : list.peek();
    }
    
}
