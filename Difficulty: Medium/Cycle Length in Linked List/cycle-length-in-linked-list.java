/* Structure of Linked List Node
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}*/

class Solution {
    public int lengthOfLoop(Node head) {
        // code here
        if(head==null || head.next==null)return 0;
        Node fast=head;
        Node slow=head;
        int length=0;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)break;
        }
        if(fast==null || fast.next==null)return 0;
        fast=head;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        Set<Node>set=new HashSet<>();
        while(true){
            if(!set.isEmpty() && set.contains(slow))break;
            set.add(slow);
            slow=slow.next;
            length++;
        }
        return length;
    }
}