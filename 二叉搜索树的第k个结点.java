/*
��Ŀ����
����һ�ö��������������ҳ����еĵ�kС�Ľ�㡣���磬 ��5��3��7��2��4��6��8��    �У��������ֵ��С˳�����С����ֵΪ4��
*/
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
public class Solution {
    private int count = 0;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if ( pRoot!=null ){
            TreeNode node = KthNode(pRoot.left, k);
            if( node!=null ){
                return node;
            }
            if( ++count==k ){
                return pRoot;
            }
            node = KthNode(pRoot.right, k);
            if( node!=null ) return node;
        }
        return null;
    }
}