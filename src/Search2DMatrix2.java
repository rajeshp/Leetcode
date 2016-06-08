/**
 * Created by prajesh on 6/3/16.
 */
public class Search2DMatrix2 {

    public static void main(String[] args) {

        Search2DMatrix2 obj = new Search2DMatrix2();


        int[][] input = new int[5][5];

        input[0]=new int[] {1, 4,  7, 11, 15};
        input[1]=new int[] {2, 5,  8, 12, 19};
        input[2]=new int[] {3, 6,  9, 16, 22};
        input[3]=new int[] {10, 13, 14, 17, 24};
        input[4]=new int[] {18, 21, 23, 26, 30};




        System.out.println(obj.searchMatrix(input, 7));

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null)
            return false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i=0;i<rows;i++){

            if(matrix[i][0] < target && matrix[i][cols-1]>target){
                boolean found = searchColumn(matrix, i, target, 0, cols);

                if(found)
                    return true;
            }

        }
        return false;

    }

    boolean searchColumn(int[][] matrix, int row, int target, int low, int high){

        if(low >=high)
            return false;

        int mid = (low+high)/2;

        if(matrix[row][mid]==target)
            return true;
        else
        if(matrix[row][mid] > target)
            return searchColumn(matrix,row,target,low, mid);
        else
            return searchColumn(matrix, row, target, mid+1, high);


    }


}
