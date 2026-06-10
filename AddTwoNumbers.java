class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1, temp2=l2;
        int val=0;
        int carry=0;
        ListNode ans=null, temp=null;
        while(temp1!=null && temp2!=null){
            val=temp1.val+temp2.val+carry;
            if(ans!=null){
                ListNode node=new ListNode(val%10);
                temp.next=node;
                temp=temp.next;
            }
            else{
                ans=new ListNode(val%10);
                temp=ans;
            }
            carry=val/10;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        while(temp1!=null){
            val=temp1.val+carry;
            if(ans!=null){
                ListNode node=new ListNode(val%10);
                temp.next=node;
                temp=temp.next;
            }
            else{
                ans=new ListNode(val%10);
                temp=ans;
            }
            carry=val/10;
            temp1=temp1.next;
        }
        while(temp2!=null){
            val=temp2.val+carry;
            if(ans!=null){
                ListNode node=new ListNode(val%10);
                temp.next=node;
                temp=temp.next;
            }
            else{
                ans=new ListNode(val%10);
                temp=ans;
            }
            carry=val/10;
            temp2=temp2.next;
        }
        while(carry>0){
            ListNode node=new ListNode(carry%10);
            carry/=10;
            temp.next=node;
            temp=temp.next;
        }
        return ans;
    }
}