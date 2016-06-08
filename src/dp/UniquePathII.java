package dp;

/**
 * Created by prajesh on 5/30/16.
 */
public class UniquePathII {

    int[][] grid =null;

    public static void main(String[] args) {

        UniquePathII obj = new UniquePathII();


        int[][] input = new int[3][3];

        input[0] = new int[]{0,0,0};
        input[1] = new int[]{0,1,0};
        input[2] = new int[]{0,0,0};


       // System.out.println(obj.uniquePathsWithObstacles(input));



        input = new int[3][2];

        input[0] = new int[]{0,0};
        input[1] = new int[]{1,1};
        input[2] = new int[]{0,0};


        System.out.println(obj.uniquePathsWithObstacles(input));


        input = new int[2][3];

        input[0] = new int[]{0,1,0};
        input[1] = new int[]{0,1,0};



        System.out.println(obj.uniquePathsWithObstacles(input));

    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;

        int n = obstacleGrid[0].length;

        if(m>=1 && n>=1){

            grid = new int[m][n];

            if(obstacleGrid[0][0]==1)
                return 0;

            grid[0][0]=1;

            for(int j=1;j<n;j++){

                if(obstacleGrid[0][j]==1)
                    grid[0][j]=-1;
                else{
                    if(grid[0][j-1]==-1)
                        grid[0][j]=-1;
                    else
                        grid[0][j]=1;
                }
            }

            for(int j=1;j<m;j++){

                if(obstacleGrid[j][0]==1)
                    grid[j][0]=-1;
                else{
                    if(grid[j-1][0]==-1)
                        grid[j][0]=-1;
                    else
                        grid[j][0]=1;
                }



            }

            for(int i=1;i<m;i++){

                for(int j=1;j<n;j++){

                  //  if(obstacleGrid[i][j]!=1)
                   // grid[i][j] = grid[i-1][j]+grid[i][j-1];


                    if(obstacleGrid[i][j]==1)
                        grid[i][j]=-1;
                    else{
                        if(grid[i][j-1]==-1)
                            grid[i][j]=grid[i-1][j];
                        else
                            if(grid[i-1][j]==-1)
                                grid[i][j]=grid[i][j-1];
                            else
                                grid[i][j] = grid[i-1][j]+grid[i][j-1];
                    }


                }

            }

            return (grid[m-1][n-1]==-1)? 0 : grid[m-1][n-1];
        }else
        if(m==1 || n==1)
            return 1;
        else
            return 0;

    }

    void findPaths(int[][] obstacleGrid, int i, int j){

        if(i==0 && j>0){
           if(obstacleGrid[i][j]==1)
               grid[i][j]=-1;
            else{
               if(grid[i][j-1]==-1)
                   grid[i][j]=-1;
               else
                   grid[i][j]=1;
           }

        }

        if(j==0 && i>0){



        }

        if(i > 0 && j > 0){

        }

    }

}

