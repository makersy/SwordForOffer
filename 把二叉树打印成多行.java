
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
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
*/

import java.util.*;
public class Solution {
    
    //使用一个队列来保存每一层的节点，取出和存入都按照顺序
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if( pRoot==null ) return res;
        Queue<TreeNode> temp = new LinkedList();
        temp.offer(pRoot);
        
        int s, e;
        while( !temp.isEmpty() ){
            s = 0;
            e = temp.size();
            ArrayList<Integer> list = new ArrayList();
            for( ; s<e; s++ ){
                TreeNode node = temp.poll();
                list.add(node.val);
                if( node.left!=null ) temp.offer(node.left);
                if( node.right!=null ) temp.offer(node.right);
            }
            res.add(list);
        }
        return res;
    }
    
}
