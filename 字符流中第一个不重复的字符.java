import java.util.*;
public class Solution {
    LinkedList<Character> q =  new LinkedList();
    short[] a = new short[256]; 
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if( ++a[ch]==1 ){
            q.add(ch);
        }
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        while( !q.isEmpty() && a[q.peek()]==2 ) q.remove();
        if( q.isEmpty() ){
            return '#';
        }
        return q.peek();
    }
}