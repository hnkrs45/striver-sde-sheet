class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        int ntd=size-n;
        temp=head;
        if(ntd==0) return head.next;
        while(ntd-->1){
            temp=temp.next;
        }
        if(temp.next!=null){
            temp.next=temp.next.next;
        }
        else{
            temp.next=null;
        }
        return head;
    }
}