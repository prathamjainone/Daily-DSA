/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lc=root;
        while(true){
            if(p.val<lc.val && q.val<lc.val){
                lc=lc.left;
            }
            else if(p.val>lc.val && q.val>lc.val){
                lc=lc.right;
            }
            else return lc;
        }
        // return lc;
    }
}