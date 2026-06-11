public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curra=headA, currb=headB;
        while(curra!=currb){
            curra=(curra!=null)? curra.next: headB;
            currb=(currb!=null)? currb.next: headA;
        }
        return curra;
    }
}