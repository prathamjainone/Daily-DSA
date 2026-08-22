/* Structure of Linked List Node
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        // code here
        Node oghead1=head1;
        Node oghead2=head2;
        while(head1!=head2){
            head1=head1.next;
            head2=head2.next;
            if(head1==null)head1=oghead2;
            if(head2==null)head2=oghead1;
        }
        return head1;
    }
}