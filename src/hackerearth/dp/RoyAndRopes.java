package hackerearth.dp;

import java.util.Scanner;

/**
 * Created by prajesh on 7/7/16.
 */
public class RoyAndRopes {

    public static void main(String[] args) {

        //System.out.println(getTimeToBurn(new int[]{1,2,2,2}));
        //System.out.println(getTimeToBurn(new int[]{1,5,3,4,2}));
       // System.out.println(getTimeToBurn(new int[]{1,1,1,1,0}));

        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();

        int[] result = new int[cases];

        for(int i=0;i<cases;i++){

            int n = scanner.nextInt();

            int[] upper = new int[n-1];
            int[] lower = new int[n-1];

            for(int j=0;j<n-1;j++)
                upper[j] = scanner.nextInt();

            for(int k=0;k<n-1;k++)
                lower[k] = scanner.nextInt();

            int[] t = getMaxRopeArray(upper, lower);


            result[i]=getTimeToBurn(t);
        }

        for(int i=0;i<cases;i++)
            System.out.println(result[i]);

    }


    static int[] getMaxRopeArray(int[] a, int[] b){
        int[] res = new int[a.length];

        for(int i=0;i<res.length;i++){
            res[i] = Math.max(a[i],b[i]);
        }

        return res;
    }


  /*static  int getTimeToBurn(int[] arr){

        int time=1, max=arr[0];

        int i=0,j=0;


        while(true){

            i=0;

            if(j==arr.length)
                break;

            while(i<j){

                if(arr[i]>0)
                    arr[i]--;

                i++;
            }


            j++;

            time++;
        }

      return time++;
    }*/

    static  int getTimeToBurn(int[] arr){
        int time=1;

        int max=0,i=0;

        for(i=0;i<arr.length;i++){

            if((i+1+arr[i])>max)
                max=i+1+arr[i];


        }

        if((i+1)>max)
            max++;

        return max;
    }
}
