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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        Stack<TreeNode>st=new Stack<>();
        if(root!=null)st.add(root);
        while(!st.isEmpty()){
            root=st.pop();
            ans.add(root.val);
            if(root.left!=null)st.add(root.left);
            if(root.right!=null)st.add(root.right);
        }
        Collections.reverse(ans);
        return ans;
    }
}