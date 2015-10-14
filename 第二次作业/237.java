/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        
        if(node.next!=null)
		{
			ListNode p=node.next;
			node.val=p.val;
			node.next=p.next;
		}	
        
        
        
        
    }
}