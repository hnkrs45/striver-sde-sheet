public class Solution {
    ListNode cycleelement(ListNode head){
        if(head==null || head.next==null)
            return null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
            fast=fast.next;
            if(fast==slow){
                return slow;
            }
        }
        return null; 
    }

    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        ListNode fast=cycleelement(head);
        if(fast==null){
            return null;
        }
        ListNode slow=head;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}