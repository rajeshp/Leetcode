package hackerearth.dp;

import java.util.Scanner;

/**
 * Created by prajesh on 7/7/16.
 */
public class StudiosLittleJhool {

    public static void main(String[] args) {

        //System.out.println(getMinPagesRequired(10));
       // System.out.println(getMinPagesRequired(11));
       // System.out.println(getMinPagesRequired(12));
       ///System.out.println(getMinPagesRequired(30));
       // System.out.println(getMinPagesRequired(12));
       // System.out.println(getMinPagesRequired(72));



        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();

        int[] result = new int[cases];

        for(int i=0;i<cases;i++) {

            int n = scanner.nextInt();

            result[i] = getMinPagesRequired(n);

        }

        for(int i=0;i<cases;i++) {
            System.out.println(result[i]);
        }

        }


    static int getMinPagesRequired(int n){

        if(n<10)
            return -1;

        int[] temp = new int[n+1];

        for(int i=0;i<n;i++)
            temp[i] =-1;


        temp[10]=1;

        if(n==11)
            return -1;

        if(n==12)
            return 1;


        if(n>12) {

            temp[12] = 1;

            //temp[22]=2;

            //if(n>24 )
            //temp[24]=2;

            int i = 13;

            while (i < temp.length) {

                if (temp[i - 10] != -1 && temp[i - 12] != -1)
                    temp[i] = Math.min(temp[i - 10] + 1, temp[i - 12] + 1);
                else
                    temp[i] = Math.max(temp[i - 10] + 1, temp[i - 12] + 1);


                if (temp[i] == 0)
                    temp[i] = -1;

                i++;
            }

            if (temp[n] == 0)
                return -1;

            return temp[n];
        }

        return temp[n];
    }

}
