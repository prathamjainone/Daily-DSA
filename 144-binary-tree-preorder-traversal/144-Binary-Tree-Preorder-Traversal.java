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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>po=new ArrayList<>();
        TreeNode node=root;
        while(node!=null){
            po.add(node.val);
            if(node.left==null){
                node=node.right;
            }
            else{
                TreeNode rightChild=node.right;
                TreeNode leftChild=node.left;
                while(leftChild.right!=null && leftChild.right!=rightChild){
                    leftChild=leftChild.right;
                }
                if(leftChild.right==null){
                    leftChild.right=rightChild;
                    node=node.left;
                }
                else if(leftChild.right==rightChild){
                    po.add(rightChild.val);
                    node=node.right;
                }
            }
        }
        return po;
    }
}