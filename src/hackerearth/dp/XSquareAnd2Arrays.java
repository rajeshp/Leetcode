package hackerearth.dp;

import java.util.Scanner;

/**
 * Created by prajesh on 7/7/16.
 */
public class XSquareAnd2Arrays {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int count = scanner.nextInt();


        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for(int i=0;i<n;i++){
            arr1[i] = scanner.nextInt();
        }

        for(int i=0;i<n;i++){
            arr2[i] = scanner.nextInt();
        }


        long[] t1 = new long[arr1.length+1];
        long[] t2 = new long[arr2.length+1];


        t1[0] = 0;
        t2[0] = 0;

        for(int i=1;i<t1.length;i++) {

            t1[i] = t2[i-1] + arr1[i-1];
            t2[i] = t1[i-1] + arr2[i-1];

        }


        long[] results = new long[count];

        for(int i=0;i<count;i++){
            results[i] = getQueryResult(t1,t2,scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        for(int i=0;i<count;i++){
            System.out.println(results[i]);
        }
    }





  static long getQueryResult(long[] t1, long[] t2, int r, int start, int end){

        long result = 0;

        if(r==1){

            if(end-start%2==0)
                result = t1[end];
            else
                result = t2[end];

            result-=t2[start-1];

        }else
            if(r==2){

                if(end-start%2==0)
                    result = t2[end];
                else
                    result = t1[end];

                result-=t1[start-1];

            }

        return result;
    }

}
