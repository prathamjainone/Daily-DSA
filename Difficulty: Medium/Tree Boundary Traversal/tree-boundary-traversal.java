/* Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer>ans=new ArrayList<>();
        ans.add(root.data);
        left(ans,root.left);
        leaf(ans,root.left);
        leaf(ans,root.right);
        revright(ans,root.right);
        return ans;
    }
    public void left(ArrayList<Integer>ans,Node root){
        if(root==null)return;
        if(root.left!=null || root.right!=null)ans.add(root.data);
        left(ans,root.left);
        if(root.left==null)left(ans,root.right);
    }
    public void leaf(ArrayList<Integer>ans,Node root){
        if(root==null)return;
        if(root.left==null && root.right==null)ans.add(root.data);
        leaf(ans,root.left);
        leaf(ans,root.right);
    }
    public void revright(ArrayList<Integer>ans,Node root){
        if(root==null)return;
        revright(ans,root.right);
        if(root.right==null)revright(ans,root.left);
        if(root.right!=null || root.left!=null)ans.add(root.data);
    }
}