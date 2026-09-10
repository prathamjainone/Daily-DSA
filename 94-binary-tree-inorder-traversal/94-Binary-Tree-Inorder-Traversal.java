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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>inorder=new ArrayList<>();
        TreeNode node=root;
        while(node!=null){
            if(node.left==null){
                inorder.add(node.val);
                node=node.right;
            }
            else{
                TreeNode leftChild=node.left;
                while(leftChild.right!=null && leftChild.right!=node){
                    leftChild=leftChild.right;
                }
                if(leftChild.right==null){
                    leftChild.right=node;
                    node=node.left;
                }
                else if(leftChild.right==node){
                    leftChild.right=null;
                    inorder.add(node.val);
                    node=node.right;
                }
            }
        }
        return inorder;
    }
}