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
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)return -1;
        return morris(root,k,0);
    }
    public int morris(TreeNode root, int k,int i){

        TreeNode node=root;
        while(node!=null){
            if(node.left==null){
                i++;
                if(i==k)return node.val;
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
                else{
                    leftChild.right=null;
                    i++;
                    if(i==k)return node.val;
                    node=node.right;
                }
            }
        }
        return -1;
    }
}