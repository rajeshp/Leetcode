import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prajesh on 6/5/16.
 */
public class PascalsTraingle {

    public static void main(String[] args) {

        List<Integer> list = getRow(5);

        for(int i : list){
            System.out.print(i+" ");
        }

    }

    public static List<Integer> getRow(int rowIndex) {

       List<Integer> result = new ArrayList<>();

        //result.add(1);

        for(int i=1;i<=rowIndex;i++){

            result=calculateNextRow(result);

        }

        return result;
    }


    static List<Integer> calculateNextRow(List<Integer> row){

        ArrayList<Integer> nextRow = new ArrayList<>();

        nextRow.add(1);

        for(int i=1;i<row.size();i++){
            nextRow.add(row.get(i)+row.get(i-1));
        }

        nextRow.add(1);

        return nextRow;
    }

}
