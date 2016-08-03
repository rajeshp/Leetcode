package hackerearth.dp;

import java.util.Scanner;

/**
 * Created by prajesh on 7/8/16.
 */
public class IntelligentGirl {


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int[] result = getPositiveIntegersToRight(scanner.nextLine());

        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }


    static int[] getPositiveIntegersToRight(String s) {

        int[] res = new int[s.length()];


        int rightCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i)-48) % 2 == 0)
                rightCount++;
        }

        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i)-48) % 2 == 0)
                res[i] = rightCount--;
            else
                res[i] = rightCount;
        }

        return res;
    }


}
