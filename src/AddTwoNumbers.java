/**
 * Created by prajesh on 4/9/16.
 */
public class AddTwoNumbers {

    static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            val=x;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry=0;

        while(l1!=null && l2!=null){
            l1.val = l1.val + l2.val+carry;

            if(l1.val > 9){
                l1.val = l1.val % 10;
                carry = l1.val/10;
            }


            l1=l1.next;
            l2=l2.next;
        }

        ListNode head =  (l1==null)?l2:l1;

        ListNode p1 = head, p2=head, p3=null;

        while(p1.next!=null){
            p2 = p1.next;
            p3 = p2.next;

        }

        return null;
    }






}
