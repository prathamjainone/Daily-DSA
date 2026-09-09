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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(inorder,postorder,postorder.length-1,0,inorder.length-1,0,map);
    }
    public TreeNode build(int[]inorder,int[]postorder,int poststart,int instart,int inend,int postend,HashMap<Integer,Integer>map){
        if(instart>inend || poststart<postend)return null;

        TreeNode root=new TreeNode(postorder[poststart]);
        root.right=build(inorder,postorder,poststart-1,map.get(postorder[poststart])+1,inend,postend,map);
        root.left=build(inorder,postorder,poststart-(inend-map.get(postorder[poststart]))-1,instart,map.get(postorder[poststart])-1,postend,map);
        return root;
    }
}