/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
     	if(head==null)//空链表
		{
			return true;
		}
		if(head.next==null)//只有头节点的链表
		{
			return true;
		}
		ListNode p1=head;//标记指针
		ListNode p2=head;//标记指针
		ListNode medium=head;//中间指针
		int n=1;
		while(p2.next!=null)//链表长度
		{
			p2=p2.next;
			++n;
		}
		for(int i=0;i<(n+1)/2;i++)//找到中间点
		{
			medium=medium.next;
		}
		p1=medium;
		p2=medium.next;
		while(p2!=null)//链表后半部逆序排列
		{
			medium.next=p2.next;
			p2.next=p1;
			p1=p2;
			p2=medium.next;
			
		}
		p2=head;
		for(int i=0;i<n/2;i++)//比较
		{
			if(p1.val!=p2.val)
			{
				return false;
			}
			p1=p1.next;
			p2=p2.next;
	
		}
		return true;//返回
    }
}