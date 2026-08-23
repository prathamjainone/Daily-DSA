class Solution {
    public Node flatten(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 1. Find middle column using fast & slow pointers horizontally
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Split the horizontal list into two halves
        Node midNext = slow.next;
        slow.next = null; // Sever horizontal link

        // 3. Divide & Conquer
        Node left = flatten(head);
        Node right = flatten(midNext);

        // 4. Merge the two sorted vertical lists
        return mergeTwoLists(left, right);
    }

    private Node mergeTwoLists(Node a, Node b) {
        Node dummy = new Node(-1);
        Node res = dummy;

        while (a != null && b != null) {
            if (a.data <= b.data) {
                res.bottom = a;
                a = a.bottom;
            } else {
                res.bottom = b;
                b = b.bottom;
            }
            res = res.bottom;
            res.next = null; // Clear horizontal reference
        }

        if (a != null) res.bottom = a;
        else res.bottom = b;

        return dummy.bottom;
    }
}