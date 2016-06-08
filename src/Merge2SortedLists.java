/**
 * Created by prajesh on 5/9/16.
 */
public class Merge2SortedLists {

    static class ListNode{

        int val;
        ListNode next;

        ListNode(int n)
        {
            val = n;
        }

    }

     class List{
        ListNode head;

        public List(int n){
            head = new ListNode(n);
        }

    }


    public static ListNode merge2SortedLists(ListNode l1, ListNode l2){

        ListNode origL1=l1, origL2=l2, prevL1=null, prevL2=null;


        while(true){

            while(l1!=null && l1.val <= l2.val){
                prevL1 = l1;
                l1 = l1.next;
            }

            if(prevL1!=null){
                prevL1.next=l2;
            }

            if(l1==null)
                break;

            while(l2!=null && l2.val < l1.val){
                prevL2 = l2;
                l2=l2.next;
            }

            if(prevL2!=null){
                prevL2.next=l1;
            }

            if(l1==null || l2==null)
                break;

        }



        return origL1;
    }




    public static void main(String[] args) {


        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(7);
        ListNode l14 = new ListNode(13);


        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(4);
        ListNode l23 = new ListNode(9);




        System.out.println(merge2SortedLists(l1, l2));


    }


}
