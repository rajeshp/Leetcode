/**
 * Created by prajesh on 7/3/16.
 */
public class BadNeighbour {

    public static void main(String[] args) {

        //System.out.println(maxDonations(new int[]{1,2,3,4,5,1,2,3,4,5}));
        //System.out.println(maxDonations(new int[]{ 10, 3, 2, 5, 7, 8 }));
        System.out.println(maxDonations(new int[]{10, 3, 16, 18, 21}));
    }

   public static int maxDonations(int[] donations){

       if(donations.length==1)
           return donations[0];

       if(donations.length==2){
           return Math.max(donations[0], donations[1]);
       }

       int[] temp = new int[donations.length];
       int[] r = new int[donations.length];

       temp[0] = donations[0];
       temp[1] = donations[1];
       //temp[2] = donations[2];

       r[0]=0;
       r[1]=1;

       int prevMax = donations[0], prevMaxIndex=0;
       int k=0;

       for(int i=2;i<temp.length-1;i++){

           temp[i] = prevMax+donations[i];
           r[i] = prevMaxIndex;

           if(temp[++k] > prevMax) {
               prevMax = temp[k];
               prevMaxIndex=k;
           }

       }

       //return Math.max(temp[donations.length-2]+donations[0], temp[donations.length-3]+donations[donations.length-1]);


       int len = temp.length-1;

       if(r[prevMaxIndex]==0)
           temp[len] = prevMax + donations[len]-donations[0];
       else
           temp[len] = prevMax+donations[len];


       return Math.max(temp[len], temp[len-1]);
   }

}
