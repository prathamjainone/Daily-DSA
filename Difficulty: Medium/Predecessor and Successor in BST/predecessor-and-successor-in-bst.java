/* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
} */

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        Node pre=null;
        Node suc=null;
        Node curr=root;
        
        while(curr!=null){
            if(curr.data<key){
                pre=curr;
                curr=curr.right;
            }
            else if(curr.data>key){
                suc=curr;
                curr=curr.left;
            }
            else{
                if(curr.left!=null){
                    Node l=curr.left;
                    while(l.right!=null){
                        l=l.right;
                    }
                    pre=l;
                }
                if(curr.right!=null){
                    Node r=curr.right;
                    while(r.left!=null){
                        r=r.left;
                    }
                    suc=r;
                }
                break;
            }
        }
        ArrayList<Node> list = new ArrayList<>(Arrays.asList(pre, suc));
        return list;
    }
}