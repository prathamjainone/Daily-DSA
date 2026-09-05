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

    public class Tuple{
        TreeNode node;
        int row;
        int col;

        public Tuple(TreeNode node,int row,int col){
            this.node=node;
            this.row=row;
            this.col=col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        Queue<Tuple>q=new LinkedList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>map=new TreeMap<>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple tuple=q.poll();
            TreeNode node=tuple.node;
            int row=tuple.row;
            int col=tuple.col;

            if(!map.containsKey(col)){
                map.put(col,new TreeMap<>());
            }
            if(!map.get(col).containsKey(row)){
                map.get(col).put(row,new PriorityQueue<>());
            }
            map.get(col).get(row).offer(node.val);
            if(node.left!=null){
                q.offer(new Tuple(node.left,row+1,col-1));
            }
            if(node.right!=null){
                q.offer(new Tuple(node.right,row+1,col+1));
            }
        }
        for(TreeMap<Integer,PriorityQueue<Integer>>rows:map.values()){
            List<Integer>temp=new ArrayList<>();
            for(PriorityQueue<Integer>node:rows.values()){
                while(!node.isEmpty()){
                    temp.add(node.poll());
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}