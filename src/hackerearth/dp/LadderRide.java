package hackerearth.dp;

import java.util.Scanner;

/**
 * Created by prajesh on 7/9/16.
 */
public class LadderRide {

    public static void main(String[] args) {


        /*System.out.println(getMinSteps(10,7,7));
        System.out.println(getMinSteps(10,6,7));
        System.out.println(getMinSteps(10,6,6));
        System.out.println(getMinSteps(10,9,7));*/


        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();

        long[] result = new long[cases];

        int n = scanner.nextInt();

        long[] temp = getMinStep2And5(n);

        int curr=0, k=0;

        for(int i=0;i<cases;i++){
          //  result[i] = getMinSteps(n, scanner.nextInt(), scanner.nextInt());

            curr = scanner.nextInt();
            k = scanner.nextInt();


            result[i] = (temp[curr] + getKStepWays(temp, k, curr))%1000000007;
        }

        for(int i=0;i<cases;i++){
            System.out.println(result[i]);
        }


    }


   static long[] getMinStep2And5(int n){


       long[] a = new long[n+1];

       a[2]=1;

       if(n>=5)
           a[5]=1;

       if(n>=5){



           long f2=0, f5=0;

           for(int i=3;i<=n;i++){

               f2=0; f5=0;

               if(i-2>=0)
                   f2 = a[i-2];

               if(i-5>=0)
                   f5=a[i-5];

               //if(a[i] == 0)
               a[i] = (a[i]+f2+f5) % 1000000007;

               if(a[i] == Integer.MAX_VALUE)
                   a[i]=0;

           }


       }

       return a ;

   }



  static long getKStepWays(long[] a, int k, int curr){

       if(curr<=0)
           return 0;

       if(curr-k>=0)
           return a[curr-k]+1 + getKStepWays(a,k,curr-k);
       else
           return 0;
   }



   static long getMinSteps(int n, int cur, int k){

        long[] a = new long[n+1];



        a[2]=1;

        if(n>=5)
            a[5]=1;

        if(n>=5){

            a[k]=1;

            long f2=0, f5=0, fk=0;

            for(int i=3;i<=cur;i++){

                f2=0; f5=0; fk=0;

                if(i-2>=0)
                    f2 = a[i-2];

                if(i-5>=0)
                    f5=a[i-5];

                if(i-k>=0)
                    fk=a[i-k];


                //if(a[i] == 0)
                a[i] = (a[i]+f2+f5+fk) % 1000000007;

                if(a[i] == Integer.MAX_VALUE)
                    a[i]=0;

            }


        }

            return a[cur] ;
    }



    static long min(long a, long b, long c){
        if(a<b&&a<c)
            return a;

        if(b<c && b<a)
            return b;

        return c;
    }

}
