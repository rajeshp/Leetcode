package dp;

/**
 * Created by prajesh on 5/20/16.
 */
public class MaxSubArray {

    public static void main(String[] args) {

       // System.out.println(bruteforce(new int[]{-2, 1, -3, 4, -1, 2,1,-5, 4}));
        System.out.println(recursive(new int[]{-2, 1, -3, 4, -1, 2,1,-5, 4}, 0, 0, 0));


    }


    static int bruteforce(int[] arr){
        if(arr==null || arr.length==0)
            return 0;

        int sum=0, maxSum=0;

        for(int i=0;i<arr.length;i++){

            sum=0;

            for(int j=i;j<arr.length;j++){

                sum+=arr[j];

                if(sum > maxSum)
                    maxSum=sum;
            }


        }


        return maxSum;
    }


    //recursive function


    static int recursive(int[] arr, int i, int j, int sum){

       if(i<arr.length && j<arr.length) {


           int tsum = sum + arr[j];

           return max(tsum, sum + recursive(arr, i,j+1, tsum), recursive(arr, i+1, j+1,tsum) );


       }

        return sum;
    }


    static int max(int a, int b, int c){

        return ((a > b) && (a > c)) ? a :((b>a && b>c) ? b : c);

    }

}
