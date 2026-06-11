class Solution {
    ListNode solve(ListNode from, ListNode to){
        ListNode prev=null;
        ListNode curr=from;
        while(curr!=null && curr!=to){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prevgrouptail=dummy;
        ListNode temp=head;
        while(temp!=null){
            ListNode iter=temp;
            int count=1;
            while(iter!=null && count<k){
                iter=iter.next;
                count++;
            }
            if(iter==null){
                prevgrouptail.next=temp;
                break;
            }
            ListNode nextgrouphead=iter.next;
            ListNode newgrouphead=solve(temp, nextgrouphead);
            prevgrouptail.next=newgrouphead;
            temp.next=nextgrouphead;
            prevgrouptail=temp;
            temp=nextgrouphead;
        }
        return dummy.next;
    }
}