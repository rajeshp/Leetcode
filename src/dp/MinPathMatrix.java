package dp;

/**
 * Created by prajesh on 5/18/16.
 */
public class MinPathMatrix {

    public static void main(String[] args) {

        int[][] input1 = new int[][]{{1}};

        System.out.println(minPathSum(input1));

    }


    public static int minPathSum(int[][] grid) {

        if(grid==null || grid.length==0)
                return -1;

        int row=grid.length-1, col=grid[0].length-1;

        if(row <0 || col<0)
                return -1;

        int i=0,j=0;

        int minSum =0, currSum=0;

        while(true){

            if(i==row && j==col){
               // minSum+=grid[i][j];
                break;
            }

            if(i<row && j<col){

                if(grid[i+1][j] < grid[i][j+1]){
                    minSum+=grid[i+1][j];
                    i++;
                }else{
                    minSum+=grid[i][j+1];
                    j++;
                }

            }else {
                if (i < row) {
                    minSum += grid[i + 1][j];
                    i++;
                }

                if (j < col) {
                    minSum += grid[i][j + 1];
                    j++;
                }

            }

        }

        return minSum;
    }


}
