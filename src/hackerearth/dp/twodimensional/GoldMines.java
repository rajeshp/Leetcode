package hackerearth.dp.twodimensional;

import java.util.Scanner;

import java.util.Set;
import java.util.HashSet;

/**
 * Created by prajesh on 7/12/16.
 */
public class GoldMines {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] a = new int[rows+1][cols+1];

        for(int i=1;i<=rows;i++) {

            for(int j=1;j<=cols;j++){
                a[i][j] = scanner.nextInt();
            }

        }

        int[][] dp = getGoldValueDP(a,rows, cols);

        int cases = scanner.nextInt();

        long[] result = new long[cases];


        for(int i=0;i<cases;i++){

            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();


            result[i] = getGoldValueQueryValue(a, rows,cols, x1,y1,x2,y2);
        }

        for(int i=0;i<cases;i++){
            System.out.println(result[i]);
        }

    }


    static int[][] getGoldValueDP(int[][] a, int rows, int cols){

        int sum=0;

        for(int i=0;i<=rows;i++){

            sum=0;

            for(int j=0;j<=cols;j++) {

                sum+=a[i][j];

                a[i][j]=sum;

            }
        }

        return a;
    }


    static long getGoldValueQueryValue(int[][] dp, int rows, int cols,int x1, int y1, int x2, int y2){

        long result = 0;

        if((x2 >=x1 && x1 >=0 && x2<=rows) && (y2>=y1 && y1>=0 && y2<=cols)){

            for(int i=x1;i<=x2;i++){

                if(y1!=y2)
                   // result+=dp[i][y2] - dp[i][y1];
                    result+=dp[i][y2] - dp[i][y1-1];
                else
                    result+=dp[i][y2] - dp[i][y2-1];
            }
        }


            return result;
    }

}
