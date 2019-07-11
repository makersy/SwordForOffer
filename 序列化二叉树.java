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
请实现两个函数，分别用来序列化和反序列化二叉树
*/

public class Solution {
    
    int index = -1;
    
    StringBuilder sb = new StringBuilder();
    
    //序列化前序遍历，遇到空节点采用 # 填充
    //反序列化采用相同的方式
    String Serialize(TreeNode root) {
        
        if( root==null ) sb.append("#,");
        else {
            sb.append(root.val + ",");
            Serialize(root.left);
            Serialize(root.right);
        }
        return sb.toString();
    }
    
    TreeNode Deserialize(String str) {
        index++;
        String[] strs = str.split(",");
        
        TreeNode node = null;
        if( !strs[index].equals("#") ){
            node = new TreeNode(Integer.valueOf(strs[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
