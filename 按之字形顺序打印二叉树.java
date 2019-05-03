/*
题目描述
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
*/



import java.util.ArrayList;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/

//利用栈的特性，奇数层时把当前层的下一层的节点从左到右地存入，到了偶数层就会从右到左地取出；偶数层同理
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        Stack<TreeNode> a = new Stack();    //存储奇数层的
        Stack<TreeNode> b = new Stack();    //偶数层的
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        a.push(pRoot);
        
        int depth = 1;
        while( !a.empty() || !b.empty() ){
            if( (depth&1)==1 ){
                //奇数层
                ArrayList<Integer> temp = new ArrayList();
                while( !a.isEmpty() ){
                    TreeNode x = a.pop();
                    if( x!=null ){
                        temp.add(x.val);
                        b.push(x.left);
                        b.push(x.right);
                    }
                }
                if( !temp.isEmpty() ){
                    res.add(temp);
                    depth++;
                } 
            }else{
                //偶数层
                ArrayList<Integer> temp = new ArrayList();
                while( !b.isEmpty() ){
                    TreeNode x = b.pop();
                    if( x!=null ){
                        temp.add(x.val);
                        a.push(x.right);
                        a.push(x.left);
                    }
                }
                if( !temp.isEmpty() ){
                    res.add(temp);
                    depth++;
                } 
            }
        }
        return res;
    }

}