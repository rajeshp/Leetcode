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
        ListNode origL1 = l1, origL2=l2, prevL1=null;

        int carry=0;

        while(l1!=null && l2!=null){
            l1.val = l1.val + l2.val+carry;
            carry=l1.val/10;
            l1.val=l1.val%10;

            prevL1=l1;
            l1=l1.next;
            l2=l2.next;

        }


        if(l2==null){
            while(l1!=null){
                l1.val+=carry;
                carry=l1.val/10;
                l1.val=l1.val%10;

                prevL1 = l1;
                l1=l1.next;
            }

        }
        else
        if(l1==null){
            prevL1.next=l2;

            while(l2!=null){
                l2.val+=carry;
                carry=l2.val/10;
                l2.val=l2.val%10;

                prevL1 = l2;
                l2=l2.next;
            }

        }

        if(carry>0){
            ListNode newNode = new ListNode(carry);
            prevL1.next=newNode;
        }


        return origL1;
    }



}
