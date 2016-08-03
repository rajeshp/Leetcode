package hackerearth.dp;

import java.util.Scanner;

/**
 * Created by prajesh on 7/8/16.
 */
public class SamuAndShopping {

    public static void main(String[] args) {

        /*int[][] a = new int[3][];

                a[0] = new int[]{1,50, 50};
                a[1] = new int[]{50,50, 50};
                a[2] = new int[]{1,50, 50};


        System.out.println(getMinShoppingCost(a,3));
        */


        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();

        long[] result = new long[cases];

        for(int i=0;i<cases;i++) {


            int n = scanner.nextInt();

            long[][] shops = new long[n][3];

            for (int j = 0; j <n;j++){
                shops[j][0] = scanner.nextInt();
                shops[j][1] = scanner.nextInt();
                shops[j][2] = scanner.nextInt();
            }

            result[i] = getMinShoppingCost(shops,n);

        }

        for(int k=0;k<cases;k++)
            System.out.println(result[k]);

    }

    static long getMinShoppingCost(long[][] a, int n){

        if(n==0)
            return 0;

        int   pindex=0, temp=0;
        long sum=0;

        if(a[0][0] < a[0][1] && a[0][0] < a[0][2])
        {
            sum=a[0][0];
            pindex=0;
        }else
            if(a[0][1] < a[0][0] && a[0][1] < a[0][2])
        {
            sum=a[0][1];
            pindex=1;
        }else
            if(a[0][2] < a[0][0] && a[0][2] < a[0][1])
                {
                    sum=a[0][2];
                    pindex=2;
                }


        int i=1;

        while(i<n){

            a[i][0] += Math.min(a[i-1][1],a[i-1][2]);
            a[i][1] += Math.min(a[i-1][0],a[i-1][2]);
            a[i][2] += Math.min(a[i-1][0],a[i-1][1]);

            i++;
        }

        return min(a[n-1][0],a[n-1][1],a[n-1][2]);
    }


    static long min(long a, long b, long c){
        if(a<b&&a<c)
            return a;

        if(b<c && b<a)
            return b;

        return c;
    }

}
