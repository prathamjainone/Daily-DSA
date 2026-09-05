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
    static class Pair<K,V>{
        private K key;
        private V value;

        public Pair(K key,V value){
            this.key=key;
            this.value=value;
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        int ans=0;
        Queue<Pair<TreeNode,Integer>>q=new ArrayDeque<>();
        q.offer(new Pair<TreeNode,Integer>(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int start=0;
            int end=0;
            for(int i=0;i<size;i++){
                Pair<TreeNode,Integer>p=q.poll();
                TreeNode node=p.getKey();
                int val=p.getValue();
                if(i==0)start=val;
                if(i==size-1)end=val;
                if(node.left!=null){
                    q.offer(new Pair<TreeNode,Integer>(node.left,2*val+1));
                }
                if(node.right!=null){
                    q.offer(new Pair<TreeNode,Integer>(node.right,2*val+2));
                }
            }
            ans=Math.max(ans,end-start+1);
        }
        return ans;
    }
}