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

// class Solution {
//     public Node copyRandomList(Node head) {
//         HashMap<Node,Node>map=new HashMap<>();
//         Node dummy=new Node(-1);
//         Node neww=dummy;
//         Node temp=head;
//         while(temp!=null){
//             dummy.next=new Node(temp.val);
//             dummy=dummy.next;
//             map.put(temp,dummy);
//             temp=temp.next;
//         }
//         temp=head;
//         dummy=neww.next;
//         while(temp!=null){
//             if(temp.random!=null){
//                 dummy.random=map.get(temp.random);
//             }
//             dummy=dummy.next;
//             temp=temp.next;
//         }
//         return neww.next;
//     }
// }

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        Node t = head;
        Node y = head;
        while (head != null) {
            Node front = head.next;
            Node clone = new Node(head.val);

            head.next = clone;
            clone.next = front;

            head = front;
        }
        while (t != null) {
            if (t.random != null) {
                t.next.random = t.random.next;
            }
            t = t.next.next;
        }
        t = y;
        while (t != null) {
            Node front = t.next.next; // Next original (B)
            Node clone = t.next; // Current clone (A')

            temp.next = clone; // Build new list
            temp = temp.next;

            t.next = front; // Restore original list (A -> B)
            t = front; // Advance
        }

        return dummy.next;
    }
}