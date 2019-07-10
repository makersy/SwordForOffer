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
请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
*/
import java.util.*;
public class Solution {
    
    //BFS算法，将每一层的节点按对插入到队列中
    boolean isSymmetrical(TreeNode pRoot)
    {
        if( pRoot==null ) return true;
        Queue<TreeNode> q = new LinkedList();
        q.offer(pRoot.left);
        q.offer(pRoot.right);
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if( left==null && right==null ) continue;
            if( left==null || right==null ) return false;
            if( left.val != right.val ) return false;
            q.offer(left.left);
            q.offer(right.right);
            q.offer(left.right);
            q.offer(right.left);
        }
        return true;
    }
    
    //递归算法
    /*
    boolean isSymmetrical(TreeNode pRoot)
    {
        if( pRoot==null ) return true;
        return fun(pRoot.left, pRoot.right);
    }
    
    boolean fun(TreeNode left, TreeNode right){
        if( left==null && right==null ) return true;
        else if( left!=null && right!=null ) {
            if( left.val == right.val ){
                return fun(left.left, right.right) && fun(left.right, right.left);
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    */
}
