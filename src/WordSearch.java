import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by prajesh on 8/1/16.
 */
public class WordSearch {

    public static void main(String[] args) {

        String[] strs = {"ab"};

        char[][] board = new char[strs.length][];

        for(int i=0;i<strs.length;i++){
            board[i] = strs[i].toCharArray();
        }

        System.out.println(exist(board, "ba"));
       // System.out.println(exist(board, "SEE"));
       // System.out.println(exist(board, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = null;

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<word.length();i++)
            map.put(word.charAt(i), i);

        for(int i=0;i<rows;i++){

            for(int j=0;j<cols;j++){

                if(map.containsKey(board[i][j])){
                    visited=new boolean[rows][cols];
                    visited[i][j]=true;
                    boolean found = checkIfNextCharExists(i, j, word, 1, board, visited,rows, cols);
                    if(found)
                        return true;
                }

            }

        }

        return false;
    }

   static boolean checkIfNextCharExists(int row, int col, String s, int index, char[][] board, boolean[][] visited, int trows, int tcols){

        if(index==s.length())
            return true;


        boolean found=false;

        if(col+1 < tcols && board[row][col+1]==s.charAt(index) && !visited[row][col+1]){
            visited[row][col+1]=true;
            found = checkIfNextCharExists(row, col+1, s, index+1, board,visited, trows, tcols);
        }

        if(col-1 > 0 && board[row][col-1]==s.charAt(index) && !visited[row][col-1]){
            visited[row][col-1]=true;
            found = checkIfNextCharExists(row, col-1, s, index+1, board,visited, trows, tcols);
        }

        if(row-1 > 0 && board[row-1][col]==s.charAt(index) && !visited[row-1][col]){
            visited[row-1][col]=true;
            found = checkIfNextCharExists(row-1, col, s, index+1, board, visited, trows, tcols);
        }

        if(row+1 < trows && board[row+1][col]==s.charAt(index) && !visited[row+1][col]){
            visited[row+1][col]=true;
            found = checkIfNextCharExists(row+1, col, s, index+1, board, visited, trows, tcols);
        }

        return found;

    }

}
