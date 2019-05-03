/*
��Ŀ����
��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
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

//����ջ�����ԣ�������ʱ�ѵ�ǰ�����һ��Ľڵ�����ҵش��룬����ż����ͻ���ҵ����ȡ����ż����ͬ��
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        Stack<TreeNode> a = new Stack();    //�洢�������
        Stack<TreeNode> b = new Stack();    //ż�����
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        a.push(pRoot);
        
        int depth = 1;
        while( !a.empty() || !b.empty() ){
            if( (depth&1)==1 ){
                //������
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
                //ż����
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