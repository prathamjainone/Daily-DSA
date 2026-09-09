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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildtree(preorder,inorder,0,0,preorder.length-1,inorder.length-1,map);
    }
    public TreeNode buildtree(int[]preorder,int[]inorder,int instart,int prestart,int inend,int preend,HashMap<Integer,Integer>map){
        if(instart>inend || prestart>preend)return null;
        TreeNode root=new TreeNode(preorder[prestart]);
        root.left=buildtree(preorder,inorder,instart,prestart+1,map.get(root.val),map.get(root.val)-instart+prestart,map);
        root.right=buildtree(preorder,inorder,map.get(root.val)+1,map.get(root.val)-instart+prestart+1,inend,preend,map);
        return root;
    }
}