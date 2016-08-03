package lists;

/**
 * Created by prajesh on 6/10/16.
 */
public class ReorderList {

    static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            val=x;
        }
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;


        ReorderList obj = new ReorderList();

        obj.reorderList(l1);

    }


    public void reorderList(ListNode head) {

        ListNode p = head,q=null;

        ListNode mid = findMid(head);

        ListNode endA=mid;

        ListNode headA=head,headB=mid.next;

        mid.next=null;

        headB = reverseList(headB);



        ListNode nextA=null, nextB=null;

        while(headA!=null && headB!=null){

            nextA=headA.next;
            nextB=headB.next;

            headA.next=headB;
            headB.next=nextA;

            headA=nextA;
            headB=nextB;
        }



    }

    ListNode findMid(ListNode head){
        if(head==null || head.next==null)
            return head;

        ListNode slow=head, fast=head;

        while(fast.next!=null){
            fast = fast.next;

            if(fast.next!=null){
                fast=fast.next;
                slow=slow.next;
            }
        }

        return slow;
    }


    ListNode reverseList(ListNode head){

        if(head==null)
            return null;

        if(head.next==null)
            return head;

        ListNode curr=head.next, prev=null,next=head.next;

        while(curr.next!=null){
            curr.next=prev;

            prev=curr;
            curr = next;

            next=next.next;
        }

        return prev;
    }

}
