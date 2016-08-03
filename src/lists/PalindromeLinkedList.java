package lists;

/**
 * Created by prajesh on 6/10/16.
 */
public class PalindromeLinkedList {

  static class ListNode{
      int val;
      ListNode next;

      ListNode(int x){
          val=x;
      }
  }


    public static void main(String[] args){

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        //ListNode l3 = new ListNode(3);
       // ListNode l4 = new ListNode(2);

        l1.next=l2;
        //l2.next=l4;
        //l3.next=l4;

        PalindromeLinkedList obj = new PalindromeLinkedList();

        System.out.println(obj.isPalindrome(l1));

    }



    public boolean isPalindrome(ListNode head) {

        if(head==null || head.next==null)
            return true;

        ListNode slow=head, fast=head;

        while(fast.next!=null){
            fast = fast.next;

            if(fast.next!=null){
                fast=fast.next;
                slow=slow.next;
            }
        }



        ListNode mid = slow;

        ListNode endB=mid.next;



        ListNode headA=head,headB=mid.next;

        headB = reverseList(headB);

        mid.next=null;
        endB.next=null;



        while(headA!=null && headB!=null){
            if(headA.val!=headB.val)
                return false;

            headA=headA.next;
            headB=headB.next;
        }


        if((headA==null || headA==mid)&& (headB==null||headB==endB))
            return true;
        else
            return false;


    }

    ListNode reverseList(ListNode head){

        if(head==null)
            return null;

        if(head.next==null)
            return head;

        ListNode curr=head.next, prev=head,next=head.next;

        while(next!=null){
            curr = next;
            next=next.next;
            curr.next=prev;
            prev=curr;

        }

        return curr;
    }

}
