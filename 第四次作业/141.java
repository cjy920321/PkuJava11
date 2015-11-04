/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode one = head;
        ListNode two = head;
        while (two.next != null && two.next.next != null)
        {
            one = one.next;
            two = two.next.next;
            if (one == two)
                return true;
        }
        return false;
    }
}