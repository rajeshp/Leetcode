/**
 * Created by prajesh on 4/29/16.
 */
public class UglyNumbers {


    public static void main(String[] args) {


      /*  long start = System.currentTimeMillis();
       // System.out.println(getNthUglyNumber(1500));

        long end = System.currentTimeMillis();

        System.out.println("execution time : " +(end-start)+ " ms");


        System.out.println(" DP Solution : ");


         start = System.currentTimeMillis();
        System.out.println(getNthUglyNumberDP(10));

         end = System.currentTimeMillis();

        System.out.println("execution time : " +(end-start)+ " ms");*/


        System.out.println(isUgly(6));
        System.out.println(isUgly(8));
        System.out.println(isUgly(14));

    }




    //dynamic programming version

    static int getNthUglyNumberDP(int n){

        int[] ugly = new int[n];

        ugly[0] = 1;

        int i2=0,i3=0,i5=0;


        int nextMultiple2 = ugly[0] * 2;
        int nextMultiple3 = ugly[0] * 3;
        int nextMultiple5 = ugly[0] * 5;

        int next_ugly_no=0;

        for(int i=1; i< n;i++ ){

            /* These small steps are not optimized for good
      readability. Will optimize them in C program */
            next_ugly_no  = min(nextMultiple2,
                    nextMultiple3,
                    nextMultiple5);

            ugly[i] =  next_ugly_no;

            if  (next_ugly_no  == nextMultiple2)
            {
                i2 = i2 + 1;
                nextMultiple2 = ugly[i2]*2;
            }
            if  (next_ugly_no  == nextMultiple3)
            {
                i3 = i3 + 1;
                nextMultiple3 = ugly[i3]*3;
            }
            if  (next_ugly_no  == nextMultiple5)
            {
                i5 = i5 + 1;
                nextMultiple5 = ugly[i5]*5;
            }

        }


        return ugly[n-1];
    }


    static int min(int a, int b, int c){

        if(a < b && a < c) return a;

        if(b < a && b < c) return b;

        return c;
    }


//brute force version
    static int getNthUglyNumber(int n){

        int count=1; //ith Ugly Number

        int k=1;


        while(count<n){

            k++;

            if(isUgly(k)){
                count++;
            }


        }

        return k;

    }

    static boolean isUgly(int n){

        n = maxDivide(n, 2);
        n = maxDivide(n, 3);
        n = maxDivide(n, 5);

        return (n == 1)? true : false;

    }

    /*This function divides a by greatest divisible
  power of b*/
   static int maxDivide(int a, int b)
    {
        while (a%b == 0)
            a = a/b;
        return a;
    }

}



