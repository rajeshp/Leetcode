/**
 * Created by prajesh on 6/28/16.
 */
public class BadNeighbours {

    public static void main(String[] args) {

        //System.out.println(maxDonations(new int[] {10,3,2,5,7,8}));
        System.out.println(maxDonations(new int[] {11,15}));

    }

    static int maxDonations(int[] donations){
        return maxDonationsHelper(donations, 0, 1);
    }

    static int maxDonationsHelper(int[] donations, int donation, int index){

        if(donations.length==1)
            return donations[0];

        if(donations.length==2)
            return max(donations[0], donations[1]);

        if(index>=donations.length)
            return donation;

        if(index==donations.length-1)
            return donation+donations[index];

        return max(maxDonationsHelper(donations, donation+donations[index],index+2), maxDonationsHelper(donations, donation,index++));
    }

    static int max(int a, int b){
        return (a>b)?a : b;
    }


}
