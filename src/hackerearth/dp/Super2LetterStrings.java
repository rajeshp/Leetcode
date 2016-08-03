package hackerearth.dp;

import java.util.Scanner;

/**
 * Created by prajesh on 7/7/16.
 */
public class Super2LetterStrings {

    public static void main(String[] args) {

       // System.out.println(getTotalStrings(11,8));
        System.out.println(getTotalStrings(4,3));



        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();

        long[] result = new long[cases];

        for(int i=0;i<cases;i++) {



            result[i] = getTotalStrings(scanner.nextInt(), scanner.nextInt());

        }

        for(int i=0;i<cases;i++) {
            System.out.println(result[i]);
        }

    }


    static long getTotalStrings(int n, int k){

        long[] res = new long[n];

        res[0]=1;


        long temp=0;

        for(int i=1;i<n;i++){

            if(i>k-1)
                temp = ((res[i-1]-1)*2 + 1) ;
            else
                temp = (res[i-1]*2);


            res[i] = temp;

        }

        return res[n-1]% 1000000007;
    }

}
