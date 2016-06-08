/**
 * Created by prajesh on 5/29/16.
 */
public class NumberOfIslands {

     String[][] sets ;
     boolean[][] visited;

     int makeSetCount=0;


    public static void main(String[] args) {

        String[] input1 = new String[]{"11110",
                "11010",
                "11000",
                "00000"};


        char[][] inputArr = inputHelper(input1);

        NumberOfIslands obj = new NumberOfIslands();


     //  System.out.println(obj.numIslands(inputArr));

        input1 = new String[]{"11000",
                "11000",
                "00100",
                "00011"};

        inputArr = inputHelper(input1);

       // System.out.println(obj.numIslands(inputArr));


        input1 = new String[]{"110","010","111"};

        inputArr = inputHelper(input1);

        System.out.println(obj.numIslands(inputArr));



    }


    static char[][] inputHelper(String[] input1){
        char[][] inputArr = new char[input1.length][input1.length];

        for(int i=0;i<input1.length;i++){
            inputArr[i] = input1[i].toCharArray();
        }

        return inputArr;
    }

    void initializeSet(int rows, int cols){

        sets = new String[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                sets[i][j]="-1,-1";
            }
        }

        visited = new boolean[rows][cols];
    }


    void makeSet(int m, int n){
        sets[m][n]=m+","+n;
        makeSetCount++;
    }


    char[] findSet(int m, int n){

        String[] set = sets[m][n].split(",");
        return new char[]{set[0].charAt(0),set[1].charAt(0)};
    }


    void union(int a, int b, int m, int n){

        sets[m][n] = sets[a][b];

    }



    public  int numIslands(char[][] grid) {


        makeSetCount=0;

        int rows = grid.length;

        if(rows>0) {


            int cols = grid[0].length;

            initializeSet(rows, cols);


            int islandCount = 0;

            for (int i = 0; i < rows; i++) {

                for (int j = 0; j < cols; j++) {

                   if(!visited[i][j])
                        processGrid(grid,rows,cols,i,j);

                }


            }


        }
        return this.makeSetCount;
    }


    void processGrid(char[][] grid,int rows, int cols, int i, int j){



        if(i < rows && j < cols && !visited[i][j]) {

            if (grid[i][j] == '1') {

                if (i == 0 && j == 0)
                    makeSet(0, 0);
                else {

                    if (i == 0 && grid[i][j - 1] == '0')
                        makeSet(i, j);
                    if (j == 0 && grid[i - 1][j] == '0')
                        makeSet(i, j);

                    if (i != 0 || j != 0) {
                        if (j > 0 && grid[i][j - 1] == '1')
                            union(i, j - 1, i, j);

                        if (i > 0 && grid[i - 1][j] == '1' && !sets[i-1][j].equals("-1,-1"))
                            union(i - 1, j, i, j);

                        if (i > 0 && j > 0 && sets[i][j].equals("-1,-1"))
                            makeSet(i, j);


                    }
                }

                visited[i][j]=true;
                processGrid(grid, rows, cols, i + 1, j);
                processGrid(grid, rows, cols, i, j + 1);


                processGrid(grid, rows, cols, i - 1, j);
                processGrid(grid, rows, cols, i, j - 1);

            }

        }
    }

}
