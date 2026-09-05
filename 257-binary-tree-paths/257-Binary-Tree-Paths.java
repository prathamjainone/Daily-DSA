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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>ans=new ArrayList<>();
        String s=String.valueOf(root.val);
        if(root.left==null && root.right==null){
            ans.add(s);
            return ans;
        }
        left(root.left,ans,s);
        left(root.right,ans,s);
        return ans;
    }
    public void left(TreeNode root,List<String>ans,String s){
        if(root==null)return;
        if(root.left==null && root.right==null){
            s=s+"->"+String.valueOf(root.val);
            ans.add(s);
            return;
        }
        left(root.left,ans,s+"->"+String.valueOf(root.val));
        left(root.right,ans,s+"->"+String.valueOf(root.val));
    }
}