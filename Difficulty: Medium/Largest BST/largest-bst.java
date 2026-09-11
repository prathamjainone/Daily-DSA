/* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left, right;
    public Node(int d) {
     data = d;
     left = right = null;
   }
} */

class Solution {
    
    class BST{
        int min;
        int max;
        int size;
        BST(int min,int max,int size){
            this.min=min;
            this.max=max;
            this.size=size;
        }
    }
    
    public int largestBst(Node root) {
        // code here
        return largest(root).size;
    }
    
    public BST largest(Node root){
        if(root==null)return new BST(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        BST left=largest(root.left);
        BST right=largest(root.right);
        if(left.max<root.data && right.min>root.data){
            return new BST(Math.min(root.data,left.min),Math.max(right.max,root.data),left.size+right.size+1);
        }
        else{
            return new BST(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.size,right.size));
        }
    }
}