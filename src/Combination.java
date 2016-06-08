/**
 * Created by prajesh on 5/10/16.
 */
public class Combination {
    public static void main(String[] args) {

       System.out.println(ncr(18,9));

    }


    static int ncr(int n, int r){

        if(r==0 || r==n)
            return 1;

        if(n==0 || n==1)
            return 1;

        int denomBigger = ((n-r) > r) ? (n-r) : r;

        int denomSmaller = ((n-r) > r) ? r : (n-r);

        long numerator=1, denom=1;

        for(int i=n;i>denomBigger;i--){
            numerator*=i;
        }

        for(int i=1;i<=denomSmaller;i++){
            denom*=i;
        }

        return (int) numerator/(int)denom;
    }
}
