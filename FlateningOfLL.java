import java.util.*;

// Definition of special linked list
class ListNode {
    int val;
    ListNode next;
    ListNode child;

    ListNode(int data1) {
        val = data1;
        next = null;
        child = null;
    }

}

// Logic class
class Solution {
    
    // Flatten a multi-level linked list
    public ListNode flattenLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // ListNode mergedHead = flattenLinkedList(head.next);
        // return merge(head, mergedHead);
        List<Integer> li=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            ListNode chull=temp.child;
            while(chull!=null){
                li.add(chull.val);
                chull=chull.child;
            }
            li.add(temp.val);
            temp=temp.next;
        }
        Collections.sort(li);
        ListNode ans=null;
        temp=ans;
        for(int i=0;i<li.size();i++){
            if(ans==null){
                ans=new ListNode(li.get(i));
                temp=ans;
            }
            else{
                temp.next=new ListNode(li.get(i));
                temp=temp.next;
            }
        }
        return ans;
    }
}

// Main class for running the program
public class FlateningOfLL {
    // Print linked list in flattened form
    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Print original linked list in grid format
    public static void printOriginalLinkedList(ListNode head, int depth) {
        while (head != null) {
            System.out.print(head.val);

            if (head.child != null) {
                System.out.print(" -> ");
                printOriginalLinkedList(head.child, depth + 1);
            }

            if (head.next != null) {
                System.out.println();
                for (int i = 0; i < depth; ++i) {
                    System.out.print("| ");
                }
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        // Create a linked list with child pointers
        ListNode head = new ListNode(5);
        head.child = new ListNode(14);

        head.next = new ListNode(10);
        head.next.child = new ListNode(4);

        head.next.next = new ListNode(12);
        head.next.next.child = new ListNode(20);
        head.next.next.child.child = new ListNode(13);

        head.next.next.next = new ListNode(7);
        head.next.next.next.child = new ListNode(17);

        // Print original structure
        System.out.println("Original linked list:");
        printOriginalLinkedList(head, 0);

        // Flatten list
        LinkedListCycleii sol = new LinkedListCycleii();
        ListNode flattened = sol.flattenLinkedList(head);

        // Print flattened version
        System.out.print("\nFlattened linked list: ");
        printLinkedList(flattened);
    }
}
