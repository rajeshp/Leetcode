package hackerearth.dp;

import java.util.Scanner;

/**
 * Created by prajesh on 7/7/16.
 */
public class XSquareAndChoclates {

    public static void main(String[] args) {

       // System.out.println(getMaxChoclates("SSSSSSSSS".toCharArray()));
        //System.out.println(getMaxChoclates("CCCCCCCCC".toCharArray()));
        //System.out.println(getMaxChoclates("SSSSCSCCC".toCharArray()));
        //System.out.println(getMaxChoclates("SSCCSSSCS".toCharArray()));


        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();

        long[] res = new long[cases];

        for(int i=0;i<cases;i++){
            res[i] = getMaxChoclates(scanner.next().toCharArray());
        }


        for(int i=0;i<cases;i++){
            System.out.println(res[i]);
        }

    }

    static long getMaxChoclates(char[] c){

        if(c.length<3)
            return c.length;

        int i=0, j=2;

        long count=0;

        while(j<c.length){

            if(c[i]==c[j] && c[i+1]==c[j]) {

                count++;
                i++;
                j++;

            }else{
                i=j+1;
                j=i+2;
            }
        }


        return count+c.length-i;
    }

}
