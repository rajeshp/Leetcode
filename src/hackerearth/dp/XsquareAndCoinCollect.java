package hackerearth.dp;

import java.util.Scanner;

/**
 * Created by prajesh on 7/8/16.
 */
public class XsquareAndCoinCollect {

    public static void main(String[] args) {

        System.out.println(getMinConsecutiveCoins(new int[]{3,2,2,3,1,1,1,3},1));
        System.out.println(getMinConsecutiveCoins(new int[]{3,2,2,3,1,1,1,3},2));


        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        long[] result = new long[cases];

        for(int i=0;i<cases;i++){
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[] a = new int[n];

            for(int j=0;j<n;j++)
                a[j]=scanner.nextInt();

            result[i] = getMinConsecutiveCoins(a,k);
        }

        for(int i=0;i<cases;i++)
            System.out.println(result[i]);

    }

   static long getMinConsecutiveCoins(int[] arr, long k){

        long maxsum=0, sum=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]<=k)
                sum+=arr[i];
            else
                sum=0;

            if(sum > maxsum){
                maxsum = sum;
            }
        }

        return maxsum;
    }

}
