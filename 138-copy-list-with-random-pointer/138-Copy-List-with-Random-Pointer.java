/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node>map=new HashMap<>();
        Node dummy=new Node(-1);
        Node neww=dummy;
        Node temp=head;
        while(temp!=null){
            dummy.next=new Node(temp.val);
            dummy=dummy.next;
            map.put(temp,dummy);
            temp=temp.next;
        }
        temp=head;
        dummy=neww.next;
        while(temp!=null){
            if(temp.random!=null){
                dummy.random=map.get(temp.random);
            }
            dummy=dummy.next;
            temp=temp.next;
        }
        return neww.next;
    }
}