/*
 * 题目描述
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * */

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
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if( root1==null || root2==null ) return false;

        //用一个arraylist来保存root1子节点中和root2相等的节点
        ArrayList<TreeNode> list = new ArrayList();
        getSameNode(list, root1, root2);

        //遍历所有temp节点，看是否有满足的子树
        for( TreeNode temp : list ){
            if( isSubTree(temp, root2) ){
                //如果root2树是temp树的子树
                return true;
            }
        }
        return false;
    }

    //获取now节点子节点中和node相等的那个节点
    public void getSameNode(ArrayList<TreeNode> list, TreeNode now, TreeNode node){
        if( now==null || node==null ) return;
        if( now.val == node.val ) list.add(now);
        getSameNode(list, now.left, node);
        getSameNode(list, now.right, node);
    }

    //判断以node2树是否是node1树的子结构
    public boolean isSubTree(TreeNode node1, TreeNode node2){
        //注意子树不要求完整包含父树左右节点，因此只要遍历到最后node2没有出现与node1不同的情况即可
        if( node2==null ) return true;
        //如果node2不是null，但是node1此位置没有值，那么说明不是子树
        if( node1==null ) return false;
        if( node1.val != node2.val ) return false;
        return isSubTree(node1.left, node2.left) && isSubTree(node1.right, node2.right);
    }
}
