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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        rightside(root,ans,0);
        return ans;
    }
    public void rightside(TreeNode root,List<Integer>ans,int level){
        if(root==null)return;

        if(level>ans.size()-1){
            ans.add(root.val);
        }
        rightside(root.right,ans,level+1);
        rightside(root.left,ans,level+1);
    }
}