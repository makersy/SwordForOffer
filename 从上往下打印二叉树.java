/**
 * 题目描述
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * */


import java.util.ArrayList;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
import java.util.*;
public class Solution {
    
    //用一个辅助队列来记录每一层的节点，每一层都是从左往右遍历
    //这里要注意往队列尾部插入不是用push，而是add。push相当于addFirst，头插
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList();
        if( root==null ) return res;
        
        LinkedList<TreeNode> nodeList = new LinkedList();
        TreeNode now = root;
        nodeList.push(now);
        
        while( !nodeList.isEmpty() ){
            TreeNode temp = nodeList.poll();
            res.add(temp.val);
            if( temp.left!=null ) nodeList.add(temp.left);
            if( temp.right!=null ) nodeList.add(temp.right);
        }
        return res;
    }
}
