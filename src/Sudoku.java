import java.util.HashSet;
import java.util.Set;

/**
 * Created by prajesh on 5/21/16.
 */
public class Sudoku {

    public static void main(String[] args) {
        String[] inputArr = new String[]{"....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",".15......",".....2...",".2.9.....","..4......"};

        char[][] board = new char[inputArr.length][inputArr.length];

        for(int i=0;i<inputArr.length;i++){
            board[i]=inputArr[i].toCharArray();
        }

        System.out.println(isValidSudoku(board));
    }


    public static boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        Set<Character> set = null;

        char c='\0';

        for(int i=0;i<rows;i++){
            set = new HashSet<Character>();
            for(int j=0;j<cols;j++){
                c=board[i][j];
                if(c!='.' && !set.add(c))
                    return false;
            }
        }


        for(int i=0;i<cols;i++){
            set = new HashSet<Character>();
            for(int j=0;j<rows;j++){
                c=board[j][i];
                if( c!='.' && !set.add(c))
                    return false;
            }
        }


        for(int i=0;i<rows;i+=3){

            for(int j=0;j<cols;j+=3){

                if(isSectionValid(board,i,j))
                    return false;
            }


        }

        return true;
    }

    static boolean  isSectionValid(char[][]board, int m, int n){

        Set<Character> set = new HashSet<>();
        char c='\0';

        for(int i=m;i<m+3;i++){

            for(int j=n;j<n+3;j++){
                c = board[i][j];
                if(c!='.' && !set.add(c))
                    return false;
            }
        }

        return false;
    }
}
