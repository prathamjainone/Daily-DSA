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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
    List<List<Integer>> ans = new ArrayList<>();
    if (root != null) q.offer(root);
    while (!q.isEmpty()) {
        int size=q.size();
      List<Integer> temp = new ArrayList<>();
      while (size>0) {
        root = q.poll();
        temp.add(root.val);
        if (root.left != null) {
            q.offer(root.left);
        }
        if (root.right != null){
             q.offer(root.right);
        }
        size--;
      }
      ans.add(temp);
    }
    return ans;
    }
}