/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length==0)return null;
        TreeNode root=new TreeNode(preorder[0]);
        int i=1;
        if(i>=preorder.length)return root;
        Stack<TreeNode>st=new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            int el=preorder[i];
            TreeNode node=st.peek();
            if(preorder[i]<node.val){
                node.left=new TreeNode(preorder[i]);
                i++;
                if(i>=preorder.length)break;
                node=node.left;
                st.push(node);
            }
            else{
                while(!st.isEmpty() && st.peek().val<preorder[i]){
                    node=st.pop();
                }
                node.right=new TreeNode(preorder[i]);
                i++;
                if(i>=preorder.length)break;
                node=node.right;
                st.push(node);
            }
        }
        return root;
    }
}