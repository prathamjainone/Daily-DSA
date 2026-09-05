/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    
    static class Tuple{
        Node root;
        int row;
        int col;
        
        public Tuple(Node root,int row,int col){
            this.root=root;
            this.row=row;
            this.col=col;
        }
    }
    public ArrayList<Integer> topView(Node root) {
        // code here
        TreeMap<Integer,TreeMap<Integer,Queue<Integer>>>map=new TreeMap<>();
        Queue<Tuple>q=new ArrayDeque<>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple tuple=q.poll();
            Node node=tuple.root;
            int row=tuple.row;
            int col=tuple.col;
            
            map.putIfAbsent(col,new TreeMap<>());
            map.get(col).putIfAbsent(row,new ArrayDeque<>());
            map.get(col).get(row).offer(node.data);
            
            if(node.left!=null){
                q.offer(new Tuple(node.left,row+1,col-1));
            }
            if(node.right!=null){
                q.offer(new Tuple(node.right,row+1,col+1));
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        for(TreeMap<Integer,Queue<Integer>>row:map.values()){
            for(Queue<Integer>qr:row.values()){
                ans.add(qr.poll());
                break;
            }
        }
        return ans;
    }
}