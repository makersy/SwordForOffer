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
/*
题目描述
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
*/
import java.util.*;

public class Solution {
    
    private Stack<TreeNode> s1 = new Stack(), s2 = new Stack();
    
    //利用两个栈来保存奇数层和偶数层的节点，奇数层顺序放入，偶数层逆序放入，这样由于栈的
    //后进先出特性，可以实现之字形打印
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if( pRoot==null ) return res;
        
        s1.push(pRoot);
        while( !s1.empty() || !s2.empty() ){
            if( !s1.empty() ){
                ArrayList<Integer> temp = new ArrayList();
                while( !s1.empty() ){
                    TreeNode node = s1.pop();
                    temp.add(node.val);
                    if( node.left!=null ) s2.push(node.left);
                    if( node.right!=null ) s2.push(node.right);
                }
                res.add(temp);
            }else{
                ArrayList<Integer> temp = new ArrayList();
                while( !s2.empty() ){
                    TreeNode node = s2.pop();
                    temp.add(node.val);
                    if( node.right!=null ) s1.push(node.right);
                    if( node.left!=null ) s1.push(node.left);
                }
                res.add(temp);
            }
        }
        return res;
    }

}
