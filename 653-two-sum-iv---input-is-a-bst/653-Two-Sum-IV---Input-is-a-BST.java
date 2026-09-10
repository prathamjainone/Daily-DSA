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
    static class BSTIterator{
        Stack<TreeNode>st;
        boolean reverse;
        public BSTIterator(TreeNode root,boolean reverse){
            st=new Stack<>();
            this.reverse=reverse;
            pushAll(root);
        }
        public void pushAll(TreeNode root){
            while(root!=null){
                st.push(root);
                root=(reverse)?root.right:root.left;
            }
        }
        public int next(){
            TreeNode node=st.pop();
            if (!reverse) pushAll(node.right);
            else pushAll(node.left);
            return node.val;
        }
    }

    public boolean findTarget(TreeNode root, int k) {

        BSTIterator l=new BSTIterator(root,false);
        BSTIterator r=new BSTIterator(root,true);

        int i=l.next();
        int j=r.next();

        while(i<j){
            if(i+j==k)return true;
            else if(i+j<k)i=l.next();
            else j=r.next();
        }
        return false;
    }
}