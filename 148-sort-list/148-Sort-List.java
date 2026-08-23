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
    public ListNode sortList(ListNode head) {
        return mergesort(head);
    }

    public ListNode mergesort(ListNode head){
        if(head==null || head.next==null)return head;

        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode right=slow.next;
        slow.next=null;
        ListNode left=head;

        left=mergesort(left);
        right=mergesort(right);

        ListNode ans=merge(left,right);
        return ans;
    }

    public ListNode merge(ListNode head,ListNode nexthead){
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;

        while(head!=null && nexthead!=null){
            if(head.val<nexthead.val){
                temp.next=head;
                head=head.next;
            }
            else {
                temp.next=nexthead;
                nexthead=nexthead.next;
            }
            temp=temp.next;
        }
        
        if(head!=null){
            temp.next=head;
        }
        else{
            temp.next=nexthead;
        }

        return dummy.next;
    }
}