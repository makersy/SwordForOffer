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
给定一棵二叉搜索树，请找出其中的第k小的结点。
例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
*/
public class Solution {
    
    int cnt = 0;
    /*
    根据二叉搜索树，最小的节点为左下角节点。那么就可以先找到左下角节点，
    然后找他的父节点，右节点，依次递归
    */
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        /*
        此if语句内部：如果当前节点不为null，遍历左子树，判断其中是否有第k小节点，如果有，
        直接返回第k小节点；如果没有，再判断当前节点，如果仍然不是，再判断右子树中有没有，
        如果左右子树及当前节点都不是第k小，出if，返回null给上一层。
        判断左右子树是否存在第k小节点的条件：返回值是否为null。
        当前节点是第k小节点的条件：计数值cnt == k。
        */
        if( pRoot != null ){
            TreeNode node = KthNode(pRoot.left, k);
            
            //当返回值不是null，即已找出第k小节点时，直接将其返回上一层
            if( node!=null ) return node;
            
            //当到达左下角时开始计数
            if( ++cnt==k ) return pRoot;
            node = KthNode(pRoot.right, k);
            if( node!=null ) return node;
        }
        return null;
    }
    


}
