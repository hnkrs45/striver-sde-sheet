class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head=null;
        ListNode temp1=list1, temp2=list2, ans=null;
        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                if(head==null){
                    head=temp1;
                    ans=head;
                }
                else{
                    ans.next=temp1;
                    ans=ans.next;
                }
                temp1=temp1.next;
            }
            else{
                if(head==null){
                    head=temp2;
                    ans=head;
                }
                else{
                    ans.next=temp2;
                    ans=ans.next;
                }
                temp2=temp2.next;
            }
        }
        if(temp1!=null){
            if(head==null){
                head=temp1;
            }
            else{
                ans.next=temp1;
            }
        }
        else if(temp2!=null){
            if(head==null){
                head=temp2;
            }
            else{
                ans.next=temp2;
            }
        }
        return head;
    }
}