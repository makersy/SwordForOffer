/*
��Ŀ����
����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
*/

/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if( pNode==null ) return pNode;
        //������Һ��ӣ���ת���Һ��ӣ�Ȼ��һֱ�������ӵ����
        TreeLinkNode now = pNode;
        if( now.right!=null ){
            now = now.right;
            while( now.left!=null ){
                now = now.left;
            }
            return now;
        }
        //������������򿴸��ڵ㣬�����ڵ�������Ǵ˽ڵ㣬���ظ��ڵ㣻����ת�����ڵ�ĸ��ڵ㣬�������ж�
        while( now.next!=null ){
            if( now.next.left==now ){
                return now.next;
            }
            now = now.next;
        }
        //û�и��ڵ㣬Ҳû���Һ��ӣ�˵��û����һ������ڵ���
        return null;
    }
}