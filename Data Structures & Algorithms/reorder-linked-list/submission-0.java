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
    private ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    private ListNode midNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void reorderList(ListNode head) {
        ListNode mid = midNode(head);
        ListNode lh = head;
        ListNode rh = reverseList(mid.next);
        mid.next = null;
        ListNode nextLh, nextRh;
        while(lh != null && rh != null) {
            nextLh = lh.next;
            lh.next = rh;
            nextRh = rh.next;
            rh.next = nextLh;

            //update
            lh = nextLh;
            rh = nextRh;
        }
    }
}
