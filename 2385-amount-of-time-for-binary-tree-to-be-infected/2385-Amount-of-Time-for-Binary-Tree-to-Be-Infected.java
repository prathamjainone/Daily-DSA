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
    int result=0;
    public int amountOfTime(TreeNode root, int start) {
        dfs(root,start);
        return result;
    }

    public int dfs(TreeNode root, int start){
        if(root==null)return 0;
        int lh=dfs(root.left,start);
        int rh=dfs(root.right,start);
        if(root.val==start){
            result=Math.max(result,Math.max(lh,rh));
            return -1;
        }
        else if(lh<0 || rh<0){
            int d = Math.abs(lh) + Math.abs(rh);
            result = Math.max(result, d);

            return Math.min(rh, lh) - 1;
        }
        return 1+Math.max(lh,rh);
    }
}