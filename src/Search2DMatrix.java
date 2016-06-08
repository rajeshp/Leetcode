/**
 * Created by prajesh on 5/5/16.
 */
public class Search2DMatrix {

    public static void main(String[] args) {


        int[][] matrix = new int[][]{{-5}};


        System.out.println(searchMatrix(matrix, -5));

    }


    public static boolean searchMatrix(int[][] matrix, int target) {

        if(matrix==null) return false;

        for(int row=0;row<matrix.length && matrix[row][0] <= target;row++){

            boolean isFound = binarySearch(matrix, row, 0, matrix[row].length, target);

            if(isFound)
                return true;

        }

        return false;

    }

    static  boolean  binarySearch(int[][] matrix, int row, int low, int high, int target){

        if(low + 1  >= high && matrix[row][low]==target) return true;

        if(low + 1  >= high) return false;

        int mid = (low+high)/2;

        if(target < matrix[row][mid])
            return binarySearch(matrix, row, low, mid, target);
        else
        if(target > matrix[row][mid])
            return binarySearch(matrix, row, mid, high, target);
        else
            return true;

    }
}
