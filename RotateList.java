class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        ListNode prev=head,curr=head;
        int size=1;
        while(curr.next!=null){
            size++;
            curr=curr.next;
        }
        k%=size;
        if(k==0) return head;
        curr.next=head;
        curr=head;
        k=(size-k);
        while(k-->0){
            prev=curr;
            curr=curr.next;
        }
        head=curr;
        prev.next=null;
        return head;
    }
}