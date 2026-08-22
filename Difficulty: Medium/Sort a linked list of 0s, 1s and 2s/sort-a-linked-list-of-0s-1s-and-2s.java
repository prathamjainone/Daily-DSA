/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node segregate(Node head) {
        // code here
        Node zeroHead=new Node(-1);
        Node oneHead=new Node(-1);
        Node twoHead=new Node(-1);
        
        Node zero=zeroHead;
        Node one=oneHead;
        Node two=twoHead;
        
        Node temp=head;
        while(temp!=null){
            if(temp.data==0){
                zero.next=temp;
                zero=temp;
            }
            else if(temp.data==1){
                one.next=temp;
                one=temp;
            }
            else {
                two.next=temp;
                two=temp;
            }
            temp=temp.next;
        }
        zero.next=oneHead.next;
        if(one.data!=-1)one.next=twoHead.next;
        else zero.next=twoHead.next;
        two.next=null;
        return zeroHead.next;
    }
}