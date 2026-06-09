class Solution {
    ListNode solve(ListNode node, ListNode prev){
        if(node.next==null){
            node.next=prev;
            ListNode newhead=node;
            return newhead;
        }
        ListNode newhead=solve(node.next, node);
        node.next=prev;
        return newhead;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        return solve(head, null);
    }
}