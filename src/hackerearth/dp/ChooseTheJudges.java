package hackerearth.dp;

import java.util.Scanner;

/**
 * Created by prajesh on 7/6/16.
 */
public class ChooseTheJudges {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();

        int[] results = new int[cases];

        for(int i=0;i<cases;i++){

            int n = scanner.nextInt();

            int[] arr = new int[n];

            for(int j=0;j<n;j++){
                arr[j] = scanner.nextInt();
            }

            results[i] = getMaxPoints(arr);

        }


        for(int i=0;i<cases;i++)
            System.out.println(results[i]);
    }

    static int getMaxPoints(int[] arr){
        if(arr==null || arr.length==0)
            return 0;

        if(arr.length==1)
            return arr[0];

        if(arr.length==2)
            return Math.max(arr[0],arr[1]);


        int[] res = new int[arr.length];

        res[0] = arr[0];
        res[1] = Math.max(arr[0],arr[1]);

        for(int i=2;i<res.length;i++) {

            res[i] = Math.max(res[i-2]+arr[i], res[i-1]);

        }


        return res[res.length-1];
    }

}
