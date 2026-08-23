/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null)return head;
        //ye return ke liye hai bas
        ListNode rethead=head;
        boolean c=false;
        //here we go for the question
        ListNode temp = head;
        while (temp != null) {
            ListNode temphead = temp;
            int i = 0;
            ListNode prevtemphead=new ListNode(-1);
            while (temp != null) {
                i++;
                if (i == k) {
                    ListNode front=temp.next;
                    temp.next = null;
                    ListNode rev=reverse(temphead);
                    prevtemphead.next=rev;
                    if(!c){
                        rethead=rev;
                        c=true;
                    }
                    prevtemphead=temphead;
                    // prevtemphead.next=rev;
                    temphead.next=front;
                    temphead=front;
                    temp=temphead;
                    i=1;
                }
                if(temp!=null)temp = temp.next;
            }
        }
        return rethead;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode front = head.next;
            head.next = prev;
            prev = head;
            head = front;
        }
        return prev;
    }
}