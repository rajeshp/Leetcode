package hackerearth.dp;

import java.util.Scanner;

/**
 * Created by prajesh on 7/6/16.
 */
public class OnceUponATimeinTimeLand {

    public static void main(String[] args) {

        //System.out.println(getMaxSum(new int[]{1,2,-3,-5,4,6,-3,2,-1,2}, 1));
        //System.out.println(getMaxSum(new int[]{187 ,-413 ,270 ,-235 ,711 ,896 ,285 ,-140 ,-695 ,19 ,-576 ,658 ,371 ,-678 ,-851 ,-18 ,119 ,800 ,60 }, 1));
       // System.out.println(getMaxSum(new int[]{-673, 141, -253 ,-547 ,662, -37, 723, -529, 316, 190, 288, 40, -264, 446, -890, 370, 5 }, 5));
       //System.out.println(getMaxSum(new int[]{-629, -84 ,756 ,966 ,-931 ,-944 ,-626 ,-537 ,118 ,929 ,833 ,-639 ,704 ,977 ,673 ,21 ,924 ,-270 }, 2));



        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();

        long[] results = new long[cases];

        for(int i=0;i<cases;i++){

            int n = scanner.nextInt();

            int k = scanner.nextInt();

            int[] arr = new int[n];

            for(int j=0;j<n;j++){
                arr[j] = scanner.nextInt();
            }

            results[i] = getMaxSum(arr,k);

        }


        for(int i=0;i<cases;i++)
            System.out.println(results[i]);

    }


    static long getMaxSum(int[] arr, int k){

        long[] res = new long[arr.length];

        res[0] = Math.max(arr[0],0);
        res[1] = Math.max(arr[0], arr[1]);

        long max=Math.max(res[0],0);

        for(int i=1;i<arr.length;i++){

            if((i-k-1) >=0 ) {

                res[i] = Math.max(res[i-1-k] + arr[i], res[i-1]);

            }else
                res[i] = Math.max(max,arr[i]);

            if(res[i] > max)
                max=res[i];
        }


        return max;
    }
}
