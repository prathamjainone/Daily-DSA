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
class BSTIterator {
    ArrayList<Integer>inorder;
    int i;
    public BSTIterator(TreeNode root) {
        inorder=new ArrayList<>();
        i=0;
        dfs(inorder,root);
        Collections.sort(inorder);
    }
    public void dfs(ArrayList<Integer>inorder,TreeNode root){
        if(root==null)return;
        inorder.add(root.val);
        dfs(inorder,root.left);
        dfs(inorder,root.right);
    }
    
    public int next() {
        return inorder.get(i++);
    }
    
    public boolean hasNext() {
        return i<inorder.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */