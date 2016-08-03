package hackerearth.dp.twodimensional;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by prajesh on 7/11/16.
 */
public class PalindromeCount {

    public static void main(String[] args) {

       // Scanner scanner = new Scanner(System.in);
        //System.out.println(getPalindromeCount(scanner.next()));

        System.out.println(getPalindromeCount("lqjkkcatujmwjc"));
    }

    static int getPalindromeCount(String s){

        int len = s.length();

        boolean[][] dp = new boolean[len][len];

       // Arrays.fill(dp,0);
        int maxCount=0, count=0;

        for(int i=0;i<s.length();i++){
            dp[i][i]=true;
            count++;
        }



        for(int j=1;j<len;j++){

            for(int i=0;i+j<len;i++){

                if(s.charAt(i)==s.charAt(i+j)){

                    if(((i+1 >= (i+j-1)) && dp[i+1][i+j-1]) || j==1) {
                        dp[i][j] = true;
                        count++;
                    }

                }


               // if(dp[i][j] > maxCount)
                 //   maxCount = dp[i][j];
            }

        }

        return count;
    }

}
