package hackerearth.dp.twodimensional;

import java.util.Scanner;

/**
 * Created by prajesh on 7/10/16.
 */
public class MagicNumbers {

    public static void main(String[] args) {

        System.out.println(getStrength("abaa"));
        System.out.println(getStrength("cbc"));
        System.out.println(getStrength("babbbbaabbababbaaaaababbaaabbbbaaabbbababbbbabaabababaabaaabbbabababbbabababaababaaaaabbabaaaabaaaab"));

        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();

        long[] result = new long[cases];

        for(int i=0;i<cases;i++) {

            result[i] = getStrength(scanner.next());

        }

        for(int i=0;i<cases;i++) {
            System.out.println(result[i]);
        }

    }


    static long getStrength(String s){

        if(s.length()==0 || s==null)
            return 0;


        int len = s.length();

        boolean[][] dp = new boolean[len][len];

        long strength=0 ;

        for(int i=0;i<len;i++){
                    dp[i][i]=true;
            strength++;  // Math.pow(1,2)~=1
        }

        //here i is the length of substring which varies from 2 to len;
        for(int i=1;i<len;i++){

            for(int j=0;j+i<len;j++){

                if(s.charAt(j)==s.charAt(j+i)){

                    if(dp[j+1][i+j-1] || j-i==1) {
                        //dp[i][j] = true;
                        dp[j][i+j]=true;
                        strength += Math.pow(i, 2);
                    }
                }

            }

        }


        return strength;
    }

}
