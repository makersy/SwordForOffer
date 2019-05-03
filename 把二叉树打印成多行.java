/*
��Ŀ����
���ϵ��°����ӡ��������ͬһ����������������ÿһ�����һ�С�
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
import java.util.*;
public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        LinkedList<TreeNode> a = new LinkedList();
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if( pRoot==null ) return res;
        a.add(pRoot);
        
        while( !a.isEmpty() ){
            int s=0, e=a.size();
            ArrayList<Integer> temp = new ArrayList();
            while( s++<e ) {
                TreeNode x = a.poll();
                temp.add(x.val);
                if( x.left!=null ) a.add(x.left);
                if( x.right!=null ) a.add(x.right);
            }
            res.add(temp);
        }
        return res;
    }
    
}